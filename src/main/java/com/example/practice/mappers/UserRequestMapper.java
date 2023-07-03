package com.example.practice.mappers;

import com.example.practice.dto.request.CreateUserRequestDto;
import com.example.practice.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {

    @Mapping(target = "role.name", source = "role")
    UserEntity toEntity(CreateUserRequestDto createUserRequestDto);

}
