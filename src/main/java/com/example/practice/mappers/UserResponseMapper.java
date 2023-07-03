package com.example.practice.mappers;

import com.example.practice.dto.response.UserResponseDto;
import com.example.practice.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    @Mapping(target = "role", source = "role.name")
    UserResponseDto toResponse(UserEntity userEntity);

    List<UserResponseDto> toResponseList(List<UserEntity> userList);

}
