package com.hname.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "booked_room", joinColumns = { @JoinColumn(name = "bookingId") }, inverseJoinColumns = {
			@JoinColumn(name = "roomId") })
	private Set<Room> rooms;

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

}
