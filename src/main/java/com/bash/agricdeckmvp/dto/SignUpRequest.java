package com.bash.agricdeckmvp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {
    @Email(message = "Must be a valid email")
    @NotBlank
    private String email;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Country is required")
    private String country;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @NotBlank
    private String password;
}
