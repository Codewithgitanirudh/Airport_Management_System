package com.ty.airportmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.airportmanagementsystem.dto.Flight;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.FlightService;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	
	@PostMapping(value = "/saveFlightDetails")
	public ApplicationResponse<Flight> saveFlightDetailsController(@RequestBody Flight flight) {
		return flightService.saveFlightDetailsService(flight);
	}
	
	@GetMapping(value = "getAllFlight/{source}/{destination}")
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(@PathVariable String source,
			@PathVariable String destination) {
		return flightService.getFlightWithSourceAndDestinationService(source, destination);
	}

}
