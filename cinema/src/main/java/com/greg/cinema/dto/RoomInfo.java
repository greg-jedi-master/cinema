package com.greg.cinema.dto;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;


public class RoomInfo extends RepresentationModel<RoomInfo> {
	
	private String roomName;
	private List<Integer> seatsAvailable;
	
	public RoomInfo(String roomName, List<Integer> seatsAvailable) {
		this.roomName = roomName;
		this.seatsAvailable = seatsAvailable;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Integer> getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(List<Integer> seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	@Override
	public String toString() {
		return "RoomInfo [roomName=" + roomName + ", seatsAvailable=" + seatsAvailable + "]";
	}
}
