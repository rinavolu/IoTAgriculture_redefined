package com.Iot.Agriculture.Handlers.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "User Not Authenticated")
public class UserNotAuthenticatedException extends RuntimeException {

}
