package com.bash.agricdeckmvp.controller;

import com.bash.agricdeckmvp.dto.UserDto;
import com.bash.agricdeckmvp.model.ResponseModel;
import com.bash.agricdeckmvp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    private ResponseModel<UserDto> signUp(){

    }
    @GetMapping("/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam("token") String token) {
        String message = authService.verifyAccount(token);
        return ResponseEntity.ok(message);
    }

}
