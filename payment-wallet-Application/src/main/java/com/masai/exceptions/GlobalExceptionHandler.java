package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	
	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<MyErrorDetails> BeneficiaryExceptionHandler(BeneficiaryException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(BillPaymentNotFoundException.class)
	public ResponseEntity<MyErrorDetails> BillPaymentNotFoundExceptionHandler(BillPaymentNotFoundException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	

	@ExceptionHandler(InsufficientAmountException.class)
	public ResponseEntity<MyErrorDetails> InsufficientAmountExceptionHandler(InsufficientAmountException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	

	@ExceptionHandler(WalletNotFound.class)
	public ResponseEntity<MyErrorDetails> WalletNotFoundHandler(WalletNotFound se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MyErrorDetails> UserNotFoundExceptionHandler(UserNotFoundException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	

	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<MyErrorDetails> TransactionNotFoundExceptionHandler(TransactionNotFoundException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<MyErrorDetails> InvalidAccountExceptionHandler(InvalidAccountException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(BankAccountNotFound.class)
	public ResponseEntity<MyErrorDetails> BankAccountNotFound(BankAccountNotFound se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
//	
//	@ExceptionHandler(WalletException.class)
//	public ResponseEntity<MyErrorDetails> WalletExceptionHandler(WalletException se, WebRequest req){
//		
//		
//		MyErrorDetails err= new MyErrorDetails();
//			err.setTimestamp(LocalDateTime.now());
//			err.setMessage(se.getMessage());
//			err.setDetails(req.getDescription(false));
//				
//		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
//		
//	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
}
