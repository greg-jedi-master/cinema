package com.greg.cinema.service;

import com.greg.cinema.dto.TicketType;
import com.greg.cinema.entity.TicketTypeEntity;

public interface TicketTypeService {
	
	public TicketTypeEntity getTicketTypeEntity(TicketType ticketType);
}
