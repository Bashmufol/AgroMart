package com.bash.agricdeckmvp.dto;

import com.bash.agricdeckmvp.model.User;

public record UserDto(
        String email,
        String firstName,
        String lastName, String country) {
    public UserDto(User user){
        this(user.getEmail(), user.getFirstName(), user.getLastName(), user.getCountry());
    }
}
