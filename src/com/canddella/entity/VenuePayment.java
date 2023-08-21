package com.canddella.entity;

import java.time.LocalDate;

public class VenuePayment {
    private String venuePaymentId;
    private Venue venue;
    private double venuePaymentAmount;
    private LocalDate venuePaymentDate;
    private String venuePaymentMode; 
    private String venuePaymentStatus;
	public VenuePayment(String venuePaymentId, Venue venue, double venuePaymentAmount, LocalDate venuePaymentDate,
			String venuePaymentMode, String venuePaymentStatus) {
		super();
		this.venuePaymentId = venuePaymentId;
		this.venue = venue;
		this.venuePaymentAmount = venuePaymentAmount;
		this.venuePaymentDate = venuePaymentDate;
		this.venuePaymentMode = venuePaymentMode;
		this.venuePaymentStatus = venuePaymentStatus;
	}
	public String getVenuePaymentId() {
		return venuePaymentId;
	}
	public void setVenuePaymentId(String venuePaymentId) {
		this.venuePaymentId = venuePaymentId;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public double getVenuePaymentAmount() {
		return venuePaymentAmount;
	}
	public void setVenuePaymentAmount(double venuePaymentAmount) {
		this.venuePaymentAmount = venuePaymentAmount;
	}
	public LocalDate getVenuePaymentDate() {
		return venuePaymentDate;
	}
	public void setVenuePaymentDate(LocalDate venuePaymentDate) {
		this.venuePaymentDate = venuePaymentDate;
	}
	public String getVenuePaymentMode() {
		return venuePaymentMode;
	}
	public void setVenuePaymentMode(String venuePaymentMode) {
		this.venuePaymentMode = venuePaymentMode;
	}
	public String getVenuePaymentStatus() {
		return venuePaymentStatus;
	}
	public void setVenuePaymentStatus(String venuePaymentStatus) {
		this.venuePaymentStatus = venuePaymentStatus;
	}
    
    
    
}