package com.greg.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class SeatEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private Integer number;
	
	@ManyToOne
	private RoomEntity room;
	
	public SeatEntity() {
		
	}

	public SeatEntity(Integer id, int number, RoomEntity room) {
		this.id = id;
		this.number = number;
		this.room = room;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "SeatEntity [id=" + id + ", number=" + number + ", room=" + room + "]";
	}
}
