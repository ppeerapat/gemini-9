package com.estcium.gemini9.api;

import com.estcium.gemini9.model.LoginRequest;
import com.estcium.gemini9.model.LoginResponse;
import com.estcium.gemini9.service.UserService;
import com.estcium.gemini9.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
        userService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails =
                userService.loadUserByUsername(authenticationRequest.getUsername());
        //JwtUserDetails userDetails = new UserDetails();
        //userDetails.setUsername(authenticationRequest.getUsername());


        final String token = jwtUtil.generateJwtToken(userDetails);
        return new ResponseEntity(new LoginResponse(token, "Successful", userDetails.getAuthorities().toString()), HttpStatus.OK);
    }
}
