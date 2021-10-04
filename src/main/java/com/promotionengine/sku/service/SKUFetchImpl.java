package com.promotionengine.sku.service;

import java.util.List;

import com.promotionengine.sku.SKUHolder;
import com.promotionengine.sku.model.SKU;
import com.promotionengine.sku.repository.SKUFetch;

public class SKUFetchImpl  implements SKUFetch{
	private SKUHolder skuHolder;
	
	public SKUFetchImpl(SKUHolder skuHolder) {
		this.skuHolder = skuHolder;
	}

	@Override
	public List<SKU> listSKU() throws Exception {
		return skuHolder.getSkus();
	}


}
