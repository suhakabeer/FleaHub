package com.canddella.service;

import java.util.List;

import com.canddella.dao.EventVendorRegistrationDAOImpl;
import com.canddella.entity.EventVendorRegistration;


public class EventVendorRegistrationServiceImpl implements EventVendorRegistrationService {

	
	EventVendorRegistrationDAOImpl eventVendorRegistrationDAOImpl = new EventVendorRegistrationDAOImpl();
	
	@Override
	public void saveEventVendorRegistration(EventVendorRegistration eventVendorRegistration) {
		
		eventVendorRegistrationDAOImpl.saveEventVendorRegistration(eventVendorRegistration);
	}

	@Override
	public EventVendorRegistration viewEventVendorRegistration(String eventVendorRegistrationId) {
		
		return eventVendorRegistrationDAOImpl.viewEventVendorRegistration(eventVendorRegistrationId);
	}

	@Override
	public EventVendorRegistration deleteEventVendorRegistration(String eventVendorRegistrationId) {
		
		return eventVendorRegistrationDAOImpl.deleteEventVendorRegistration(eventVendorRegistrationId);
	}

	@Override
	public List<EventVendorRegistration> viewAllEventVendorRegistration() {
	
		return eventVendorRegistrationDAOImpl.viewAllEventVendorRegistration();
	}


	

	@Override
	public int totalNumberOfTables(String eventRegistrationId) {
		
		return eventVendorRegistrationDAOImpl.totalNumberOfTables(eventRegistrationId);
	}
	@Override
	public int TotalCapacity(String eventRegistrationId) {
		
		return eventVendorRegistrationDAOImpl.TotalCapacity(eventRegistrationId);
	}

	

}
