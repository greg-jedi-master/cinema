package com.greg.cinema.service.impl;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greg.cinema.constant.ErrorMessages;
import com.greg.cinema.dto.SeatReservationRequest;
import com.greg.cinema.entity.ReservationEntity;
import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.entity.SeatEntity;
import com.greg.cinema.entity.SeatReservedEntity;
import com.greg.cinema.entity.TicketTypeEntity;
import com.greg.cinema.exception.InvalidDataException;
import com.greg.cinema.repository.SeatReservedRepository;
import com.greg.cinema.service.SeatReservedService;

@Service
public class SeatReservedServiceImpl implements SeatReservedService {
	
	@Autowired
	private SeatReservedRepository repository;
	
	public SeatReservedServiceImpl(SeatReservedRepository repository) {
		this.repository = repository;
	}

	@Override
	public String checkChosenSeatsValidity(List<SeatReservationRequest> seats, ScreeningEntity screening) {
		String error = "";
		
		List<Integer> seatNumbers = seats
				.stream()
				.map(s -> {
					int seatNumber = s.getSeatNumber();
					
					if (seatNumber > screening.getRoom().getSeats().size()) {
						throw new InvalidDataException(ErrorMessages.INVALID_DATA_PROVIDED);
					}
					
					return s.getSeatNumber();
				})
				.collect(Collectors.toList());
		
		seatNumbers.addAll(screening.getSeatsReserved()
				.stream()
				.map(s -> s.getSeat().getNumber())
				.collect(Collectors.toList()));
		
		Collections.sort(seatNumbers);
		
		for (int i=1; i<seatNumbers.size(); i++) {
			int result = seatNumbers.get(i) - seatNumbers.get(i-1);
			
			if (result == 0 || result == 2) {
				return ErrorMessages.COULD_NOT_BOOK_SEAT;
			}
		}
		
		// Edge case: check if the last seat remains unbooked.
		int lastReserved = seatNumbers.get(seatNumbers.size()-1);
		
		if (screening.getRoom().getSeats().size() - lastReserved == 1) {
			return ErrorMessages.COULD_NOT_BOOK_SEAT;
		}
		
		return error;
	}

	@Override
	public SeatReservedEntity reserveSeat(SeatEntity seat, TicketTypeEntity ticketType, ReservationEntity reservation) {
		
		SeatReservedEntity newEntity = new SeatReservedEntity();
		newEntity.setSeat(seat);
		newEntity.setScreening(reservation.getScreening());
		newEntity.setReservation(reservation);
		newEntity.setTicketType(ticketType);
		
		return repository.save(newEntity);
	}
}
