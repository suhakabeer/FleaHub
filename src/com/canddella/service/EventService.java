package com.canddella.service;

import java.util.List;

import com.canddella.entity.Event;
import com.canddella.entity.Venue;

public interface EventService {
	public void saveEvent(Event event);
	public Event viewEvent(String eventId);
	public Event deleteEvent(String eventId);
	public List<Event> listAllEvent();
	public Event getEvent(String EventId);
	public void updateEvent(String EventId, String eventStore, String eventName);
	
}
