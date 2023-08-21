package com.canddella.service;

import java.util.List;

import com.canddella.entity.EventVendorRegistration;

public interface EventVendorRegistrationService {
	public void saveEventVendorRegistration(EventVendorRegistration eventVendorRegistration);
	public EventVendorRegistration viewEventVendorRegistration (String eventVendorRegistrationId);
	public EventVendorRegistration deleteEventVendorRegistration(String eventVendorRegistrationId);
	public List<EventVendorRegistration> viewAllEventVendorRegistration();
	int totalNumberOfTables(String eventRegistrationId);
	int TotalCapacity(String eventRegistrationId);
	
}
