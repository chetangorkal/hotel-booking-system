package com.hname.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Booking {

	@Id
	@Column
	@GeneratedValue
	private long bookingId;
	
	@Column
	private String name;

	@Column
	private int age;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
	private Set<Room> rooms;
	// private Hotel hotel;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	/*
	 * @OneToMany(mappedBy="booking") public Hotel getHotel() { return hotel; }
	 * 
	 * public void setHotel(Hotel hotel) { this.hotel = hotel; }
	 */
}
