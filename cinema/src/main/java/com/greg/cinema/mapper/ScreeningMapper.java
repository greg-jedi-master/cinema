package com.greg.cinema.mapper;

import org.springframework.stereotype.Component;

import com.greg.cinema.dto.ScreeningInfo;
import com.greg.cinema.entity.ScreeningEntity;

@Component
public class ScreeningMapper {
	
	public ScreeningInfo toDto(ScreeningEntity screening) {
		return new ScreeningInfo( 
				screening.getMovie().getTitle(),
				screening.getStartTime());
	}
}
