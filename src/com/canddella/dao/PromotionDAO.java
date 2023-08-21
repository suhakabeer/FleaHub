package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Promotion;

public interface PromotionDAO {
	public void  savePromotion(Promotion  promotion);
	public  Promotion viewPromotion(String promotionId);
	public  Promotion deletePromotion(String promotionId);
	public List<Promotion> ListAllPromotion();
}
