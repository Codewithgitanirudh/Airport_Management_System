package com.ty.airportmanagementsystem.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {
	
	@Id
	private String pnr;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private LocalDate journeyDate;
	private LocalDate bookingDate;
	private double totalPrice;
	private int convenienceFee;
	private String cancel;

}