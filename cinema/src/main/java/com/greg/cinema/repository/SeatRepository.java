package com.greg.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greg.cinema.entity.SeatEntity;

public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
	
	@Query(value = "SELECT * FROM seats WHERE id NOT IN (SELECT seat_id FROM seats_reserved WHERE screening_id=:screeningId) AND room_id = :roomId", nativeQuery = true)
	public List<SeatEntity> findAvailableSeats(@Param("screeningId") int screeningId, @Param("roomId") int roomId);
	
	@Query(value = "SELECT * FROM seats WHERE number = :seatNo AND room_id=:roomId LIMIT 1", nativeQuery = true)
	public SeatEntity findByNumberAndRoomId(@Param("seatNo") int number, @Param("roomId") int roomId);
}
