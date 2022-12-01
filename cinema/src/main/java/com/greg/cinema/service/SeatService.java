package com.greg.cinema.service;

import java.util.List;

import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.entity.SeatEntity;

public interface SeatService {
	
	public List<SeatEntity> getAvailableSeats(ScreeningEntity screening);
	
	public SeatEntity getSeatByNumberAndRoomId(int number, int id);
}
