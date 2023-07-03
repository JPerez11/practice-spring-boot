package com.example.practice.mappers;

import com.example.practice.dto.response.RoleResponseDto;
import com.example.practice.entities.RoleEntity;

import java.util.List;

public interface RoleResponseMapper {

    RoleResponseDto toResponse(RoleEntity roleEntity);

    List<RoleResponseDto> toResponseList(List<RoleEntity> roleEntityList);

}
