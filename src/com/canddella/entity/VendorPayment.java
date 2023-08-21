package com.canddella.entity;

import java.time.LocalDate;

public class VendorPayment {

  private String vendorPaymentId;
  private EventVendorRegistration eventVendorRegistration;
  private double vendorPaymentAmount;
  private LocalDate vendorPaymentDate;
  private String vendorPaymentMode;
  private String vendorPaymentStatus;
public VendorPayment(String vendorPaymentId, EventVendorRegistration eventVendorRegistration,
		double vendorPaymentAmount, LocalDate vendorPaymentDate, String vendorPaymentMode, String vendorPaymentStatus) {
	super();
	this.vendorPaymentId = vendorPaymentId;
	this.eventVendorRegistration = eventVendorRegistration;
	this.vendorPaymentAmount = vendorPaymentAmount;
	this.vendorPaymentDate = vendorPaymentDate;
	this.vendorPaymentMode = vendorPaymentMode;
	this.vendorPaymentStatus = vendorPaymentStatus;
}
public String getVendorPaymentId() {
	return vendorPaymentId;
}
public void setVendorPaymentId(String vendorPaymentId) {
	this.vendorPaymentId = vendorPaymentId;
}
public EventVendorRegistration getEventVendorRegistration() {
	return eventVendorRegistration;
}
public void setEventVendorRegistration(EventVendorRegistration eventVendorRegistration) {
	this.eventVendorRegistration = eventVendorRegistration;
}
public double getVendorPaymentAmount() {
	return vendorPaymentAmount;
}
public void setVendorPaymentAmount(double vendorPaymentAmount) {
	this.vendorPaymentAmount = vendorPaymentAmount;
}
public LocalDate getVendorPaymentDate() {
	return vendorPaymentDate;
}
public void setVendorPaymentDate(LocalDate vendorPaymentDate) {
	this.vendorPaymentDate = vendorPaymentDate;
}
public String getVendorPaymentMode() {
	return vendorPaymentMode;
}
public void setVendorPaymentMode(String vendorPaymentMode) {
	this.vendorPaymentMode = vendorPaymentMode;
}
public String getVendorPaymentStatus() {
	return vendorPaymentStatus;
}
public void setVendorPaymentStatus(String vendorPaymentStatus) {
	this.vendorPaymentStatus = vendorPaymentStatus;
}
  
}
	
	

