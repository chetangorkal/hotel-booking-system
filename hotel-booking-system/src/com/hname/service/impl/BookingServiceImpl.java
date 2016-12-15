package com.hname.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hname.dao.BookingDao;
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

}
