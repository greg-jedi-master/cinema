package com.greg.cinema.service;

import com.greg.cinema.dto.ReservationRequest;
import com.greg.cinema.entity.ReservationEntity;
import com.greg.cinema.entity.ScreeningEntity;

public interface ReservationService {
	
	public ReservationEntity addReservation(ReservationRequest reservationDto, ScreeningEntity screening);
}
