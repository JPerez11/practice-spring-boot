package com.example.practice.mappers;

import com.example.practice.dto.response.UserResponseDto;
import com.example.practice.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    @Mapping(target = "roleName", source = "role.name")
    UserResponseDto toResponse(UserEntity userEntity);

    List<UserResponseDto> toResponseList(List<UserEntity> userList);

}
