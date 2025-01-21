package com.example.demo.exception;


import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
	
	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<Object> handleResouceNotFoundException(ResourceNotFoundException exc) {
		ErrorDetails er = new ErrorDetails();
		er.setDate(LocalDate.now());
		er.setMsg(exc.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}


    
}
