package com.canddella.entity;

public class Sponsorship {
	
	private String sponsorshipId;
	private Event event;
	private String sponsorName;
	private double sponsorshipAmount;
	public Sponsorship(String sponsorshipId, Event event, String sponsorName, double sponsorshipAmount) {
		super();
		this.sponsorshipId = sponsorshipId;
		this.event = event;
		this.sponsorName = sponsorName;
		this.sponsorshipAmount = sponsorshipAmount;
	}
	public String getSponsorshipId() {
		return sponsorshipId;
	}
	public void setSponsorshipId(String sponsorshipId) {
		this.sponsorshipId = sponsorshipId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public double getSponsorshipAmount() {
		return sponsorshipAmount;
	}
	public void setSponsorshipAmount(double sponsorshipAmount) {
		this.sponsorshipAmount = sponsorshipAmount;
	}
	
}
