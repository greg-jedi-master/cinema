package com.greg.cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.greg.cinema.exception.InvalidDataException;
import com.greg.cinema.dto.ReservationRequest;
import com.greg.cinema.dto.ReservationResponse;
import com.greg.cinema.dto.RoomInfo;
import com.greg.cinema.dto.ScreeningInfo;
import com.greg.cinema.entity.ReservationEntity;
import com.greg.cinema.entity.RoomEntity;
import com.greg.cinema.entity.ScreeningEntity;
import com.greg.cinema.entity.SeatEntity;
import com.greg.cinema.entity.SeatReservedEntity;
import com.greg.cinema.entity.TicketTypeEntity;
import com.greg.cinema.mapper.ReservationMapper;
import com.greg.cinema.mapper.RoomMapper;
import com.greg.cinema.mapper.ScreeningMapper;
import com.greg.cinema.service.impl.ReservationServiceImpl;
import com.greg.cinema.service.impl.ScreeningServiceImpl;
import com.greg.cinema.service.impl.SeatReservedServiceImpl;
import com.greg.cinema.service.impl.SeatServiceImpl;
import com.greg.cinema.service.impl.TicketTypeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private ScreeningServiceImpl screeningService;
	
	@Autowired
	private SeatServiceImpl seatService;
	
	@Autowired
	private SeatReservedServiceImpl seatReservedService;
	
	@Autowired
	private ReservationServiceImpl reservationService;
	
	@Autowired
	private TicketTypeServiceImpl ticketTypeService;
	
	@Autowired
	private ScreeningMapper screeningMapper;
	
	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	public Controller(ScreeningServiceImpl screeningService, SeatServiceImpl seatService,
			SeatReservedServiceImpl seatReservedService, ReservationServiceImpl reservationService,
			TicketTypeServiceImpl ticketTypeService, ScreeningMapper screeningMapper, RoomMapper roomMapper,
			ReservationMapper reservationMapper) {
		
		this.screeningService = screeningService;
		this.seatService = seatService;
		this.seatReservedService = seatReservedService;
		this.reservationService = reservationService;
		this.ticketTypeService = ticketTypeService;
		this.screeningMapper = screeningMapper;
		this.roomMapper = roomMapper;
		this.reservationMapper = reservationMapper;
	}

	@GetMapping("/screenings")
	public List<ScreeningInfo> listScreenings(@RequestParam("time") Optional<String> time) {
		List<ScreeningEntity> entities = screeningService.listScreenings(time);
		
		return entities
				.stream()
				.map(s -> {
					ScreeningInfo dto = screeningMapper.toDto(s);
					
					String roomInfoPath = MvcUriComponentsBuilder
							.fromController(getClass())
							.path("/screenings/{id}")
							.buildAndExpand(s.getId())
							.toUriString();
					
					dto.add(Link.of(roomInfoPath).withRel("roomInfo"));
					
					return dto;
				})
				.collect(Collectors.toList());
	}
	
	@GetMapping("/screenings/{id}")
	public RoomInfo retrieveRoomInfo(@PathVariable int id) {
		ScreeningEntity screening = screeningService.getScreening(id);
		RoomEntity room = screening.getRoom();
		
		List<SeatEntity> seatsAvailable = seatService.getAvailableSeats(screening);
		RoomInfo dto = roomMapper.toDto(room, seatsAvailable);
		
		String reservationPath = MvcUriComponentsBuilder
				.fromController(getClass())
				.path("/screenings/{id}/reservations")
				.buildAndExpand(screening.getId())
				.toUriString();
		
		dto.add(Link.of(reservationPath).withRel("reservationLink"));
		
		return dto;
	}
	
	@PostMapping("screenings/{id}/reservations")
	public ReservationResponse createReservation(@PathVariable int id, @RequestBody @Valid ReservationRequest reservationDto) {
		ScreeningEntity screening = screeningService.getScreening(id);
		
		String error = seatReservedService.checkChosenSeatsValidity(reservationDto.getSeats(), screening);
		
		if (error.isEmpty() == false) {
			throw new InvalidDataException(error);
		}
		
		ReservationEntity reservation = reservationService.addReservation(reservationDto, screening);
		
		List<SeatReservedEntity> seatsReserved = reservationDto.getSeats()
				.stream()
				.map(s -> {
					TicketTypeEntity ticketType = ticketTypeService.getTicketTypeEntity(s.getTicketType());
					SeatEntity seat = seatService.getSeatByNumberAndRoomId(s.getSeatNumber(), screening.getRoom().getId());
					
					return seatReservedService.reserveSeat(seat, ticketType, reservation);
				}).collect(Collectors.toList());
		
		return reservationMapper.toDto(reservation, seatsReserved);
	}
}
