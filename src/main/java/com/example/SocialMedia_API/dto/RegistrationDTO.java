package com.example.SocialMedia_API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@RequiredArgsConstructor
public class RegistrationDTO {

    @NotBlank(message = "Username is required")
    @Length(min = 3)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Length(min = 5, max = 15)
    private String password;
}
