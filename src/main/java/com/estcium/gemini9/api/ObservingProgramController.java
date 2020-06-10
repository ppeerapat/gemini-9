package com.estcium.gemini9.api;

import com.estcium.gemini9.service.ObservingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/observingprogram")
public class ObservingProgramController {

    @Autowired
    ObservingProgramService observingProgramService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSciencePlan(@PathVariable Integer id){
        return ResponseEntity.ok(observingProgramService.getObservingProgram(id));
    }

}
