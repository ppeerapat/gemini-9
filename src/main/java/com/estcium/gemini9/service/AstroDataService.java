package com.estcium.gemini9.service;

import com.estcium.gemini9.model.ObservingProgram;
import com.estcium.gemini9.model.base.AstroData;
import com.estcium.gemini9.repository.AstroDataRepository;
import com.estcium.gemini9.repository.ObservingProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class AstroDataService {

    @Autowired
    AstroDataRepository astroDataRepository;

    @Autowired
    ObservingProgramRepository observingProgramRepository;
    public void upload(Integer id) throws Exception{
        ObservingProgram op = observingProgramRepository.findById(id).get();
        if(op==null){
            throw new Exception("Observing Program not found");
        }

        try {
            ClassPathResource img = new ClassPathResource("local/images/cosmicreef.jpg");
            byte[] arrayData = new byte[(int) img.contentLength()];
            img.getInputStream().read(arrayData);
            AstroData as = new AstroData();
            as.setName("Test");
            as.setType("jpg");
            as.setData(arrayData);
            as.setObservingProgram(op);

            astroDataRepository.save(as);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
