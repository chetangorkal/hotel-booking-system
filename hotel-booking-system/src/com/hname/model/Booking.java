package com.hname.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Booking {

	@Id
	@Column
	@GeneratedValue
	private long bookingId;

	@OneToMany(mappedBy="booking")
	private Set<RoomBooking> roomBookings;

	private int noOfRooms;
	
	private boolean status;
	

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Set<RoomBooking> getRoomBookings() {
		return roomBookings;
	}

	public void setRoomBookings(Set<RoomBooking> roomBookings) {
		this.roomBookings = roomBookings;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

}
