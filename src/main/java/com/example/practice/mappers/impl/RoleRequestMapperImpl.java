package com.example.practice.mappers.impl;

import com.example.practice.dto.request.CreateRoleRequestDto;
import com.example.practice.entities.RoleEntity;
import com.example.practice.mappers.RoleRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleRequestMapperImpl implements RoleRequestMapper {
    @Override
    public RoleEntity toEntity(CreateRoleRequestDto roleRequest) {

        if (roleRequest == null) {
            return null;
        }

        RoleEntity role = new RoleEntity();
        role.setName( roleRequest.getName() );
        role.setDescription( roleRequest.getDescription() );

        return role;
    }
}
