package com.estcium.gemini9.api;

import com.estcium.gemini9.model.User;
import com.estcium.gemini9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User response = userService.findById(id);
        //System.out.println("aaaaaaaa");
        return new ResponseEntity<User>(response, HttpStatus.OK);
    }

    @GetMapping("/add") // Map ONLY POST Requests
    public ResponseEntity<?> addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userService.save(n);
        return ResponseEntity.ok("Saved");
    }

//    @GetMapping("all")
//    public String all(Model model) {
//        model.addAttribute("userList", userService.findAll());
//        return "all";
//    }

}
