package com.greg.cinema.service;

import java.util.List;
import java.util.Optional;

import com.greg.cinema.entity.ScreeningEntity;

public interface ScreeningService {
	
	public List<ScreeningEntity> listScreenings(Optional<String> time);
	
	public ScreeningEntity getScreening(int id);
}
