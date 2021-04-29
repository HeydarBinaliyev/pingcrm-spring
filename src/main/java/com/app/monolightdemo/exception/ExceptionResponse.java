package com.app.monolightdemo.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {

	@JsonProperty("message")
	private String message;
	@JsonProperty("errorCode")
	private String errorCode;
	@JsonProperty("timestamp")
	private Date timestamp;

	public ExceptionResponse(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.timestamp = new Date();
	}

	public ExceptionResponse() {
	}

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
