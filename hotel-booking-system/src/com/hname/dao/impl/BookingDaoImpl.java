package com.hname.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hname.dao.BookingDao;
import com.hname.model.Booking;
import com.hname.model.Room;

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
	public long bookRoom(Booking booking) {
		Session session = sessionFactory.openSession();
		long id = (long) session.save(booking);
		return id;
	}

	@Override
	public List<Room> getRoomsByHotelId(long hotelId) {
		List<Room> rooms = new ArrayList<>();
		rooms.add(new Room(1, "Non-AC"));
		rooms.add(new Room(2, "AC"));
		rooms.add(new Room(3, "Non-AC"));
		return rooms;
	}
	
	
}
