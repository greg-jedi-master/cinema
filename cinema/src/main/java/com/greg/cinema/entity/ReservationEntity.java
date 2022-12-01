package com.greg.cinema.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class ReservationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private ScreeningEntity screening;
	
	@Column(nullable=false, length=32)
	private String firstName;
	
	@Column(nullable=false, length=32)
	String lastName;
		
	@Column
	private LocalDateTime createTime;
	
	@Column
	private LocalDateTime expireTime;
	
	public ReservationEntity() {
		
	}

	public ReservationEntity(Integer id, ScreeningEntity screening, String firstName, String lastName,
			LocalDateTime createTime, LocalDateTime expireTime) {
		this.id = id;
		this.screening = screening;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createTime = createTime;
		this.expireTime = expireTime;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ScreeningEntity getScreening() {
		return screening;
	}

	public void setScreening(ScreeningEntity screening) {
		this.screening = screening;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString() {
		return "ReservationEntity [id=" + id + ", screening=" + screening + ", firstName=" + firstName + ", lastName="
				+ lastName + ", createTime=" + createTime + ", expireTime=" + expireTime + "]";
	}
}