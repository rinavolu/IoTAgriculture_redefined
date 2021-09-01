package com.Iot.Agriculture.Handlers.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Invalid Device")
public class InValidDeviceException extends RuntimeException{
}
