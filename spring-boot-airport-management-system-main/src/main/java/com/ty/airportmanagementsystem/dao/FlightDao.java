package com.ty.airportmanagementsystem.dao;

import java.util.List;

import com.ty.airportmanagementsystem.dto.Flight;

public interface FlightDao {

	public Flight saveFlightDetailsDao(Flight flight);
	
	public List<Flight> getFlightWithSourceAndDestinationDao(String source, String destination);
}
