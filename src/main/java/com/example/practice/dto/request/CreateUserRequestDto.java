package com.example.practice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequestDto {

    @NotBlank(message = "First name field cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name field cannot be empty")
    private String lastName;
    @NotBlank(message = "Document number field cannot be empty")
    @Pattern(regexp = "^\\d{10,14}$", message = "Document number field must meet a range of numbers between 10 and 14")
    private String documentNumber;
    @NotBlank(message = "Phone number field cannot be empty")
    @Pattern(regexp = "^\\d{10,14}$", message = "Phone number field must meet a range of numbers between 10 and 14")
    private String phoneNumber;
    @NotNull(message = "Birthday field cannot be empty")
    @Past
    private LocalDate birthday;
    @NotBlank(message = "Email field cannot be empty")
    @Email
    private String email;
    @NotBlank(message = "Password field cannot be empty")
    private String password;
    @NotBlank(message = "Role field cannot be empty")
    private String roleName;

}
