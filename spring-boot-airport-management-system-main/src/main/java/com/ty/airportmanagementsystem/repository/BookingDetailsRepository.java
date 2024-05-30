package com.ty.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.airportmanagementsystem.dto.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, String>{

}
