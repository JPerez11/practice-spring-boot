package com.example.practice.services;

import com.example.practice.dto.request.LoginCredentials;
import com.example.practice.dto.response.JwtResponse;

public interface AuthService {

    JwtResponse login(LoginCredentials credentials);

}
