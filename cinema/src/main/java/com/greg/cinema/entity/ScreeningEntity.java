package com.greg.cinema.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "screenings")
public class ScreeningEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private MovieEntity movie;
	
	@ManyToOne
	private RoomEntity room;
	
	@Column
	private LocalDateTime startTime;
	
	@OneToMany(mappedBy = "screening")
	private List<SeatReservedEntity> seatsReserved;
	
	public ScreeningEntity() {
		
	}

	public ScreeningEntity(Integer id, MovieEntity movie, RoomEntity room, LocalDateTime startTime, List<SeatReservedEntity> seatsReserved) {
		this.id = id;
		this.movie = movie;
		this.room = room;
		this.startTime = startTime;
		this.seatsReserved = seatsReserved;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public List<SeatReservedEntity> getSeatsReserved() {
		return seatsReserved;
	}

	public void setSeatsReserved(List<SeatReservedEntity> seatsReserved) {
		this.seatsReserved = seatsReserved;
	}

	@Override
	public String toString() {
		return "ScreeningEntity [id=" + id + ", movie=" + movie + ", room=" + room + ", startTime=" + startTime + "]";
	}
}
