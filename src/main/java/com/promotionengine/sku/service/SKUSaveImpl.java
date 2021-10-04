package com.promotionengine.sku.service;

import com.promotionengine.sku.SKUHolder;
import com.promotionengine.sku.model.SKU;
import com.promotionengine.sku.repository.SKUSave;

public class SKUSaveImpl implements SKUSave{


	private SKUHolder skuHolder;
	public SKUSaveImpl(SKUHolder skuHolder) {
		this.skuHolder = skuHolder;
	}
	@Override
	public void addSKU(SKU sku) throws Exception {
		skuHolder.addSkus(sku);
	}

}
