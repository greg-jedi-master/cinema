package com.greg.cinema.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greg.cinema.dto.TicketType;
import com.greg.cinema.entity.TicketTypeEntity;
import com.greg.cinema.repository.TicketTypeRepository;
import com.greg.cinema.service.TicketTypeService;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {
	
	@Autowired
	private TicketTypeRepository repository;
	
	public TicketTypeServiceImpl(TicketTypeRepository repository) {
		this.repository = repository;
	}

	@Override
	public TicketTypeEntity getTicketTypeEntity(TicketType ticketType) {
		Optional<TicketTypeEntity> optTicketType = null;
			
		switch (ticketType) {
		case ADULT:
			 optTicketType = repository.findById(1);
			 break;
		case CHILD:
			optTicketType = repository.findById(2);
			break;
		case STUDENT:
			optTicketType = repository.findById(3);
			break;
		}
		
		return optTicketType.get();
	}

	
	
}
