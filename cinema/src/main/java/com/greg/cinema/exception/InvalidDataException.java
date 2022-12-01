package com.greg.cinema.exception;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 3243126269308968800L;
	
	public InvalidDataException(String message) {
		super(message);
	}
}
