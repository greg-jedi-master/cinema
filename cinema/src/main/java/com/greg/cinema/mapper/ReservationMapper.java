package com.greg.cinema.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.greg.cinema.constant.TimeConstants;
import com.greg.cinema.dto.ReservationRequest;
import com.greg.cinema.dto.ReservationResponse;
import com.greg.cinema.entity.ReservationEntity;
import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.entity.SeatReservedEntity;

@Component
public class ReservationMapper {
	
	public ReservationEntity toEntity(ReservationRequest dto, ScreeningEntity screening) {
		ReservationEntity entity = new ReservationEntity();
		
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setScreening(screening);
		entity.setCreateTime(LocalDateTime.now());
		entity.setExpireTime(entity.getCreateTime().plusMinutes(TimeConstants.RESERVATION_EXPIRY_TIME));
		
		return entity;
	}
	
	public ReservationResponse toDto(ReservationEntity reservation, List<SeatReservedEntity> seats) {
		double cost = seats.stream().mapToDouble(s -> s.getTicketType().getPrice()).sum();
		
		return new ReservationResponse(
				reservation.getExpireTime(),
				cost
				);
	}
}
