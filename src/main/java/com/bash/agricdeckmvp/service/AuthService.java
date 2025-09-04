package com.bash.agricdeckmvp.service;

import com.bash.agricdeckmvp.dto.SignUpRequest;
import com.bash.agricdeckmvp.dto.UserDto;
import com.bash.agricdeckmvp.model.ResponseModel;
import com.bash.agricdeckmvp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;


    public ResponseModel<UserDto> signUp(SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.email())){
            throw new RuntimeException("Email is already taken");
        }
    }
}
