package com.greg.cinema.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class RoomEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "room")
	private List<SeatEntity> seats;
	
	public RoomEntity() {
		
	}
	
	public RoomEntity(Integer id, String name, List<SeatEntity> seats) {
		this.id = id;
		this.name = name;
		this.seats = seats;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<SeatEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatEntity> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "RoomEntity [id=" + id + ", name=" + name + ", seats=" + seats + "]";
	}
}
