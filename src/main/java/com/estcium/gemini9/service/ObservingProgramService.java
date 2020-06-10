package com.estcium.gemini9.service;

import com.estcium.gemini9.model.ObservingProgram;
import com.estcium.gemini9.repository.ObservingProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservingProgramService {

    @Autowired
    ObservingProgramRepository observingProgramRepository;

    public ObservingProgram createObservingProgram(ObservingProgram op){
        return observingProgramRepository.save(op);
    }

    public ObservingProgram getObservingProgram(Integer id){
        return observingProgramRepository.findById(id).get();
    }
}
