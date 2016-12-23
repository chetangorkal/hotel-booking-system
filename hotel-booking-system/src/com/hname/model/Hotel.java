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
public class Hotel {

	@Id
	@Column
	@GeneratedValue
	private long hotelId;
	private String name;
	private String address;
	private String phone;

	@ManyToOne
	@JoinColumn(name = "cityId")
	private City city;

	@OneToMany(mappedBy = "hotel")
	private Set<Room> rooms;

	// private Booking booking;

	public Hotel() {
	}

	public Hotel(int hotelId, String name, String address, String phone) {
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
