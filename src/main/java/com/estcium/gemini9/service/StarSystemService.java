package com.estcium.gemini9.service;

import com.estcium.gemini9.model.StarSystem;
import com.estcium.gemini9.repository.StarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarSystemService {

    @Autowired
    StarSystemRepository starSystemRepository;

    public Iterable<StarSystem> getAllStarSystem(){
        return starSystemRepository.findAll();
    }

}
