package com.canddella.dao;


import java.util.List;

import com.canddella.entity.EventRegistration;

public interface EventRegistrationDAO {
	

	public void saveEventRegistration(EventRegistration eventRegistration);
	public EventRegistration viewEventRegistration (String eventRegistrationId);
	public EventRegistration deleteEventRegistration(String eventRegistrationId);
	public List<EventRegistration> viewAllEventRegistration();
	
	
}
