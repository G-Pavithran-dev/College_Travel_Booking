package com.college_project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private MailSender mailSender;
    private SimpleMailMessage message;

    public int generateVerificationCode() {
        return (int) ((Math.random() * (999999 - 100000)) + 100000);
    }

    public void sendSignupMail(String email, int verificationCode) {
        // send mail to email
        this.message = new SimpleMailMessage();
        String htmlBody = "<h1>Welcome to College Rapido, " + email + "!</h1>"
                + "<p>We're thrilled to have you here! 🎉</p>"
                + "<p>Get ready to dive into our engaging and diverse learning community. You're now part of a group of brilliant, dedicated students who are here to make the most out of their education.</p>"
                + "<p>Before you get started, we need to verify your email address. Here's your verification code:</p>"
                + "<h2 style='color: #3498db;'>" + verificationCode + "</h2>"
                + "<p>Once verified, you'll have full access to all the resources available on College Rapido.</p>"
                + "<p>If you have any questions, feel free to reach out to us at any time. We're here to help!</p>"
                + "<p>Happy learning,<br>The College Rapido Team</p>";

        message.setFrom("noreply@collegerapido.com");
        message.setReplyTo("support@collegerapido.com");
        message.setTo(email);
        message.setSubject("Welcome to SKCET Rapido");
        message.setText(htmlBody);

        mailSender.send(message);
        System.out.println("Signup Mail sent successfully");
    }
    
    public void otpVerifiedEmail(String email){
        this.message = new SimpleMailMessage();
        String htmlBody = "<h1>Welcome to College Rapido!</h1>"
        + "<p>Your email has been successfully verified. You now have full access to all the resources available on College Rapido.</p>"
        + "<p>If you have any questions, feel free to reach out to us at any time. We're here to help!</p>"
        + "<p>Happy learning,<br>The College Rapido Team</p>";
        
        message.setFrom("noreply@collegerapido.com");
        message.setReplyTo("support@collegerapido.com");
        message.setTo(email);
        message.setSubject("Welcome to SKCET Rapido");
        message.setText(htmlBody);
    
        mailSender.send(message);
        System.out.println("OTP Verified Mail sent successfully");
    }
}
