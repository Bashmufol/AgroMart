package com.bash.agricdeckmvp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public record SignUpRequest(
        @Email(message = "Must be a valid email")
        @NotBlank
        String email,

        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Country is required")
        String country,

        @NotBlank(message = "Phone number is required")
        String phoneNumber,

        @Size(min = 8, message = "Password must be at least 8 characters long")
        @NotBlank
        String password
) {}
