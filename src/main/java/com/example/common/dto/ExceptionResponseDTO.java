package com.example.common.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponseDTO {
	private LocalDateTime timestamp = LocalDateTime.now();
	
	private String message;
	
	private String code;
	
	private HttpStatus status;

	public ExceptionResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponseDTO(LocalDateTime timestamp, String message, String code, HttpStatus status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.code = code;
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
