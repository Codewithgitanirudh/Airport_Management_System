package com.ty.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.airportmanagementsystem.dao.BookingDetailsDao;
import com.ty.airportmanagementsystem.dto.BookingDetails;

@RestController
@RequestMapping(value="/bookingDetails")
public class BookingDetailsController {

	@Autowired 
	private BookingDetailsDao bookingDetailsDao;
	
	@PostMapping(value = "/saveBookingDetails")
	public BookingDetails saveBookingDetailsDao(@RequestBody BookingDetails bookingDetails) {
		
	   return bookingDetailsDao.saveBookingDetailsDao(bookingDetails);
	}
	
}
