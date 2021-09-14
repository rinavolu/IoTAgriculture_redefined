package com.Iot.Agriculture.Handlers.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "User didn't have privileges")
public class UserPermissionException extends RuntimeException{
}
