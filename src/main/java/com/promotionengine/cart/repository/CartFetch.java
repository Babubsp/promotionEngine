package com.promotionengine.cart.repository;

import com.promotionengine.cart.model.Carts;

public interface CartFetch {

	public Carts listCart() throws Exception;
}
