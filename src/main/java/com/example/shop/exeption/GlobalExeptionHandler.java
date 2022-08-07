package com.example.shop.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(ResourseNotFoundExeption.class)
    public ResponseEntity<?> handleResourseNotFoundExeption(ResourseNotFoundExeption exeption, WebRequest request){

        ExeptionDetails exeptionDetails = new ExeptionDetails(new Date(), exeption.getMessage(),request.getDescription(false));
        return new  ResponseEntity(exeptionDetails, HttpStatus.NOT_FOUND);
    }
}
