package com.greg.cinema.dto;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;


public class ScreeningInfo extends RepresentationModel<ScreeningInfo> {

	private String movieTitle;
	private LocalDateTime startTime;
	
	public ScreeningInfo(String movieTitle, LocalDateTime startTime) {
		this.movieTitle = movieTitle;
		this.startTime = startTime;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "ScreeningInfo [movieTitle=" + movieTitle + ", startTime=" + startTime + "]";
	}
}