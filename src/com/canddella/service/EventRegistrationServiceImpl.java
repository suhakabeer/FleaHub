package com.canddella.service;

import java.util.List;

import com.canddella.dao.EventRegistrationDAOImpl;
import com.canddella.entity.EventRegistration;


public class EventRegistrationServiceImpl implements EventRegistrationService {

	EventRegistrationDAOImpl eventRegistrationDAOImpl = new EventRegistrationDAOImpl();
	
	@Override
	public void saveEventRegistration(EventRegistration eventRegistration) {
		
		eventRegistrationDAOImpl.saveEventRegistration(eventRegistration);
	}

	@Override
	public EventRegistration viewEventRegistration(String eventRegistrationId) {
		
		return eventRegistrationDAOImpl.viewEventRegistration(eventRegistrationId);
	}

	@Override
	public EventRegistration deleteEventRegistration(String eventRegistrationId) {
		
		return eventRegistrationDAOImpl.deleteEventRegistration(eventRegistrationId);
	}

	@Override
	public List<EventRegistration> viewAllEventRegistration() {
		
		return eventRegistrationDAOImpl.viewAllEventRegistration();
	}

}
