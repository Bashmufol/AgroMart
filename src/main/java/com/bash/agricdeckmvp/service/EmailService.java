package com.bash.agricdeckmvp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")   // Injects the sender email address
    private String fromMail;

    public void sendVerificationEmail(String to, String verificationUrl) {
        String subject = "Verify your account";
        String message = """
                Hello,
                
                Please click the link below to verify your account:
                %s
                
                If you did not request this, you can safely ignore this email.
                
                Best regards,
                The AgricDeck Team
                """.formatted(verificationUrl);

        sendEmail(to, subject, message);
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(text);
        email.setFrom(fromMail);
        mailSender.send(email);
    }
}
