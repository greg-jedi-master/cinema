package com.greg.cinema.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greg.cinema.constant.ErrorMessages;
import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.exception.InvalidDataException;
import com.greg.cinema.exception.RecordNotFoundException;
import com.greg.cinema.repository.ScreeningRepository;
import com.greg.cinema.service.ScreeningService;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	
	@Autowired
	private ScreeningRepository repository;
	
	public ScreeningServiceImpl(ScreeningRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ScreeningEntity> listScreenings(Optional<String> time) {
		List<ScreeningEntity> screenings = null;
		
		if (time.isEmpty()) {
			screenings = repository.findAll(
					Sort.by("movie.title").ascending().and(Sort.by("startTime").ascending()));
		} else {
			
			try {
				LocalDateTime beginTime = LocalDateTime.parse(time.get());
				LocalDateTime endTime = beginTime.toLocalDate().atTime(LocalTime.MAX);
				
				screenings = repository.findAllByStartTimeBetween(
						beginTime, 
						endTime, 
						Sort.by("movie.title").ascending().and(Sort.by("startTime").ascending()));
			} catch (DateTimeParseException ex) {
				throw new InvalidDataException(ErrorMessages.INVALID_DATA_PROVIDED);
			}
		}
		
		return screenings;
	}

	@Override
	public ScreeningEntity getScreening(int id) {
		Optional<ScreeningEntity> optScreening = repository.findById(id);
		
		if (optScreening.isEmpty()) {
			throw new RecordNotFoundException(ErrorMessages.RECORD_NOT_FOUND);
		}
		
		return optScreening.get();
	}

}
