package com.ty.airportmanagementsystem.service;

import java.util.List;

import com.ty.airportmanagementsystem.dto.Flight;
import com.ty.airportmanagementsystem.response.ApplicationResponse;

public interface FlightService {

	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight);
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source, String destination);
}
