package com.hname.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hname.model.Booking;
import com.hname.service.BookingService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="/bookRoom", method=RequestMethod.POST)
	public String bookRoom(@ModelAttribute("booking") Booking booking){
		return bookingService.bookRoom(booking);
	}
	
	@RequestMapping(value="/booking", method=RequestMethod.GET)
	public String getBookingForm(@ModelAttribute("booking") Booking booking, ModelMap model){
		model.addAttribute("booking", new Booking());
		return "booking";
	}

}
