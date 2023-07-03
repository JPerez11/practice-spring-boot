package com.example.practice.services.impl;

import com.example.practice.dto.request.CreateUserRequestDto;
import com.example.practice.dto.request.UpdateUserRequestDto;
import com.example.practice.dto.response.UserResponseDto;
import com.example.practice.entities.RoleEntity;
import com.example.practice.entities.UserEntity;
import com.example.practice.mappers.UserRequestMapper;
import com.example.practice.mappers.UserResponseMapper;
import com.example.practice.repositories.RoleRepository;
import com.example.practice.repositories.UserRepository;
import com.example.practice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponseDto createUser(CreateUserRequestDto userRequest) {
        UserEntity user = userRequestMapper.toEntity(userRequest);
        RoleEntity role = roleRepository.findRoleEntityByName(userRequest.getRole()).orElse(null);
        if (role == null) {
            //TODO create a custom exception
        }
        user.setRole(role);
        return userResponseMapper.toResponse(
                userRepository.save(user)
        );
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            //TODO create a custom exception
        }
        return userResponseMapper.toResponse(user);
    }

    @Override
    public List<UserResponseDto> listUsers() {
        List<UserEntity> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            //TODO create a custom exception
        }
        return userResponseMapper.toResponseList(userList);
    }

    @Override
    public UserResponseDto updateUser(UpdateUserRequestDto userRequest, Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new NullPointerException();
            //TODO create a custom exception
        }
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());

        return userResponseMapper.toResponse(
                userRepository.save(user)
        );
    }
}
