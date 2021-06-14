package com.springboot.BeverageAPI.APIError;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author beq06539
 * Class to handle exceptions in a customized way.
 */
@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ApirequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApirequestException e){
		//1. Creation payload containing exception details
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ApiException apiException = new ApiException(e.getMessage(),badRequest,ZonedDateTime.now(ZoneId.of("+1")));
		
		//2. return response entity
		return new ResponseEntity<>(apiException, badRequest);
		
	}
}
