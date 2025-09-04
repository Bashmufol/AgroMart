package com.bash.agricdeckmvp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupEmailService {
    private final JavaMailSender mailSender;  // Injects Spring's mail sender

    @Value("${spring.mail.username}")   // Injects the sender email address
    private String fromMail;
}
