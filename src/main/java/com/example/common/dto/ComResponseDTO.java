package com.example.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComResponseDTO<T> {
	private String message;
	private T body;
	
	public ComResponseDTO(String message) {
		super();
		this.message = message;
	}
	
	public ComResponseDTO(String message, T body) {
		super();
		this.message = message;
		this.body = body;
	}
	public ComResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	
}
