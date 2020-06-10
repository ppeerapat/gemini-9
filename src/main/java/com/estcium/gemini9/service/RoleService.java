package com.estcium.gemini9.service;

import com.estcium.gemini9.model.Role;
import com.estcium.gemini9.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findRoleById(Integer id){
        return roleRepository.findById(id).get();
    }


}
