package com.Iot.Agriculture.DTO;

import java.sql.Timestamp;

public class UserRegistrationMainDTO {

    public int userId;
    public String firstName;
    public String lastName;
    public String email;
    public Long phoneNumber;
    public boolean isValidationExpired;
    public boolean isUserValidated;
    public UserPermissionDTO userPermission;
    public Timestamp createdAt;

    public UserRegistrationMainDTO(int userId, String firstName, String lastName, String email, Long phoneNumber, boolean isValidationExpired, boolean isUserValidated, UserPermissionDTO userPermission, Timestamp createdAt) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isValidationExpired = isValidationExpired;
        this.isUserValidated = isUserValidated;
        this.userPermission = userPermission;
        this.createdAt = createdAt;
    }
}
