package com.example.practice.services.impl;

import com.example.practice.dto.request.CreateUserRequestDto;
import com.example.practice.dto.request.UpdateUserRequestDto;
import com.example.practice.dto.response.UserResponseDto;
import com.example.practice.entities.RoleEntity;
import com.example.practice.entities.UserEntity;
import com.example.practice.exceptions.DocumentNumberAlreadyExistsException;
import com.example.practice.exceptions.EmailAlreadyExistsException;
import com.example.practice.exceptions.NoDataFoundException;
import com.example.practice.exceptions.RoleNotFoundException;
import com.example.practice.exceptions.UserNotFoundException;
import com.example.practice.mappers.UserRequestMapper;
import com.example.practice.mappers.UserResponseMapper;
import com.example.practice.repositories.RoleRepository;
import com.example.practice.repositories.UserRepository;
import com.example.practice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(CreateUserRequestDto userRequest) {
        UserEntity user = userRequestMapper.toEntity(userRequest);
        if (userRepository.existsByDocumentNumber(user.getDocumentNumber())) {
            throw new DocumentNumberAlreadyExistsException();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        RoleEntity role = roleRepository.findRoleEntityByName(userRequest.getRoleName()).orElse(null);
        if (role == null) {
            throw new RoleNotFoundException();
        }
        user.setPassword( passwordEncoder.encode(user.getPassword()) );
        user.setRole(role);
        return userResponseMapper.toResponse(
                userRepository.save(user)
        );
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return userResponseMapper.toResponse(user);
    }

    @Override
    public List<UserResponseDto> listUsers() {
        List<UserEntity> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userResponseMapper.toResponseList(userList);
    }

    @Override
    public UserResponseDto updateUser(UpdateUserRequestDto userRequest, Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        }
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());

        return userResponseMapper.toResponse(
                userRepository.save(user)
        );
    }
}
