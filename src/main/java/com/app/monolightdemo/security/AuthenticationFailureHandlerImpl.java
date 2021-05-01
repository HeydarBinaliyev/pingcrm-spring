package com.app.monolightdemo.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.app.monolightdemo.exception.WrongPasswordException;
import com.app.monolightdemo.inertia.Inertia;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	@Autowired
	MessageSource messageSource;

	@Autowired
	Inertia inertia;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		Map<String, Object> props = new HashMap<>();

		Map<String, Object> erros = new HashMap<>();

		response.setStatus(HttpStatus.UNAUTHORIZED.value());

		String msg = messageSource.getMessage(exception.getMessage(), null, "Unkown error!", request.getLocale());

		if (exception instanceof WrongPasswordException)
			erros.put("password", msg);
		else
			erros.put("email", msg);

		props.put("errors", erros);

		response.setContentType("application/json");

		OutputStream out = response.getOutputStream();

		@SuppressWarnings("unchecked")
		ResponseEntity<String> inertiaResponse = (ResponseEntity<String>) inertia.generateResponse("Auth/Login", props);

		out.write(inertiaResponse.getBody().getBytes());

		out.flush();

	}

}
