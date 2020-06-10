package com.estcium.gemini9.service;

import com.estcium.gemini9.model.DataProcRequirement;
import com.estcium.gemini9.repository.DPRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DPRService{

    @Autowired
    DPRRepository dprRepository;

    public DataProcRequirement get(Integer id){
        return dprRepository.findById(id).get();
    }


}
