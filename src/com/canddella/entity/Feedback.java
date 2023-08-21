package com.canddella.entity;

import java.time.LocalDate;

public class Feedback {

	private String feedbackId;
	private Customer customer;
	private Event event;
	private double rating;
	private String comment;
	private LocalDate reviewDate;
	public Feedback(String feedbackId, Customer customer, Event event, double rating, String comment,
			LocalDate reviewDate) {
		super();
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.event = event;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	}
