package com.app.monolightdemo.exception;
import org.springframework.security.core.AuthenticationException;

public class WrongPasswordException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6653097034323560688L;
	private String code;

	public WrongPasswordException(String code) {
		super(code);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
