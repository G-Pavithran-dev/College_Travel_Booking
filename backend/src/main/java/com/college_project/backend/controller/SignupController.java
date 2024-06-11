package com.college_project.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college_project.backend.model.UserDetails;
import com.college_project.backend.service.SignupService;

@RestController
public class SignupController {
    
    private SignupService signupService;
    private String email;
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDetails userDetails) {
        email = userDetails.getEmail();
        try{
            signupService.saveUser(userDetails);
            return new ResponseEntity<String>("User added to database", HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Internal Error in database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/verify/{otp}")
    public ResponseEntity<String> verify(@PathVariable String otp)
    {
        try{
            if(signupService.verifyUser(email, otp))
                return new ResponseEntity<String>("User verified", HttpStatus.ACCEPTED);
            else
                return new ResponseEntity<String>("User not verified", HttpStatus.NOT_ACCEPTABLE);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("Internal Error in database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/testing/getUsers")
    public List<UserDetails> getUsers() {
        return signupService.getUsers();
    }
        
}
