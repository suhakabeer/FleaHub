package com.canddella.service;

import java.util.List;

import com.canddella.dao.PromotionDAOImpl;
import com.canddella.entity.Promotion;


public class PromotionServiceImpl implements PromotionService {
   PromotionDAOImpl promotionDAOImpl = new PromotionDAOImpl();
	@Override
	public void savePromotion(Promotion promotion) {
		promotionDAOImpl.savePromotion(promotion);
		
	}

	@Override
	public Promotion viewPromotion(String promotionId) {
		// TODO Auto-generated method stub
		return promotionDAOImpl.viewPromotion(promotionId);
	}

	@Override
	public Promotion deletePromotion(String promotionId) {
		// TODO Auto-generated method stub
		return promotionDAOImpl.deletePromotion(promotionId);
	}

	@Override
	public List<Promotion> ListAllPromotion() {
		// TODO Auto-generated method stub
		return promotionDAOImpl.ListAllPromotion();
	}

}
