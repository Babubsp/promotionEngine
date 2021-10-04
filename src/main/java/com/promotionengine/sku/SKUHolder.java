package com.promotionengine.sku;

import org.apache.log4j.Logger;

import com.promotionengine.cart.model.Carts;

public class SKUHolder {

	static Logger log = Logger.getLogger(SKUHolder.class.getName());

	private static SKUHolder skuHolder;
	static Carts carts;

	private SKUHolder() {

	}

	public static SKUHolder getInstance() {
		try {
			if (skuHolder != null) {
				return skuHolder;
			} else {
				synchronized (skuHolder) {
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
