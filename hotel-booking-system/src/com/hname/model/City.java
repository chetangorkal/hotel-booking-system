package com.hname.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@Column
	@GeneratedValue
	private long cityId;

	@Column
	private String name;

	@OneToMany(mappedBy = "city")
	private Set<Hotel> hotels;

	public City() {
	}

	public City(int i) {
		this.cityId = i;
	}

	public City(int i, String string) {
		this.cityId = i;
		this.name = string;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

}
