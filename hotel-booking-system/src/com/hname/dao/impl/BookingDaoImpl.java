package com.hname.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.hname.dao.BookingDao;
import com.hname.dto.BookingFormDto;
import com.hname.exception.RoomsNotAvailableException;
import com.hname.model.Booking;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;
import com.hname.model.RoomBooking;

public class BookingDaoImpl implements BookingDao {

	static Logger log = Logger.getLogger(BookingDaoImpl.class.getName());
	
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
	public Booking bookRoom(BookingFormDto bookingFormDto) throws RoomsNotAvailableException {
		session = sessionFactory.openSession();
		session.getTransaction().begin();

		log.debug("Fetching available rooms from DB.");
		Query query = session.getNamedQuery("getAvailableRooms");
		query.setParameter("hotelID", bookingFormDto.getHotelId());
		query.setParameter("checkIn", bookingFormDto.getCheckInDate());
		query.setParameter("checkOut", bookingFormDto.getCheckOutDate());
		@SuppressWarnings("unchecked")
		List<RoomBooking> availableRooms = query.list();
		log.debug("There are rooms available. Found " + availableRooms.size() + " rooms.");
		Booking booking = new Booking();
		long bookingId;
		int noOfRooms = bookingFormDto.getNoOfRooms();
		if (availableRooms.size() >= noOfRooms) {
			RoomBooking availableRoom;
			for (int i = 0; i < noOfRooms; i++) {
				availableRoom = availableRooms.get(i);
				availableRoom.setBooking(booking);
				availableRoom.setAvailable(false);
				session.merge(availableRoom);
			}
			booking.setNoOfRooms(bookingFormDto.getNoOfRooms());
			booking.setStatus(true);
			Hotel hotel = (Hotel) session.get(Hotel.class, bookingFormDto.getHotelId());
			booking.setBookingAmount(noOfRooms * hotel.getPricePerDayPerRoom());
			bookingId = (long) session.save(booking);
		}
		session.getTransaction().commit();
		log.debug("Booking transaction completed succesfully.");
		return booking;
	}

	@Override
	@Cacheable("cities")
	public List<City> getCities() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from City");
		List<City> cities = query.list();
		log.debug("Found " + cities.size() + " cities.");		
		return cities;

	}

	@Override
	@Cacheable("hotels")
	public List<Hotel> getHotelsByCityId(long cityId) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Hotel where cityId = " + cityId);
		List<Hotel> hotels = query.list();
		log.debug("Found " + hotels.size() + " hotels.");

		session.close();
		return hotels;
	}

/*	@Override
	public List<Room> getRoomsByHotelId(long hotelId) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Room where hotelId = " + hotelId);
		List<Room> rooms = query.list();
		session.close();
		return rooms;
	}
*/
	@Override
	public List<Hotel> getLowestPriceHotelsByCityId(long cityId) {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Hotel.class, "hotel");
		criteria.createAlias("hotel.city", "city");
		criteria.addOrder(Order.asc("pricePerDayPerRoom"));
		criteria.setMaxResults(5);
		criteria.add(Restrictions.and(Restrictions.eq("city.cityId", cityId)));
		List<Hotel> hotels = criteria.list();
		session.close();
		return hotels;
	}
}
