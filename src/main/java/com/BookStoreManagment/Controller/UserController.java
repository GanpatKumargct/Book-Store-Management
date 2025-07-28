package com.BookStoreManagment.Controller;

import com.BookStoreManagment.Entity.User;
import com.BookStoreManagment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    //register
    @PostMapping("/register")

    public ResponseEntity<String> register(@RequestBody User user){
        try {
            userService.register(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String Password){
        if (userService.validateUser(email, Password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
