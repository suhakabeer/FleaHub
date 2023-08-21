package com.canddella.entity;

import java.time.LocalDate;

public class Customer {

private String customerId;
private String customerName;
private String customerAddress;
private int Customerzipcode;
private double customerPhoneNo;
private String customerEmail;
private LocalDate customerDate;
public Customer(String customerId, String customerName, String customerAddress, int customerzipcode,
		double customerPhoneNo, String customerEmail, LocalDate customerDate) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerAddress = customerAddress;
	Customerzipcode = customerzipcode;
	this.customerPhoneNo = customerPhoneNo;
	this.customerEmail = customerEmail;
	this.customerDate = customerDate;
}
public Customer() {
	
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public int getCustomerzipcode() {
	return Customerzipcode;
}
public void setCustomerzipcode(int customerzipcode) {
	Customerzipcode = customerzipcode;
}
public double getCustomerPhoneNo() {
	return customerPhoneNo;
}
public void setCustomerPhoneNo(double customerPhoneNo) {
	this.customerPhoneNo = customerPhoneNo;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public LocalDate getCustomerDate() {
	return customerDate;
}
public void setCustomerDate(LocalDate customerDate) {
	this.customerDate = customerDate;
}


}