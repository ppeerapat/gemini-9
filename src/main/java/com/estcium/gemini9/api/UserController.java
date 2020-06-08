package com.estcium.gemini9.api;

import com.estcium.gemini9.model.User;
import com.estcium.gemini9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public @ResponseBody User findById(@PathVariable Integer id){
        User response = userService.findById(id);
        return response;
    }
//
//    @GetMapping("/add") // Map ONLY POST Requests
//    public @ResponseBody
//    String addNewUser (@RequestParam String name
//            , @RequestParam String email, @RequestParam String password) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
//        n.setPassword(password);
//        userService.save(n);
//        return "Saved";
//    }
//
//    @GetMapping("all")
//    public String all(Model model) {
//        model.addAttribute("userList", userService.findAll());
//        return "all";
//    }

}
