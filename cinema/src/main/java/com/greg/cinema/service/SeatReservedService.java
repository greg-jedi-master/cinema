package com.greg.cinema.service;

import java.util.List;

import com.greg.cinema.dto.SeatReservationRequest;
import com.greg.cinema.entity.ReservationEntity;
import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.entity.SeatEntity;
import com.greg.cinema.entity.SeatReservedEntity;
import com.greg.cinema.entity.TicketTypeEntity;

public interface SeatReservedService {
	
	public String checkChosenSeatsValidity(List<SeatReservationRequest> seats, ScreeningEntity screening);
	
	public SeatReservedEntity reserveSeat(SeatEntity seat, TicketTypeEntity ticketType, ReservationEntity reservation);
}
