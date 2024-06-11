package com.college_project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college_project.backend.model.UserDetails;
import com.college_project.backend.repository.SignupRepo;

@Service
public class SignupService {
    
    // Constructor Injection is the best way
    private SignupRepo signupRepo;
    public SignupService(SignupRepo signupRepo) {
        this.signupRepo = signupRepo;
    }
    @Autowired
    private MailService mailService;

    public void saveUser(UserDetails userDetails) {
        userDetails.setVerificationCode(mailService.generateVerificationCode());
        try{
            signupRepo.save(userDetails);
            mailService.sendSignupMail(userDetails.getEmail(), userDetails.getVerificationCode());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String email, String otp) {
        if(signupRepo.findById(email).get().getVerificationCode() == Integer.parseInt(otp))
            return true;
        else
            return false;
        
    }

    public List<UserDetails> getUsers() {
        return signupRepo.findAll();
    }
}
