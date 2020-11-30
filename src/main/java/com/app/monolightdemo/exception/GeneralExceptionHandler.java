package com.app.monolightdemo.exception;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.monolightdemo.utils.ServiceUtils;


@ControllerAdvice
public class GeneralExceptionHandler {

	@Autowired
	ServiceUtils serviceUtils;
	
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<ExceptionResponse> handleException(GeneralException exception , HttpServletRequest request,
			HttpServletResponse response) {
		String msg = serviceUtils.getMessage(request, exception.getCode());
		exception.printStackTrace();
		ResponseEntity<ExceptionResponse> result = new ResponseEntity<>(new ExceptionResponse(exception.getCode(),msg),HttpStatus.INTERNAL_SERVER_ERROR);
		return result;
		
	}
}
