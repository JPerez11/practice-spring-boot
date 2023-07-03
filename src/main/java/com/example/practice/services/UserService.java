package com.example.practice.services;

import com.example.practice.dto.request.CreateUserRequestDto;
import com.example.practice.dto.request.UpdateUserRequestDto;
import com.example.practice.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(CreateUserRequestDto userRequest);
    UserResponseDto getUserById(Long userId);
    List<UserResponseDto> listUsers();
    UserResponseDto updateUser(UpdateUserRequestDto userRequest, Long userId);

}
