package com.canddella.service;

import java.util.List;

import com.canddella.entity.Promotion;

public interface PromotionService {
	public void  savePromotion(Promotion  promotion);
	public  Promotion viewPromotion(String promotionId);
	public  Promotion deletePromotion(String promotionId);
	public List<Promotion> ListAllPromotion();
}
