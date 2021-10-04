package com.promotionengine.cart.model;

public class Cart {
	private String sku;
	private long value;

	@Override
	public String toString() {
		return "Cart [sku=" + sku + ", value=" + value + "]";
	}

	public Cart(String sku,long value) {
		this.sku =sku;
		this.value =value;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	
	
}
