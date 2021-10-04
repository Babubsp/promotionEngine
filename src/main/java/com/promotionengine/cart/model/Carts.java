package com.promotionengine.cart.model;

import java.util.ArrayList;
import java.util.List;

import com.promotionengine.promotion.PromotionHolder;

public class Carts {

	private PromotionHolder promotionHolder;

	public Carts(PromotionHolder promotionHolder) {
		this.promotionHolder=promotionHolder;
	}
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
	
	public Long applyPromotion() throws Exception {
		throw new Exception("Promotion calculation Implementation not done ");
	}
	
}
