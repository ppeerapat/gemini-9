package com.estcium.gemini9.api;

import com.estcium.gemini9.model.User;
import com.estcium.gemini9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User response = userService.findById(id);
        //System.out.println("aaaaaaaa");
        return new ResponseEntity<User>(response, HttpStatus.OK);
    }



//    @GetMapping("all")
//    public String all(Model model) {
//        model.addAttribute("userList", userService.findAll());
//        return "all";
//    }

}
