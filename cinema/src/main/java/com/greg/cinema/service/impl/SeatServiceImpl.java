package com.greg.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.entity.SeatEntity;
import com.greg.cinema.repository.SeatRepository;
import com.greg.cinema.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepository repository;

	public SeatServiceImpl(SeatRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<SeatEntity> getAvailableSeats(ScreeningEntity screening) {
		return repository.findAvailableSeats(
				screening.getId(), 
				screening.getRoom().getId());
	}

	@Override
	public SeatEntity getSeatByNumberAndRoomId(int number, int id) {
		
		return repository.findByNumberAndRoomId(number, id);
	}
}
