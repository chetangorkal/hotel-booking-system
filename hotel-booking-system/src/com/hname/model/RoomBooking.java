package com.hname.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(@NamedQuery(name = "getAvailableRooms", query = "from RoomBooking rb where rb.hotel.hotelId = :hotelID and rb.checkInDate = :checkIn and rb.checkOutDate = :checkOut and rb.isAvailable = true"))
public class RoomBooking {

	@Id
	@Column
	@GeneratedValue
	private long roomBookingId;

	@ManyToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;

	@ManyToOne
	@JoinColumn(name = "roomId", insertable = false, updatable = false)
	private Room room;

	@ManyToOne
	@JoinColumn(name = "hotelId", insertable = false, updatable = false)
	private Hotel hotel;

	@Column
	private Date checkInDate;

	@Column
	private Date checkOutDate;

	@Column
	private boolean isAvailable;

	public RoomBooking() {
		super();
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Room getRoom() {
		return room;
	}

	public long getRoomBookingId() {
		return roomBookingId;
	}

	public void setRoomBookingId(long roomBookingId) {
		this.roomBookingId = roomBookingId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
