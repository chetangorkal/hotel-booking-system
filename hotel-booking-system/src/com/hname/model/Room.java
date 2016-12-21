package com.hname.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {

	@Id
	@Column
	@GeneratedValue
	private long roomId;
	
	@ManyToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;
	
	@Column
	private String roomType;
	
	@ManyToOne
	@JoinColumn(name="hotelId")
	private Hotel hotel;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="hotelId") public Hotel getHotel() { return hotel; }
	 * 
	 * public void setHotel(Hotel hotel) { this.hotel = hotel; }
	 */
}
