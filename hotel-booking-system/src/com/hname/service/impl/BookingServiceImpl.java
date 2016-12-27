package com.hname.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hname.dao.BookingDao;
import com.hname.dto.BookingFormDto;
import com.hname.exception.RoomsNotAvailableException;
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
	public long bookRoom(BookingFormDto bookingFormDto) {
		try {
			return bookingDao.bookRoom(bookingFormDto);
		} catch (RoomsNotAvailableException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

	@Override
	public List<City> getCities() {
		/*List<City> list = new ArrayList<>();
		list.add(new City(1, "Bengaluru"));
		list.add(new City(2, "Mysore"));
		list.add(new City(3, "Hubli"));

		list = bookingDao.getCities();*/
		return bookingDao.getCities();
	}

	@Override
	public List<Hotel> getHotelsByCityId(long cityId) {
		List<Hotel> hotels = new ArrayList<>();
		hotels = bookingDao.getHotelsByCityId(cityId);
		return hotels;
	}

	@Override
	public List<Room> getRoomsByHotelId(long hotelId) {

		return bookingDao.getRoomsByHotelId(hotelId);
	}

}
