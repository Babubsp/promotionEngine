package com.promotionengine.sku.model;

public class SKU {

	private String skuId;
	private Long skuAmount;
	
	public SKU(String skuId,Long skuAmount) {
		this.skuId = skuId;
		this.skuAmount = skuAmount;
	}
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public Long getSkuAmount() {
		return skuAmount;
	}
	public void setSkuAmount(Long skuAmount) {
		this.skuAmount = skuAmount;
	}
	
}
