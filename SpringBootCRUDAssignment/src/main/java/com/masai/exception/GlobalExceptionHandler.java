package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(NoDataFoundException ie,WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(BookNotFoundException ie,WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNoFoundHandler(NoHandlerFoundException ie,WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVEHandler(MethodArgumentNotValidException ie){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),"Validation Error",ie.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpMainHandler(Exception ie,WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
