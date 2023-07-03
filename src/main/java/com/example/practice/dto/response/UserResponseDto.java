package com.example.practice.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private String firstName;
    private String lastName;
    private String documentNumber;
    private String phoneNumber;
    private LocalDate birthday;
    private String email;
    private String roleName;

}
