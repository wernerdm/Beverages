package com.springboot.BeverageAPI.APIError;



/**
 * @author Werner De Mulder
 * definition Customized exception
 */
public class ApirequestException extends RuntimeException{
	
	public ApirequestException(String message) {
		super(message);
	}
	
	public ApirequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
