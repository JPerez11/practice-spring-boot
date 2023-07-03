package com.example.practice.services.impl;

import com.example.practice.dto.request.CreateRoleRequestDto;
import com.example.practice.dto.response.RoleResponseDto;
import com.example.practice.entities.RoleEntity;
import com.example.practice.exceptions.RoleNotFoundException;
import com.example.practice.mappers.RoleRequestMapper;
import com.example.practice.mappers.RoleResponseMapper;
import com.example.practice.repositories.RoleRepository;
import com.example.practice.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleRequestMapper roleRequestMapper;
    private final RoleResponseMapper roleResponseMapper;

    @Override
    public RoleResponseDto createRole(CreateRoleRequestDto roleRequest) {
        if (roleRequest == null) {
            //TODO create a custom exception
        }
        return roleResponseMapper.toResponse(
                roleRepository.save(
                        roleRequestMapper.toEntity(roleRequest)
                )
        );
    }

    @Override
    public RoleResponseDto getRole(Long roleId) {
        RoleEntity role = roleRepository.findById(roleId).orElse(null);
        if (role == null) {
            throw new RoleNotFoundException();
        }
        return roleResponseMapper.toResponse(role);
    }

    @Override
    public List<RoleResponseDto> listRoles() {
        List<RoleEntity> list = roleRepository.findAll();
        if (list.isEmpty()) {
            //TODO create a custom exception
        }
        return roleResponseMapper.toResponseList(list);
    }
}
