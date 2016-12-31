package com.hname.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hname.dto.BookingFormDto;
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
	public List<City> booking(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Connection", "close");
		return bookingService.getCities();
	}

	@RequestMapping(value = "/city/{cityId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Hotel> getHotelsByCity(@PathVariable("cityId") long cityId) {
		return bookingService.getHotelsByCityId(cityId);
	}

	@RequestMapping(value = "/best_prices/{cityId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Hotel> getLowestPriceHotelsByCity(@PathVariable("cityId") long cityId) {
		return bookingService.getLowestPriceHotelsByCityId(cityId);
	}

/*	@RequestMapping(value = "/hotel/{hotelId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Room> getRoomsByHotel(@PathVariable("hotelId") long hotelId) {
		return bookingService.getRoomsByHotelId(hotelId);
	}
*/
	@RequestMapping(value = "/bookRoom", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Booking bookRoom(@RequestBody BookingFormDto bookingFormDto) {
		return bookingService.bookRoom(bookingFormDto);
	}

}
