package com.promotionengine.promotion;

import org.apache.log4j.Logger;

import com.promotionengine.cart.model.Carts;

public class PromotionHolder {

	static Logger log = Logger.getLogger(PromotionHolder.class.getName());
	private static PromotionHolder promotionHolder;
	static Carts carts;

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

}
