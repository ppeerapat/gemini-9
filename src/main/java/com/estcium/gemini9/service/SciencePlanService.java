package com.estcium.gemini9.service;

import com.estcium.gemini9.model.DataProcRequirement;
import com.estcium.gemini9.model.base.Enumerator;
import com.estcium.gemini9.model.SciencePlan;
import com.estcium.gemini9.model.User;
import com.estcium.gemini9.model.request.SciencePlanRequest;
import com.estcium.gemini9.repository.DPRRepository;
import com.estcium.gemini9.repository.Gemini;
import com.estcium.gemini9.repository.SciencePlanRepository;
import com.estcium.gemini9.repository.UserRepository;
import edu.gemini.app.ocs.model.VirtualTelescope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SciencePlanService {

    @Autowired
    SciencePlanRepository sciencePlanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DPRRepository dprRepository;

    public SciencePlan createSciencePlan(SciencePlanRequest req) {
        User creator = userRepository.findById(req.getCreator()).get();
        if(creator==null){
            return null;
        }
        try {
            DataProcRequirement dpr = new DataProcRequirement();
            dpr.setFileType(req.getFileType());
            dpr.setFileQuality(req.getFileQuality());
            dpr.setColorType(req.getColorType());
            dpr.setBrightness(req.getBrightness());
            dpr.setContrast(req.getContrast());
            dpr.setSaturation(req.getSaturation());
            //System.out.println(dpr.toString());

            //dprRepository.save(dpr);
            SciencePlan sciencePlan = new SciencePlan();
            sciencePlan.setName(req.getName());
            sciencePlan.setCreatorUser(creator);
            sciencePlan.setAnnotations(req.getAnnotations());
            sciencePlan.setDpr(dpr);
            sciencePlan.setStatus(Enumerator.STATUS.DRAFT);
            sciencePlan.setStartDate(req.getStartDate());
            sciencePlan.setEndDate(req.getEndDate());
            sciencePlan.setFunding(req.getFunding());
            sciencePlan.setObjectives(req.getObjectives());
            sciencePlan.setTarget(req.getTarget());
            sciencePlan.setTelescopeLoc(req.getTelescopeLoc());
            //System.out.println((SciencePlan) sciencePlan);
            sciencePlanRepository.save(sciencePlan);
            return sciencePlan;
        }catch (Error e){
            System.out.println(e);
        }
    return null;
    }

    public SciencePlan getSciencePlan(Integer id){
        return sciencePlanRepository.findById(id).get();
    }
    public Iterable<SciencePlan> getAllSciencePlan(){
        return sciencePlanRepository.findAll();
    }

    public SciencePlan updateSciencePlan(SciencePlan sciencePlan){
        return sciencePlanRepository.save(sciencePlan);
    }

    public SciencePlan submitSciencePlan(Integer id, Integer uid) throws Exception {
        SciencePlan sp = sciencePlanRepository.findById(id).get();
        if(sp.getStatus()!= Enumerator.STATUS.TESTED){
            throw new Exception("Science Plan is not TESTED");
        }
        User submitter = userRepository.findById(uid).get();
        if(submitter==null){
            throw new Exception("User not found");
        }
        if(sp.validate()==false){
            throw new Exception("Science plan is not valid");
        }
        sp.setSubmitterUser(submitter);
        sp.setStatus(Enumerator.STATUS.SUBMITTED);
        return sciencePlanRepository.save(sp);
    }

    public SciencePlan testSciencePlan(Integer id)throws Exception{
        SciencePlan sp = sciencePlanRepository.findById(id).get();
        if(sp==null){
            throw new Exception("Science Plan not found");
        }
        if(sp.getStatus()!= Enumerator.STATUS.DRAFT){
            throw new Exception("Science Plan is not DRAFT");
        }
        Gemini system = new Gemini();

        VirtualTelescope vt = system.getVirtualTelescopes().get(0);
        if(vt==null){
            throw new Exception("Virtual Telescope is unavailable");
        }
        if(vt.getSciencePlan()!=null){
            throw new Exception("Virtual Telescope is Busy");
        }
        vt.setSciencePlan(sp);
        if(vt.executeSciencePlan()){
            sp.setStatus(Enumerator.STATUS.TESTED);
        }else{
            sp.setStatus(Enumerator.STATUS.FAILED);
        }
        vt.setSciencePlan(null);
        return sciencePlanRepository.save(sp);
    }

    public SciencePlan validateSciencePlan(Integer id, Integer uid) throws Exception{
        SciencePlan sp = sciencePlanRepository.findById(id).get();
        if(sp.getStatus()!= Enumerator.STATUS.SUBMITTED){
            throw new Exception("Science Plan is not SUBMITTED");
        }
        User validator = userRepository.findById(uid).get();
        if(validator==null){
            throw new Exception("User not found");
        }
        if(!validator.getRole().equals("OBSERVER")){
            throw new Exception("User is not OBSERVER");
        }
        if(sp.validate()==false){
            throw new Exception("Science plan is not valid");
        }
        sp.setValidatorUser(validator);
        sp.setStatus(Enumerator.STATUS.COMPLETE);
        return sciencePlanRepository.save(sp);
    }
}
