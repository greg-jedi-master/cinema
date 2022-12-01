package com.greg.cinema.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReservationResponse implements Serializable {
	
	private static final long serialVersionUID = 8351814748214615473L;
	
	private LocalDateTime expiryDate;
	private double totalCost;
	
	public ReservationResponse(LocalDateTime expiryDate, double totalCost) {
		this.expiryDate = expiryDate;
		this.totalCost = totalCost;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "ReservationResponse [expiryDate=" + expiryDate + ", totalCost=" + totalCost + "]";
	}
}
