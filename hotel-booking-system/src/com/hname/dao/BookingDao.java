package com.hname.dao;

import java.util.List;

import com.hname.dto.BookingFormDto;
import com.hname.exception.RoomsNotAvailableException;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;

public interface BookingDao {

	long bookRoom(BookingFormDto bookingFormDto) throws RoomsNotAvailableException;

	List<Room> getRoomsByHotelId(long hotelId);

	List<City> getCities();

	List<Hotel> getHotelsByCityId(long cityId);

}
