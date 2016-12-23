package com.hname.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hname.model.Booking;
import com.hname.model.City;
import com.hname.model.Room;
import com.hname.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage(ModelMap map) {
		return "home";
	}

	@RequestMapping(value="/booking", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<City> booking(ModelMap map) {
		map.addAttribute("booking", new Booking());
		map.addAttribute("cities", bookingService.getCities());
		return bookingService.getCities();
	}
	
/*	@RequestMapping(value="/cities", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getCities(ModelMap map) {
		map.addAttribute("cities", bookingService.getCities());
		return "booking";
	}
*/

	@RequestMapping(value="/city/{cityId}", method=RequestMethod.GET)
	public String getHotelsByCity(@RequestParam("cityId") long cityId, ModelMap map) {
		map.addAttribute("hotels", bookingService.getHotelsByCityId(cityId));
		return "booking";
	}
	
	@RequestMapping(value="/hotel/{hotedId}", method=RequestMethod.GET)
	public String getRoomsByHotel(@RequestParam("hotelId") long hotelId, ModelMap map) {
		map.addAttribute("rooms", bookingService.getRoomsByHotelId(hotelId));
		return "booking";
	}

	@RequestMapping(value="/bookRoom", method=RequestMethod.POST)
	public String addRecordInBooking(@ModelAttribute("booking") Booking booking, ModelMap model) {
		model.addAttribute("booking",booking);
		return bookingService.bookRoom(booking);
	}

	@RequestMapping(value="/bookRooms", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public String bookRoom(@ModelAttribute("booking") Booking booking,@ModelAttribute("rooms") Room[] rooms, ModelMap model) {
		model.addAttribute("booking",booking);
		return bookingService.bookRoom(booking);
	}

}
