package com.promotionengine.cart;

import org.apache.log4j.Logger;

import com.promotionengine.cart.model.Carts;

public class CartHolder {

	static Logger log = Logger.getLogger(CartHolder.class.getName());
	private static CartHolder cartHolder;
	static Carts carts;

	private CartHolder() {

	}

	public static CartHolder getInstance() {
		try {
			if (cartHolder != null) {
				return cartHolder;
			} else {
				synchronized (cartHolder) {
					if (cartHolder != null) {
						return cartHolder;
					} else {
						cartHolder = new CartHolder();
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return cartHolder;
	}

}
