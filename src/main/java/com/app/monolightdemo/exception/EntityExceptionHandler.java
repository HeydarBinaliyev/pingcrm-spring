package com.app.monolightdemo.exception;


import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.monolightdemo.utils.ServiceUtils;


@ControllerAdvice
public class EntityExceptionHandler {

	@Autowired
	ServiceUtils serviceUtils;
	
	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<ExceptionResponse> handleNonUniqueException(NonUniqueResultException exception , HttpServletRequest request) {
		exception.printStackTrace();
		String errorCode = "error.entity.101";
		String msg = serviceUtils.getMessage(request, errorCode);
		return new ResponseEntity<>(new ExceptionResponse(errorCode,msg),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<ExceptionResponse> handleNoResultException(NoResultException exception , HttpServletRequest request) {
		exception.printStackTrace();
		String errorCode = "error.entity.102";
		String msg = serviceUtils.getMessage(request, errorCode);
		return new ResponseEntity<>(new ExceptionResponse(errorCode, msg),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
