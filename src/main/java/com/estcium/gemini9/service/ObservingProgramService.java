package com.estcium.gemini9.service;

import com.estcium.gemini9.model.ObservingProgram;
import com.estcium.gemini9.model.SciencePlan;
import com.estcium.gemini9.model.base.Enumerator;
import com.estcium.gemini9.repository.LensRepository;
import com.estcium.gemini9.repository.ObservingProgramRepository;
import com.estcium.gemini9.repository.SciencePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservingProgramService {

    @Autowired
    ObservingProgramRepository observingProgramRepository;

    @Autowired
    SciencePlanRepository sciencePlanRepository;

    @Autowired
    LensRepository lensRepository;

    public ObservingProgram createObservingProgram(ObservingProgram op,Integer id) throws Exception{
        op.setLens(lensRepository.save(op.getLens()));
        SciencePlan sp = sciencePlanRepository.findById(id).get();
        if(sp==null){
            throw new Exception("Science Plan not found");
        }else if(sp.getStatus()!= Enumerator.STATUS.COMPLETE){
            throw new Exception("Science Plan is not COMPLETE");
        }
        op.setSciencePlan(sp);
        return observingProgramRepository.save(op);
    }

    public ObservingProgram getObservingProgram(Integer id){
        return observingProgramRepository.findById(id).get();
    }

}
