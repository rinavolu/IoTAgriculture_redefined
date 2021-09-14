package com.Iot.Agriculture.Model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="user_registration_db")
public class UserRegistrationDataModel {

    @Id
    @GeneratedValue
    private int userId;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    private Long phoneNumber;
    private String validationId= UUID.randomUUID().toString();
    private boolean isValidationExpired=false;
    private boolean isUserValidated=false;
    private Timestamp createdAt=Timestamp.valueOf(LocalDateTime.now());

    public UserRegistrationDataModel(String firstName, String lastName, String email, String password, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UserRegistrationDataModel(int userId, String firstName, String lastName, String email, String password, Long phoneNumber, String validationId, boolean isValidationExpired, boolean isUserValidated, Timestamp createdAt) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.validationId = validationId;
        this.isValidationExpired = isValidationExpired;
        this.isUserValidated = isUserValidated;
        this.createdAt = createdAt;
    }

    public UserRegistrationDataModel() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getValidationId() {
        return validationId;
    }

    public void setValidationId(String validationId) {
        this.validationId = validationId;
    }

    public boolean isValidationExpired() {
        return isValidationExpired;
    }

    public void setValidationExpired(boolean validationExpired) {
        isValidationExpired = validationExpired;
    }

    public boolean isUserValidated() {
        return isUserValidated;
    }

    public void setUserValidated(boolean userValidated) {
        isUserValidated = userValidated;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
