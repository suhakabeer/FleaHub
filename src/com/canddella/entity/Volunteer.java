package com.canddella.entity;

import java.time.LocalDate;

public class Volunteer {

	private String volunteerId;
	private Event event;
	private String volunteerName;
	private String volunteerEmail;
	private double volunteerPhoneNo;
	private String volunteerAddress;
	private String volunteerCity;
	private String volunteerState;
	private String volunteerCountry;
	private int volunteerZipcode;
	private LocalDate volunteerRegistrationDate;
	public Volunteer(String volunteerId, Event event, String volunteerName, String volunteerEmail,
			double volunteerPhoneNo, String volunteerAddress, String volunteerCity, String volunteerState,
			String volunteerCountry, int volunteerZipcode, LocalDate volunteerRegistrationDate) {
		super();
		this.volunteerId = volunteerId;
		this.event = event;
		this.volunteerName = volunteerName;
		this.volunteerEmail = volunteerEmail;
		this.volunteerPhoneNo = volunteerPhoneNo;
		this.volunteerAddress = volunteerAddress;
		this.volunteerCity = volunteerCity;
		this.volunteerState = volunteerState;
		this.volunteerCountry = volunteerCountry;
		this.volunteerZipcode = volunteerZipcode;
		this.volunteerRegistrationDate = volunteerRegistrationDate;
	}
	public String getVolunteerId() {
		return volunteerId;
	}
	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getVolunteerName() {
		return volunteerName;
	}
	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}
	public String getVolunteerEmail() {
		return volunteerEmail;
	}
	public void setVolunteerEmail(String volunteerEmail) {
		this.volunteerEmail = volunteerEmail;
	}
	public double getVolunteerPhoneNo() {
		return volunteerPhoneNo;
	}
	public void setVolunteerPhoneNo(double volunteerPhoneNo) {
		this.volunteerPhoneNo = volunteerPhoneNo;
	}
	public String getVolunteerAddress() {
		return volunteerAddress;
	}
	public void setVolunteerAddress(String volunteerAddress) {
		this.volunteerAddress = volunteerAddress;
	}
	public String getVolunteerCity() {
		return volunteerCity;
	}
	public void setVolunteerCity(String volunteerCity) {
		this.volunteerCity = volunteerCity;
	}
	public String getVolunteerState() {
		return volunteerState;
	}
	public void setVolunteerState(String volunteerState) {
		this.volunteerState = volunteerState;
	}
	public String getVolunteerCountry() {
		return volunteerCountry;
	}
	public void setVolunteerCountry(String volunteerCountry) {
		this.volunteerCountry = volunteerCountry;
	}
	public int getVolunteerZipcode() {
		return volunteerZipcode;
	}
	public void setVolunteerZipcode(int volunteerZipcode) {
		this.volunteerZipcode = volunteerZipcode;
	}
	public LocalDate getVolunteerRegistrationDate() {
		return volunteerRegistrationDate;
	}
	public void setVolunteerRegistrationDate(LocalDate volunteerRegistrationDate) {
		this.volunteerRegistrationDate = volunteerRegistrationDate;
	}	
	
}
