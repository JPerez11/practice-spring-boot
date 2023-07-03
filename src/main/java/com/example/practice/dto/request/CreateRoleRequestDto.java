package com.example.practice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateRoleRequestDto {

    @NotBlank(message = "Name field cannot be empty")
    private String name;
    private String description;

}
