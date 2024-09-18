package com.AnandCoder.SmartClassRoom.controller;

import com.AnandCoder.SmartClassRoom.Model.Login;
import com.AnandCoder.SmartClassRoom.Model.User;
import com.AnandCoder.SmartClassRoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoReController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.createUser(user);
            return "User registered successfully";
        } catch (Exception e) {
            return "Error registering user: " + e.getMessage();
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Login login) {
        User foundUser = userService.findByUsername(login.getUsername());
        if (foundUser != null && passwordEncoder.matches(login.getPassword(), foundUser.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
