package com.estcium.gemini9.api;


import com.estcium.gemini9.service.StarSystemService;
import jparsec.ephem.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/starsystems")
public class StarSystemController {

    @Autowired
    private StarSystemService starSystemService;

    @GetMapping("")
    public ResponseEntity<?> getStarSystem(){

        return ResponseEntity.ok(Target.TARGET.values());
    }

}
