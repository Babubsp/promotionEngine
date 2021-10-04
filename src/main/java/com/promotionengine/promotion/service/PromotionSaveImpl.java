package com.promotionengine.promotion.service;

import com.promotionengine.promotion.PromotionHolder;
import com.promotionengine.promotion.model.Promotion;
import com.promotionengine.promotion.model.Promotions;
import com.promotionengine.promotion.repository.PromotionSave;

public class PromotionSaveImpl implements PromotionSave{


	private PromotionHolder promotionHolder;
	public PromotionSaveImpl(PromotionHolder promotionHolder) {
		this.promotionHolder = promotionHolder;
	}

	public void addPromotion(Promotion promotion) throws Exception {
		promotionHolder.getPromotions().addPromotions(promotion);
		
	}

	public void setPromotion(Promotions promotions) throws Exception {
		promotionHolder.setPromotions(promotions);		
		
	}

}
