package com.canddella.service;

import java.util.List;

import com.canddella.entity.EventRegistration;

public interface EventRegistrationService {
	public void saveEventRegistration(EventRegistration eventRegistrationId);
	public EventRegistration viewEventRegistration(String eventRegistrationId);
	public EventRegistration deleteEventRegistration(String eventRegistrationId);
	public List<EventRegistration> viewAllEventRegistration();
	
}
