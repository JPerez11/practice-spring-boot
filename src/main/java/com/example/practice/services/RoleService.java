package com.example.practice.services;

import com.example.practice.dto.request.CreateRoleRequestDto;
import com.example.practice.dto.response.RoleResponseDto;

import java.util.List;

public interface RoleService {

    RoleResponseDto createRole(CreateRoleRequestDto roleRequest);
    RoleResponseDto getRole(Long roleId);
    List<RoleResponseDto> listRoles();

}
