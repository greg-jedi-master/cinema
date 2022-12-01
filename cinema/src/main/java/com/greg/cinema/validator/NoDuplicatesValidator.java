package com.greg.cinema.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.greg.cinema.dto.SeatReservationRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoDuplicatesValidator implements ConstraintValidator<NoDuplicates, List<SeatReservationRequest>> {
	
	@Override
	public void initialize(NoDuplicates foo) {
		
	}
	
	@Override
	public boolean isValid(List<SeatReservationRequest> value, ConstraintValidatorContext context) {
		Set <SeatReservationRequest> set = new HashSet<>(value);
		
		return value.size() == set.size();
	}
	
}
