package com.example.pass.in.domain.attendee.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AttendeeNotFoundException extends RuntimeException{
    public AttendeeNotFoundException(String message){
        super(message);
    }
}
