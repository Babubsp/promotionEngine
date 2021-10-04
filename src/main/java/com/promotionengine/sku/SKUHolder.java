package com.promotionengine.sku;

import java.util.List;

import org.apache.log4j.Logger;

import com.promotionengine.sku.model.SKU;

public class SKUHolder {

	static Logger log = Logger.getLogger(SKUHolder.class.getName());

	private static SKUHolder skuHolder;
	private List<SKU>  skus;

	
	public List<SKU> getSkus() {
		return this.skus;
	}
	
	public void addSkus(SKU sku) {
		this.skus.add(sku);
	}

	public void setSkus(List<SKU> skus) {
		this.skus = skus;
	}

	private SKUHolder() {

	}

	public static SKUHolder getInstance() {
		try {
			if (skuHolder != null) {
				return skuHolder;
			} else {
				synchronized (SKUHolder.class) {
					if (skuHolder != null) {
						return skuHolder;
					} else {
						skuHolder = new SKUHolder();
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return skuHolder;
	}

}
