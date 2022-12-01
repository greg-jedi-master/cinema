package com.greg.cinema.dto;

import com.greg.cinema.constant.ErrorMessages;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SeatReservationRequest {
	
	@NotNull
	@Min(value = 1, message = ErrorMessages.INVALID_DATA_PROVIDED)
	private int seatNumber;
	
	@NotNull
	private TicketType ticketType;

	public SeatReservationRequest(int seatNumber, TicketType ticketType) {
		this.seatNumber = seatNumber;
		this.ticketType = ticketType;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		
		if (!(object instanceof SeatReservationRequest)) {
			return false;
		}
		
		SeatReservationRequest request = (SeatReservationRequest)object;
		
		return this.seatNumber == request.seatNumber;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(seatNumber);
	}
	
	@Override
	public String toString() {
		return "SeatReservationRequest [seatNumber=" + seatNumber + ", ticketType=" + ticketType + "]";
	}
}
