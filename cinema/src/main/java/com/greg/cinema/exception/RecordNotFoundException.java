package com.greg.cinema.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8299686369664417444L;
	
	public RecordNotFoundException(String message) {
		super(message);
	}
}
