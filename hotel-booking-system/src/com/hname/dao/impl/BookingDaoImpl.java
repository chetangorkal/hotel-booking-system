package com.hname.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.hname.dao.BookingDao;
import com.hname.dto.BookingFormDto;
import com.hname.exception.RoomsNotAvailableException;
import com.hname.model.Booking;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;
import com.hname.model.RoomBooking;

public class BookingDaoImpl implements BookingDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public long bookRoom(BookingFormDto bookingFormDto) throws RoomsNotAvailableException {
		session = sessionFactory.openSession();
		Booking booking = new Booking();
		booking.setNoOfRooms(bookingFormDto.getNoOfRooms());
		long id = (long) session.save(booking);

		Query query = session.getNamedQuery("getAvailableRooms");
		query.setParameter("hotelID", bookingFormDto.getHotelId());
		query.setParameter("checkIn", bookingFormDto.getCheckInDate());
		query.setParameter("checkOut", bookingFormDto.getCheckOutDate());
		@SuppressWarnings("unchecked")
		List<RoomBooking> availableRooms = query.list();

		int noOfRooms = bookingFormDto.getNoOfRooms();
		if (availableRooms.size() >= noOfRooms) {
			RoomBooking availableRoom;
			for (int i = 0; i < noOfRooms; i++) {
				availableRoom = availableRooms.get(i);
				availableRoom.setBooking(booking);
				availableRoom.setAvailable(false);
				session.update(availableRoom);
			}
			booking.setStatus(true);
			session.update(booking);
		}
		return id;
	}

	private void updateRoomsAvailabilty(long hotelId, int noOfRooms) throws RoomsNotAvailableException {
		session = sessionFactory.openSession();
		Hotel hotel = (Hotel) session.get(Hotel.class, hotelId);
		if (hotel.getAvailableRoomsCount() < noOfRooms) {
			throw new RoomsNotAvailableException();
		}
		hotel.setAvailableRoomsCount(hotel.getAvailableRoomsCount() - noOfRooms);
		session.save(hotel);
	}

	@Override
	public List<City> getCities() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from City");
		List<City> cities = query.list();
		return cities;

	}

	@Override
	public List<Hotel> getHotelsByCityId(long cityId) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Hotel where cityId = " + cityId);
		List<Hotel> hotels = query.list();
		session.close();
		return hotels;
	}

	@Override
	public List<Room> getRoomsByHotelId(long hotelId) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Room where hotelId = " + hotelId);
		List<Room> rooms = query.list();
		session.close();
		return rooms;
	}
}
