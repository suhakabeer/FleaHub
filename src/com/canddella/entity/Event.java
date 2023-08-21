package com.canddella.entity;

import java.time.LocalDate;

public class Event {
 private String eventId;
 private String eventName;
 private String eventDescribtion;
 private LocalDate eventStartDate;
 private LocalDate eventEndDate;
 private int totalVolunteer;
public Event(String eventId, String eventName, String eventDescribtion, LocalDate eventStartDate,
		LocalDate eventEndDate, int totalVolunteer) {
	super();
	this.eventId = eventId;
	this.eventName = eventName;
	this.eventDescribtion = eventDescribtion;
	this.eventStartDate = eventStartDate;
	this.eventEndDate = eventEndDate;
	this.totalVolunteer = totalVolunteer;
}
public Event() {

}
public String getEventId() {
	return eventId;
}
public void setEventId(String eventId) {
	this.eventId = eventId;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getEventDescribtion() {
	return eventDescribtion;
}
public void setEventDescribtion(String eventDescribtion) {
	this.eventDescribtion = eventDescribtion;
}
public LocalDate getEventStartDate() {
	return eventStartDate;
}
public void setEventStartDate(LocalDate eventStartDate) {
	this.eventStartDate = eventStartDate;
}
public LocalDate getEventEndDate() {
	return eventEndDate;
}
public void setEventEndDate(LocalDate eventEndDate) {
	this.eventEndDate = eventEndDate;
}
public int getTotalVolunteer() {
	return totalVolunteer;
}
public void setTotalVolunteer(int totalVolunteer) {
	this.totalVolunteer = totalVolunteer;
}
 

}
