package com.promotionengine.promotion.repository;

import com.promotionengine.promotion.model.Promotion;
import com.promotionengine.promotion.model.Promotions;

public interface PromotionSave {

	public void addPromotion(Promotion promotion) throws Exception;
	
	public void setPromotion(Promotions promotions) throws Exception;
	
}
