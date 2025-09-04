package com.bash.agricdeckmvp.controller;

import com.bash.agricdeckmvp.dto.UserDto;
import com.bash.agricdeckmvp.model.ResponseModel;
import com.bash.agricdeckmvp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    private ResponseModel<UserDto> signUp(){

    }

}
