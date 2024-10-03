package com.randstad.tondeuse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlIllegalArguments extends Exception {

	@ExceptionHandler
	public void exceptionIllegalArguments(String message) {


	     }

}
