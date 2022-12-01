package com.greg.cinema.exception;

public class ReservationTooLateException extends RuntimeException {
	
	private static final long serialVersionUID = -499852270412808320L;
	
	public ReservationTooLateException(String message) {
		super(message);
	}
}
