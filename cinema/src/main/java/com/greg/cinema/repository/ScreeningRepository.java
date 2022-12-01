package com.greg.cinema.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greg.cinema.entity.ScreeningEntity;

public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Integer> {
	
	public List<ScreeningEntity> findAllByStartTimeBetween(
			LocalDateTime beginTime,
			LocalDateTime endTime,
			Sort sort);
}
