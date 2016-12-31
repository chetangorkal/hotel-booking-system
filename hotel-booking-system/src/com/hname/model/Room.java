package com.hname.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@Column
	@GeneratedValue
	private long roomId;

	@Column
	private String roomType;

	@OneToMany(mappedBy = "room")
	private Set<RoomBooking> roomBookings;
	
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotel;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Set<RoomBooking> getRoomBookings() {
		return roomBookings;
	}

	public void setRoomBookings(Set<RoomBooking> roomBookings) {
		this.roomBookings = roomBookings;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
