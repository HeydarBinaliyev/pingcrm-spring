package com.app.monolightdemo.exception;


public class GeneralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public GeneralException(String code) {
		// TODO Auto-generated constructor stub
		super(code);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	

}
