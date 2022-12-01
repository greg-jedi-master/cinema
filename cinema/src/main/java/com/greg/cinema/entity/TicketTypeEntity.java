package com.greg.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_types")
public class TicketTypeEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private float price;
	
	public TicketTypeEntity() {
		
	}

	public TicketTypeEntity(Integer id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketTypeEntity [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
