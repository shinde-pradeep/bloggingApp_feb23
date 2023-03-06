package com.bloggingApp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandling {

@ExceptionHandler (ResourceNotFoundExceptionnn.class)	
public ResponseEntity<String> resourceNotFoundException (ResourceNotFoundExceptionnn msg){
	
	String message = msg.getMessage();
	
	return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
	
}

    @ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidException (MethodArgumentNotValidException fieldAnsMsg){
		
		Map <String,String> resp = new HashMap<String,String>();
		
		fieldAnsMsg.getBindingResult().getAllErrors().forEach(error ->{

			String msg = error.getDefaultMessage();
			String field = ((FieldError)error).getField();
			resp.put(field, msg);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);

	}
	
	
	
	
	
}
