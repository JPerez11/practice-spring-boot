package com.example.practice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequestDto {

    @NotBlank(message = "First name field cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name field cannot be empty")
    private String lastName;
    @Pattern(regexp = "^\\d{10,14}$", message = "Phone number field must meet a range of numbers between 10 and 14")
    @NotBlank(message = "Phone number field cannot be empty")
    private String phoneNumber;

}
