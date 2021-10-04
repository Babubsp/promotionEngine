package com.promotionengine.cart.service;

import com.promotionengine.cart.CartHolder;
import com.promotionengine.cart.model.Carts;
import com.promotionengine.cart.repository.CartFetch;

public class CartFetchImpl implements CartFetch {

	private CartHolder cartHolder;
	public CartFetchImpl(CartHolder cartHolder) {
		this.cartHolder = cartHolder;
	}

	public Carts listCart() throws Exception {
		throw new Exception("Not Yet Implemented");
		
	}

}
