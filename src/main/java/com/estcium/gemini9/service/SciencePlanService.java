package com.estcium.gemini9.service;

import com.estcium.gemini9.model.DataProcRequirement;
import com.estcium.gemini9.model.Enumerator;
import com.estcium.gemini9.model.SciencePlan;
import com.estcium.gemini9.model.User;
import com.estcium.gemini9.model.request.SciencePlanRequest;
import com.estcium.gemini9.repository.DPRRepository;
import com.estcium.gemini9.repository.SciencePlanRepository;
import com.estcium.gemini9.repository.UserRepository;
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
        if(sp.getStatus()== Enumerator.STATUS.SUBMITTED){
            throw new Exception("Already submit");
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
}
