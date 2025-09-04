package com.bash.agricdeckmvp.controller;

import com.bash.agricdeckmvp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
}
