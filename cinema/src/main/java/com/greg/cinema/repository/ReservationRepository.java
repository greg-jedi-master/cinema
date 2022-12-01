package com.greg.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greg.cinema.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

}
