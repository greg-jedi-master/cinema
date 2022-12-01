package com.greg.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greg.cinema.constant.ErrorMessages;
import com.greg.cinema.constant.TimeConstants;
import com.greg.cinema.dto.ReservationRequest;
import com.greg.cinema.entity.ReservationEntity;
import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.exception.ReservationTooLateException;
import com.greg.cinema.mapper.ReservationMapper;
import com.greg.cinema.repository.ReservationRepository;
import com.greg.cinema.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository repository;
	
	@Autowired
	private ReservationMapper mapper;
	
	public ReservationServiceImpl(ReservationRepository repository, ReservationMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ReservationEntity addReservation(ReservationRequest reservationDto, ScreeningEntity screening) {
		ReservationEntity newEntity = mapper.toEntity(reservationDto, screening);
		
		if (newEntity.getCreateTime()
				.isAfter(screening.getStartTime().plusMinutes(TimeConstants.LATEST_BOOKING_TIME))) {
			
			throw new ReservationTooLateException(ErrorMessages.RESERVATION_TOO_LATE);
		}
		
		return repository.save(newEntity);
	}
	
}
