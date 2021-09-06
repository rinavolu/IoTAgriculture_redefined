package com.Iot.Agriculture.Handlers.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "InValid Verification Id")
public class InValidVerificationIdException extends RuntimeException{
}
