package com.estcium.gemini9.service;

import com.estcium.gemini9.model.User;
import com.estcium.gemini9.repository.UserRepository;
import com.estcium.gemini9.util.PasswordEncoderProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoderProvider passwordEncoder = new PasswordEncoderProvider();

    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(User u){
        u.setPassword(passwordEncoder.passwordEncoder().encode(u.getPassword()));
        //System.out.println(u);
        return userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = findByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
            list.add(new SimpleGrantedAuthority(u.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), list );
    }

    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
