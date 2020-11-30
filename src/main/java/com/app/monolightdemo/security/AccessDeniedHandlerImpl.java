package com.app.monolightdemo.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;

import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.exception.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler{

	@Autowired
	MessageSource messageSource;
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setStatus(HttpStatus.FORBIDDEN.value());
		String country =  request.getHeader("Accept-Language")!=null?request.getHeader("Accept-Language"):"en";
		String msg = messageSource.getMessage("error.authorize.101", null,"Error code not found!", new Locale(country));
		ExceptionResponse errorResponse=new ExceptionResponse("error.authorize.101",msg);
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, errorResponse);
		out.flush();
	}

	
}
