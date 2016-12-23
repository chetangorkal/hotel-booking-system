package com.hname.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hname.dao.BookingDao;
import com.hname.model.Booking;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;
import com.hname.service.BookingService;

public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	public BookingDao getBookingDao() {
		return bookingDao;
	}

	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	@Override
	public String bookRoom(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.bookRoom(booking);
	}

	@Override
	public List<City> getCities() {
		// TODO Auto-generated method stub
		List<City> list = new ArrayList<>();
		list.add(new City(1,"Bengaluru"));
		list.add(new City(2,"Mysore"));
		list.add(new City(3,"Hubli"));
		return list;
	}

	@Override
	public List<Hotel> getHotelsByCityId(long cityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getRoomsByHotelId(long hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
