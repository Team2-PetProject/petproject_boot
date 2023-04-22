package com.example.member.exception;

public class NoLoginException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoLoginException(String message) {
		super(message);
	}
}
