package com.greg.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greg.cinema.entity.SeatReservedEntity;

public interface SeatReservedRepository extends JpaRepository<SeatReservedEntity, Integer> {
	
	@Query(value = "SELECT seats.number FROM seats_reserved WHERE screening_id = :screeningId", nativeQuery = true)
	public List<Integer> findSeatNumberByScreeningId(@Param("screeningId") int screeningId);
	
	public List<SeatReservedEntity> findAllBySeatIdAndScreeningId(int seatId, int screeningId);
}
