package com.hname.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hname.dao.BookingDao;
import com.hname.model.Booking;

public class BookingDaoImpl implements BookingDao{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String bookRoom(Booking booking) {
		Session session = sessionFactory.openSession();
		session.save(booking);
		return "booking";
	}
	
	
}
