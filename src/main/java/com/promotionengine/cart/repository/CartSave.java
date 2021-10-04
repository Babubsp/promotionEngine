package com.promotionengine.cart.repository;

import com.promotionengine.cart.model.Cart;
import com.promotionengine.cart.model.Carts;

public interface CartSave {

	public void addToCart(Cart cart) throws Exception;
	public void setCart(Carts cart) throws Exception;
}
