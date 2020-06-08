package com.estcium.gemini9.service;

import com.estcium.gemini9.configuration.authentication.PasswordEncoderProvider;
import com.estcium.gemini9.model.User;
import com.estcium.gemini9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoderProvider passwordEncoder;

    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(User u){
        u.setPassword(passwordEncoder.passwordEncoder().encode(u.getPassword()));
        System.out.println(u);
        return userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = findByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), new ArrayList<>());
    }
}
