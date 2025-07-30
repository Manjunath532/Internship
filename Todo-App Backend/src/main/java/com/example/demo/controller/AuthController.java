package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.*;


import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.SignupRequest;

import com.example.demo.service.AuthService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}

