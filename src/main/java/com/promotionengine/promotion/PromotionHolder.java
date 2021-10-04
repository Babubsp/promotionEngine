package com.promotionengine.promotion;

import org.apache.log4j.Logger;

import com.promotionengine.cart.model.Carts;
import com.promotionengine.promotion.model.Promotions;

public class PromotionHolder {

	static Logger log = Logger.getLogger(PromotionHolder.class.getName());
	
	private static PromotionHolder promotionHolder;

	Promotions promotions;

	private PromotionHolder() {

	}

	public static PromotionHolder getInstance() {
		try {
			if (promotionHolder != null) {
				return promotionHolder;
			} else {
				synchronized (PromotionHolder.class) {
					if (promotionHolder != null) {
						return promotionHolder;
					} else {
						promotionHolder = new PromotionHolder();
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return promotionHolder;
	}

	public Promotions getPromotions() {
		if(promotions==null) {
			promotions = new Promotions();
		}
		return promotions;
	}

	public void setPromotions(Promotions promotions) {
		this.promotions = promotions;
	}

}
