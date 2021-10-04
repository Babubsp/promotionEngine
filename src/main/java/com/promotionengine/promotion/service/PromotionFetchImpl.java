package com.promotionengine.promotion.service;

import com.promotionengine.cart.CartHolder;
import com.promotionengine.promotion.PromotionHolder;
import com.promotionengine.promotion.model.Promotions;
import com.promotionengine.promotion.repository.PromotionFetch;

public class PromotionFetchImpl  implements PromotionFetch{
	private PromotionHolder promotionHolder;
	
	public PromotionFetchImpl(PromotionHolder promotionHolder) {
		this.promotionHolder = promotionHolder;
	}

	public Promotions listPromotion() throws Exception {
		return promotionHolder.getPromotions();
	}

}
