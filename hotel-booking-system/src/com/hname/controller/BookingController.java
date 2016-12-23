package com.hname.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hname.model.Booking;
import com.hname.model.City;
import com.hname.model.Hotel;
import com.hname.model.Room;
import com.hname.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/booking", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<City> booking() {
		return bookingService.getCities();
	}

	@RequestMapping(value = "/city/{cityId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Hotel> getHotelsByCity(@PathVariable("cityId") long cityId) {
		return bookingService.getHotelsByCityId(cityId);
	}

	@RequestMapping(value = "/hotel/{hotelId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Room> getRoomsByHotel(@PathVariable("hotelId") long hotelId) {
		return bookingService.getRoomsByHotelId(hotelId);
	}

	@RequestMapping(value = "/bookRoom", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public long bookRoom(@RequestParam("roomId") long roomId) {
		Booking booking = new Booking();
		Set<Room> rooms = new HashSet<>();
		rooms.add(new Room(roomId));
		booking.setRooms(rooms);
		return bookingService.bookRoom(booking);
	}

}
