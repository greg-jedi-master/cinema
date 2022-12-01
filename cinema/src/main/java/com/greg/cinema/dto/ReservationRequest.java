package com.greg.cinema.dto;

import java.util.List;

import com.greg.cinema.constant.ErrorMessages;
import com.greg.cinema.validator.NoDuplicates;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ReservationRequest {
	
	@NotEmpty
	@Size(min = 3, max = 32)
	@Pattern(regexp = "^[A-ZŻŹĆĄŚĘŁÓŃ][A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,}", message = ErrorMessages.INVALID_DATA_PROVIDED)
	private String firstName;
	
	@NotEmpty
	@Size(min = 3, max = 32)
	@Pattern(regexp = "^[A-ZŻŹĆĄŚĘŁÓŃ][A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,}(-[A-ZŻŹĆĄŚĘŁÓŃ][A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,})?", 
			 message = ErrorMessages.INVALID_DATA_PROVIDED)
	private String lastName;
	
	@NotEmpty(message = ErrorMessages.NO_SEATS_SELECTED)
	@Valid
	@NoDuplicates
	private List<SeatReservationRequest> seats;
	
	public ReservationRequest(String firstName, String lastName, List<SeatReservationRequest> seats) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.seats = seats;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<SeatReservationRequest> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatReservationRequest> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "ReservationRequest [firstName=" + firstName + ", lastName=" + lastName + ", seats=" + seats + "]";
	}
}
