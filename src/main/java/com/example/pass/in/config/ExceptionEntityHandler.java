package com.example.pass.in.config;

import com.example.pass.in.domain.attendee.exceptions.AttendeeAlreadyExistsException;
import com.example.pass.in.domain.attendee.exceptions.AttendeeNotFoundException;
import com.example.pass.in.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.example.pass.in.domain.event.exceptions.EventFullException;
import com.example.pass.in.domain.event.exceptions.EventNotFoundException;
import com.example.pass.in.dto.general.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(AttendeeNotFoundException.class)
    ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    ResponseEntity handleCheckInAlreadyExists(CheckInAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(EventFullException.class)
    ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException exception){
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }


}
