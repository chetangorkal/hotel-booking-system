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
	public long bookRoom(Booking booking) {
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
		List<Hotel> hotels = new ArrayList<>();
		hotels.add(new Hotel(1,"hotel1Name","hotel1Address","hotel1Phone"));
		hotels.add(new Hotel(2,"hotel2Name","hotel2Address","hotel2Phone"));
		hotels.add(new Hotel(3,"hotel3Name","hotel3Address","hotel3Phone"));
		hotels.add(new Hotel(4,"hotel4Name","hotel4Address","hotel4Phone"));
		hotels.add(new Hotel(5,"hotel5Name","hotel5Address","hotel5Phone"));
		hotels.add(new Hotel(6,"hotel6Name","hotel6Address","hotel6Phone"));
		return hotels;
	}

	@Override
	public List<Room> getRoomsByHotelId(long hotelId) {
		
		return bookingDao.getRoomsByHotelId(hotelId);
	}

}
