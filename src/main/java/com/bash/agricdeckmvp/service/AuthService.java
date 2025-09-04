package com.bash.agricdeckmvp.service;

import com.bash.agricdeckmvp.dto.SignUpRequest;
import com.bash.agricdeckmvp.dto.UserDto;
import com.bash.agricdeckmvp.exceptions.EmailAlreadyExistsException;
import com.bash.agricdeckmvp.model.ResponseModel;
import com.bash.agricdeckmvp.model.Role;
import com.bash.agricdeckmvp.model.User;
import com.bash.agricdeckmvp.model.VerificationToken;
import com.bash.agricdeckmvp.repository.UserRepository;
import com.bash.agricdeckmvp.repository.VerificationTokenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;
    private final EmailService emailService;


    @Transactional
    public ResponseModel<UserDto> signUp(SignUpRequest signUpRequest) {
        HttpStatus status = HttpStatus.CREATED;
        if(userRepository.existsByEmail(signUpRequest.email())){
            throw new EmailAlreadyExistsException("Email is already taken");
        }
        User newUser = new User();
        newUser.setEmail(signUpRequest.email());
        newUser.setPassword(passwordEncoder.encode(signUpRequest.password()));
        newUser.setFirstName(signUpRequest.firstName());
        newUser.setLastName(signUpRequest.lastName());
        newUser.setCountry(signUpRequest.country());
        newUser.setPhoneNumber(signUpRequest.phoneNumber());
        newUser.setRole(Role.USER);
        newUser.setVerified(false);
        userRepository.save(newUser);

        // create token
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(newUser);
        verificationToken.setExpiryDate(LocalDateTime.now().plusMinutes(10)); // 10 minutes expiry
        verificationTokenRepository.save(verificationToken);

        // send email
        String verificationUrl = "http://localhost:8080/api/auth/verify?token=" + token;
        emailService.sendVerificationEmail(newUser.getEmail(), verificationUrl);
        return new ResponseModel<>(status.value(), "New User succesully persisted to database", new UserDto(newUser) );
    }

    public String verifyAccount(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid verification token"));

        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token has expired");
        }

        User user = verificationToken.getUser();
        user.setVerified(true);
        userRepository.save(user);

        // Optionally delete the token after use
        verificationTokenRepository.delete(verificationToken);

        return "Account verified successfully. You can now log in.";
    }
}
