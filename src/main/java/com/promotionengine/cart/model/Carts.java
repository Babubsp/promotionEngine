package com.promotionengine.cart.model;

import java.util.ArrayList;
import java.util.List;

public class Carts {

	private List<Cart> carts;

	public List<Cart> getCarts() {
		return carts;
	}

	public void addCart(Cart cart) {
		if(carts==null) {
			this.carts = new ArrayList<Cart>();	
		}
		this.carts.add(cart);
	}
	
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	@Override
	public String toString() {
		return "Carts [carts=" + carts + "]";
	}
	
}
