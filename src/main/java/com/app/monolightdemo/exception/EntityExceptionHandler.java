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
		String msg = serviceUtils.getMessage("error.entity.101");
		return new ResponseEntity<>(new ExceptionResponse("error.entity.101",msg),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<ExceptionResponse> handleNoResultException(NoResultException exception , HttpServletRequest request) {
		exception.printStackTrace();
		String msg = serviceUtils.getMessage("error.entity.102");
		return new ResponseEntity<>(new ExceptionResponse( "error.entity.102", msg),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
