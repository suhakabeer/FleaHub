package com.canddella.entity;

import java.time.LocalDate;

public class EventRegistration {
  	 private String eventRegistrationId;
  	 private Venue venue;
	 private Event event;	
	 private LocalDate eventRegistrationDate;
	public EventRegistration(String eventRegistrationId, Venue venue, Event event, LocalDate eventRegistrationDate) {
		super();
		this.eventRegistrationId = eventRegistrationId;
		this.venue = venue;
		this.event = event;
		this.eventRegistrationDate = eventRegistrationDate;
	}
	public EventRegistration() {
		
	}
	public String getEventRegistrationId() {
		return eventRegistrationId;
	}
	public void setEventRegistrationId(String eventRegistrationId) {
		this.eventRegistrationId = eventRegistrationId;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public LocalDate getEventRegistrationDate() {
		return eventRegistrationDate;
	}
	public void setEventRegistrationDate(LocalDate eventRegistrationDate) {
		this.eventRegistrationDate = eventRegistrationDate;
	}
	
	
}
