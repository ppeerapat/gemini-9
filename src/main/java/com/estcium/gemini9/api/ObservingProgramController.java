package com.estcium.gemini9.api;

import com.estcium.gemini9.model.ObservingProgram;
import com.estcium.gemini9.model.base.Message;
import com.estcium.gemini9.service.AstroDataService;
import com.estcium.gemini9.service.ObservingProgramService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/observingprogram")
public class ObservingProgramController {

    @Autowired
    ObservingProgramService observingProgramService;

    @Autowired
    AstroDataService astroDataService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getObservingProgram(@PathVariable Integer id){
        return ResponseEntity.ok(observingProgramService.getObservingProgram(id));
    }

    @RequestMapping("/create")
    public ResponseEntity<?> createObservingProgram(@RequestBody ObservingProgram op){
        try{
            return ResponseEntity.ok(observingProgramService.createObservingProgram(op,op.getSciencePlan().getId()));
        }catch (Exception e){
            Message res = new Message(e.getMessage());
            return ResponseEntity.ok(res);
        }

    }

    @GetMapping(
            value = "/pic/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable Integer id) throws IOException {
        try {
            InputStream in = getClass()
                    .getResourceAsStream("/local/images/cosmicreef.jpg");
            return IOUtils.toByteArray(in);
        }catch (Exception e){
            return null;
        }

    }
    @GetMapping(path = "/upload/{id}")
    public @ResponseBody String upload(@PathVariable Integer id){
        try {
            astroDataService.upload(id);
            return "true";
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
