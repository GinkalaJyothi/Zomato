package org.jsp.zomato.exceptionhandler;


import org.jsp.zomato.exceptionclasses.DuplicateEmailException;
import org.jsp.zomato.exceptionclasses.InvalidCredentialException;
import org.jsp.zomato.exceptionclasses.InvalidUserIdException;
import org.jsp.zomato.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<?> duplicateEmailExceptionHandler(DuplicateEmailException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Account Already Existed with this Email").body(e.getMessage()).build());
	}  
	@ExceptionHandler(InvalidUserIdException.class)
	public ResponseEntity<?> invalidUserIdExceptionHandler(InvalidUserIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("Invalid User Id Unable to found the User.").body(e.getMessage()).build());
	}
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<?> invalidCredentialExceptionHandler(InvalidCredentialException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("Invalid User Id Unable to Login").body(e.getMessage()).build());
	}  
	
}
