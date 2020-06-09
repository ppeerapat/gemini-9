package com.estcium.gemini9.api;

import com.estcium.gemini9.model.LoginRequest;
import com.estcium.gemini9.model.LoginResponse;
import com.estcium.gemini9.service.UserService;
import com.estcium.gemini9.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception
    {
        userService.authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        final UserDetails userDetails =
                userService.loadUserByUsername(authenticationRequest.getUsername());
        //JwtUserDetails userDetails = new UserDetails();
        //userDetails.setUsername(authenticationRequest.getUsername());


        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token,"Successful"));
    }


}
