package com.canddella.entity;

import java.time.LocalDate;

public class Promotion {
	
	private String promotionId;
	private Event event;
	private String promotionName;
	private LocalDate promotionStratDate;
	private LocalDate promotionEndDate;
	private String discount;
	private String specialOffer;
	public Promotion(String promotionId, Event event, String promotionName, LocalDate promotionStratDate,
			LocalDate promotionEndDate, String discount, String specialOffer) {
		super();
		this.promotionId = promotionId;
		this.event = event;
		this.promotionName = promotionName;
		this.promotionStratDate = promotionStratDate;
		this.promotionEndDate = promotionEndDate;
		this.discount = discount;
		this.specialOffer = specialOffer;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public LocalDate getPromotionStratDate() {
		return promotionStratDate;
	}
	public void setPromotionStratDate(LocalDate promotionStratDate) {
		this.promotionStratDate = promotionStratDate;
	}
	public LocalDate getPromotionEndDate() {
		return promotionEndDate;
	}
	public void setPromotionEndDate(LocalDate promotionEndDate) {
		this.promotionEndDate = promotionEndDate;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getSpecialOffer() {
		return specialOffer;
	}
	public void setSpecialOffer(String specialOffer) {
		this.specialOffer = specialOffer;
	}
	
	
}
	

