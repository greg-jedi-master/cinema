package com.greg.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {
	
	@Id
	@GeneratedValue
	Integer id;
	
	@Column(nullable=false, length=64)
	private String title;
	
	public MovieEntity() {
		
	}

	public MovieEntity(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MovieEntity [id=" + id + ", title=" + title + "]";
	}
}
