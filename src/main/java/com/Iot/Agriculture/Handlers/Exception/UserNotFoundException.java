package com.Iot.Agriculture.Handlers.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "User not found.")
public class UserNotFoundException extends RuntimeException{
}

