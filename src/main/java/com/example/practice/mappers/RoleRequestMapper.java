package com.example.practice.mappers;

import com.example.practice.dto.request.CreateRoleRequestDto;
import com.example.practice.entities.RoleEntity;

public interface RoleRequestMapper {

    RoleEntity toEntity(CreateRoleRequestDto createRoleRequest);

}
