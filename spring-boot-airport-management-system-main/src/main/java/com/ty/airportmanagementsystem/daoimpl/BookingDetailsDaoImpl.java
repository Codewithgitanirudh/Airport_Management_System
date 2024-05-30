package com.ty.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.airportmanagementsystem.dao.BookingDetailsDao;
import com.ty.airportmanagementsystem.dto.BookingDetails;
import com.ty.airportmanagementsystem.repository.BookingDetailsRepository;

@Repository
public class BookingDetailsDaoImpl implements BookingDetailsDao{
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;

	@Override
	public BookingDetails saveBookingDetailsDao(BookingDetails bookingDetails) {	
		return bookingDetailsRepository.save(bookingDetails);
	}

}
