package com.example.practice.controllers;

import com.example.practice.dto.request.LoginCredentials;
import com.example.practice.dto.response.JwtResponse;
import com.example.practice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginCredentials loginCredentials) {
        return ResponseEntity.ok(authService.login(loginCredentials));
    }

}
