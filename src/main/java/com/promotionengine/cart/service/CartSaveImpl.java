package com.promotionengine.cart.service;

import com.promotionengine.cart.CartHolder;
import com.promotionengine.cart.model.Cart;
import com.promotionengine.cart.model.Carts;
import com.promotionengine.cart.repository.CartSave;

public class CartSaveImpl implements  CartSave{

	private CartHolder cartHolder;
	public CartSaveImpl(CartHolder cartHolder) {
		this.cartHolder = cartHolder;
		}

	public void addToCart(Cart cart) throws Exception {
		throw new Exception("Not Yet Implemented");
		
	}

	public void setCart(Carts cart) throws Exception {
		throw new Exception("Not Yet Implemented");		
	}

}
