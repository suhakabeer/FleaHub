package com.canddella.dao;

import java.util.List;

import com.canddella.entity.EventVendorRegistration;

public interface EventVendorRegistrationDAO {
	public void saveEventVendorRegistration(EventVendorRegistration eventVendorRegistration);
	public EventVendorRegistration viewEventVendorRegistration (String eventVendorRegistrationId);
	public EventVendorRegistration deleteEventVendorRegistration(String eventVendorRegistrationId);
	public List<EventVendorRegistration> viewAllEventVendorRegistration();

	int totalNumberOfTables(String eventVendorRegistrationId);
	int TotalCapacity(String eventRegistrationId);

}
