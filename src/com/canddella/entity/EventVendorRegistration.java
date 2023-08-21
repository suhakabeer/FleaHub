package com.canddella.entity;

import java.time.LocalDate;

public class EventVendorRegistration {
		private String eventVendorRegistrationId;
		private Vendor vendor ;
		private EventRegistration eventRegistration;
		private LocalDate eventVendorRegistrationDate;
		private int numberOfTables;
		public EventVendorRegistration(String eventVendorRegistrationId, Vendor vendor,
				EventRegistration eventRegistration, LocalDate eventVendorRegistrationDate, int numberOfTables) {
			super();
			this.eventVendorRegistrationId = eventVendorRegistrationId;
			this.vendor = vendor;
			this.eventRegistration = eventRegistration;
			this.eventVendorRegistrationDate = eventVendorRegistrationDate;
			this.numberOfTables = numberOfTables;
		}
		public EventVendorRegistration() {
			
		}
		public String getEventVendorRegistrationId() {
			return eventVendorRegistrationId;
		}
		public void setEventVendorRegistrationId(String eventVendorRegistrationId) {
			this.eventVendorRegistrationId = eventVendorRegistrationId;
		}
		public Vendor getVendor() {
			return vendor;
		}
		public void setVendor(Vendor vendor) {
			this.vendor = vendor;
		}
		public EventRegistration getEventRegistration() {
			return eventRegistration;
		}
		public void setEventRegistration(EventRegistration eventRegistration) {
			this.eventRegistration = eventRegistration;
		}
		public LocalDate getEventVendorRegistrationDate() {
			return eventVendorRegistrationDate;
		}
		public void setEventVendorRegistrationDate(LocalDate eventVendorRegistrationDate) {
			this.eventVendorRegistrationDate = eventVendorRegistrationDate;
		}
		public int getNumberOfTables() {
			return numberOfTables;
		}
		public void setNumberOfTables(int numberOfTables) {
			this.numberOfTables = numberOfTables;
		}
		
		
		}
