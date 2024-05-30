package com.ty.airportmanagementsystem.daoimpl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.airportmanagementsystem.dao.FlightDao;
import com.ty.airportmanagementsystem.dto.Flight;
import com.ty.airportmanagementsystem.repository.FlightRepository;

@Repository
public class FlightDaoImpl implements FlightDao {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public Flight saveFlightDetailsDao(Flight flight) {
		
		LocalTime departureTime = flight.getFlightDepartureTime();
		LocalTime arrivalTime = flight.getFlightArrivalTime();

		int hours = arrivalTime.getHour() - departureTime.getHour();
		int minutes = 0;
		if (arrivalTime.getMinute() > departureTime.getMinute()) {
			minutes = arrivalTime.getMinute() - departureTime.getMinute();
		} else {
			minutes = departureTime.getMinute() - arrivalTime.getMinute();
		}

		String totalHours = hours + "hrs :" + minutes + "minutes";

		flight.setFlightDuration(totalHours);
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> getFlightWithSourceAndDestinationDao(String source, String destination) {
		List<Flight> flights = flightRepository.findAll();
		
		flights.stream()
		.filter(a -> a.getFlightSource().equalsIgnoreCase(source) && a.getFlightDestination().equalsIgnoreCase(destination)).toList();
		
		return flights;
	}

}
