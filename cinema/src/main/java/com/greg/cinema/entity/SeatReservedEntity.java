package com.greg.cinema.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats_reserved")
public class SeatReservedEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private SeatEntity seat;
	
	@ManyToOne
	private ScreeningEntity screening;
	
	@ManyToOne
	private ReservationEntity reservation;
	
	@ManyToOne
	private TicketTypeEntity ticketType;
	
	public SeatReservedEntity() {
		
	}

	public SeatReservedEntity(SeatEntity seat, ScreeningEntity screening, ReservationEntity reservation,
			TicketTypeEntity ticketType) {
		this.seat = seat;
		this.screening = screening;
		this.reservation = reservation;
		this.ticketType = ticketType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SeatEntity getSeat() {
		return seat;
	}

	public void setSeat(SeatEntity seat) {
		this.seat = seat;
	}

	public ScreeningEntity getScreening() {
		return screening;
	}

	public void setScreening(ScreeningEntity screening) {
		this.screening = screening;
	}

	public ReservationEntity getReservation() {
		return reservation;
	}

	public void setReservation(ReservationEntity reservation) {
		this.reservation = reservation;
	}

	public TicketTypeEntity getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketTypeEntity ticketType) {
		this.ticketType = ticketType;
	}

	@Override
	public String toString() {
		return "SeatReservedEntity [id=" + id + ", seat=" + seat + ", screening=" + screening + ", reservation="
				+ reservation + ", ticketType=" + ticketType + "]";
	}
}
