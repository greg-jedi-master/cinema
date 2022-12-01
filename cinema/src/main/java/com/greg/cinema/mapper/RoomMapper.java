package com.greg.cinema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.greg.cinema.dto.RoomInfo;
import com.greg.cinema.entity.RoomEntity;
import com.greg.cinema.entity.SeatEntity;

@Component
public class RoomMapper {
	
	public RoomInfo toDto(RoomEntity room, List<SeatEntity> seatsAvailable) {
		List<Integer> seatsDto = seatsAvailable
				.stream()
				.map(s -> s.getNumber())
				.collect(Collectors.toList());
		
		return new RoomInfo(room.getName(), seatsDto);
	}
}
