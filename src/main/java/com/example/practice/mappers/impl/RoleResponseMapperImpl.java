package com.example.practice.mappers.impl;

import com.example.practice.dto.response.RoleResponseDto;
import com.example.practice.entities.RoleEntity;
import com.example.practice.mappers.RoleResponseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RoleResponseMapperImpl implements RoleResponseMapper {

    @Override
    public RoleResponseDto toResponse(RoleEntity roleEntity) {

        if (roleEntity == null) {
            return null;
        }

        RoleResponseDto response = new RoleResponseDto();

        response.setName( roleEntity.getName() );
        response.setDescription( roleEntity.getDescription() );

        return response;
    }

    @Override
    public List<RoleResponseDto> toResponseList(List<RoleEntity> roleEntityList) {

        if (roleEntityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<RoleResponseDto> list = new ArrayList<>(roleEntityList.size());

        for (RoleEntity role : roleEntityList) {
            list.add( toResponse(role) );
        }

        return list;
    }
}
