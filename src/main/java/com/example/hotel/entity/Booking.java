package com.example.hotel.entity;

import jakarta.persistence.*;

@Entity
public class Booking {
	
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	private String customerName;
	
	private int days;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	
	private Room room;
	
	public int getId() { return id;}
	
	public String getcustomerName() { return customerName ;}
	
	public Room getRoom() {
		return room;
    }
	
	public void setId(int id) {
		this.id = id;
	}
	public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }
	
	public void setCustomerName(String name) {
		this.customerName= customerName;
	}
	public void setRoom() {
		this.room = room;
	}
	
	

}
