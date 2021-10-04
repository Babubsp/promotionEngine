package com.promotionengine.cart;

import org.apache.log4j.Logger;

import com.promotionengine.cart.model.Carts;
import com.promotionengine.promotion.PromotionHolder;

public class CartHolder{

	static Logger log = Logger.getLogger(CartHolder.class.getName());
	private static CartHolder cartHolder;
	private Carts carts;
	
	private CartHolder() {

	}

	public static CartHolder getInstance(PromotionHolder promotionHolder) {
		try {
			if (cartHolder != null) {
				return cartHolder;
			} else {
				synchronized(CartHolder.class){
					if (cartHolder != null) {
						return cartHolder;
					} else {
						cartHolder = new CartHolder();
						cartHolder.carts = new Carts(promotionHolder);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return cartHolder;
	}

	public Carts getCarts() {
		return this.carts;
	}
	
	public void setCarts(Carts carts) {
		this.carts = carts;
	}
	
}
