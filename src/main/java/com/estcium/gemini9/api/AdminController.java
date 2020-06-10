package com.estcium.gemini9.api;

import com.estcium.gemini9.model.User;
import com.estcium.gemini9.service.RoleService;
import com.estcium.gemini9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @GetMapping("/add") // Map ONLY POST Requests
    public ResponseEntity<?> addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String password,@RequestParam() Integer role) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        n.setRole(roleService.findRoleById(role));
        userService.save(n);
        return ResponseEntity.ok("Saved");
    }
}
