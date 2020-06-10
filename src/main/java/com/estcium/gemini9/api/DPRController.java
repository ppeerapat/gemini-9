package com.estcium.gemini9.api;

import com.estcium.gemini9.model.DataProcRequirement;
import com.estcium.gemini9.service.DPRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dpr")
public class DPRController {

    @Autowired
    private DPRService dprService;

    @GetMapping("/{id}")
    public ResponseEntity<DataProcRequirement> getDPR(@PathVariable Integer id){
        return new ResponseEntity<DataProcRequirement>(dprService.get(id), HttpStatus.OK);
    }

}
