package com.example.practice.controllers;

import com.example.practice.dto.request.CreateRoleRequestDto;
import com.example.practice.dto.response.RoleResponseDto;
import com.example.practice.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleResponseDto> createRole(@Valid @RequestBody CreateRoleRequestDto roleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleService.createRole(roleRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<RoleResponseDto>> listRole() {
        return ResponseEntity.ok(roleService.listRoles());
    }

}
