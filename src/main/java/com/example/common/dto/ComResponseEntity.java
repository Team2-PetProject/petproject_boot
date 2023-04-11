package com.example.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ComResponseEntity<T> extends ResponseEntity<ComResponseDTO<T>>{
	
	public ComResponseEntity() {
		super(new ComResponseDTO<T>(), HttpStatus.OK);
	}
	public ComResponseEntity(ComResponseDTO<T> body, HttpStatus status) {
		super(body, status);
	}

	public ComResponseEntity(HttpStatus status) {
		super(status);
	}
	
	public ComResponseEntity(ComResponseDTO<T> body) {
		super(body, HttpStatus.OK);
	}
}
