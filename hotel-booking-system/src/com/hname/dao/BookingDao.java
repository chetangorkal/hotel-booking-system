package com.hname.dao;

import java.util.List;

import com.hname.model.Booking;
import com.hname.model.Room;

public interface BookingDao {

	long bookRoom(Booking booking);

	List<Room> getRoomsByHotelId(long hotelId);

}
