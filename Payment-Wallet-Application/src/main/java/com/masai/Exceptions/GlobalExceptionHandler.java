package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<MyErrorDetails> transactionException(TransactionException exception,WebRequest request){
		MyErrorDetails details = new MyErrorDetails();
		details.setDateTime(LocalDateTime.now());
		details.setMessage(exception.getMessage());
		details.setDetails(request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(details,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genericException(Exception exception, WebRequest request){
		MyErrorDetails details = new MyErrorDetails();
		details.setDateTime(LocalDateTime.now());
		details.setMessage(exception.getMessage());
		details.setDetails(request.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(details,HttpStatus.BAD_REQUEST);	
	}
}
