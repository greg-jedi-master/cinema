package com.greg.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greg.cinema.entity.TicketTypeEntity;

public interface TicketTypeRepository extends JpaRepository<TicketTypeEntity, Integer> {

}
