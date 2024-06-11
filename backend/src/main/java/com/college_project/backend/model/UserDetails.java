package com.college_project.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserDetails 
{

    private String firstName;
    private String lastName;

    @Id
    private String email;
    private String password;
    private String phoneNumber;
    private String department;
    private String licenceId;
    private String registerNumber;
    private int verificationCode;

    // Constructors, getters, and setters
    public UserDetails() {
    }

    public UserDetails(String firstName, String lastName, String email, String password, String phoneNumber,
            String department, String licenceId, String registerNumber, int verificationCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.licenceId = licenceId;
        this.registerNumber = registerNumber;
        this.verificationCode = verificationCode;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }
    
    public String getRegisterNumber() {
        return registerNumber;
    }
    
    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
    
    public int getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(int verificationCode) {
        this.verificationCode = verificationCode;
    }
}
