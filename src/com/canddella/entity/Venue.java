package com.canddella.entity;

public class Venue {
 
	private String venueId;
	private String venueName;
	private String venueLocation;
	private int venueCapacity;
	private double venueContactNo;
	public Venue(String venueId, String venueName, String venueLocation, int venueCapacity, double venueContactNo) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueLocation = venueLocation;
		this.venueCapacity = venueCapacity;
		this.venueContactNo = venueContactNo;
	}
	public Venue() {
		
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueLocation() {
		return venueLocation;
	}
	public void setVenueLocation(String venueLocation) {
		this.venueLocation = venueLocation;
	}
	public int getVenueCapacity() {
		return venueCapacity;
	}
	public void setVenueCapacity(int venueCapacity) {
		this.venueCapacity = venueCapacity;
	}
	public double getVenueContactNo() {
		return venueContactNo;
	}
	public void setVenueContactNo(double venueContactNo) {
		this.venueContactNo = venueContactNo;
	}
	
	
}
