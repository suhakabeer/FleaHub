package com.canddella.service;

import java.util.List;

import com.canddella.dao.EventDAOImpl;
import com.canddella.entity.Event;

public class EventServiceImpl implements EventService {
      EventDAOImpl eventDAOImpl  = new EventDAOImpl(); 
	@Override
	public void saveEvent(Event event) {
		
		eventDAOImpl.saveEvent(event);
	}

	@Override
	public Event viewEvent(String eventId) {
		
		return  eventDAOImpl.viewEvent(eventId);
	}

	@Override
	public Event deleteEvent(String eventId) {
		
		return eventDAOImpl.deleteEvent(eventId);
	}

	@Override
	public List<Event> listAllEvent() {
		
		return eventDAOImpl.listAllEvent();
	}

	@Override
	public Event getEvent(String EventId) {
		
		return eventDAOImpl.getEvent(EventId);
	}

	@Override
	public void updateEvent(String EventId, String eventStore, String eventName) {
		
		eventDAOImpl.updateEvent(EventId, eventStore, eventName);
	}

}
