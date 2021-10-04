package com.promotionengine.sku.repository;

import java.util.List;

import com.promotionengine.sku.model.SKU;

public interface SKUFetch {


	public List<SKU> listSKU() throws Exception;
}
