package com.hname.service;

import java.util.List;

import com.hname.model.Booking;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;

public interface BookingService {

	String bookRoom(Booking booking);

	List<City> getCities();

	List<Hotel> getHotelsByCityId(long cityId);

	List<Room> getRoomsByHotelId(long hotelId);

}
