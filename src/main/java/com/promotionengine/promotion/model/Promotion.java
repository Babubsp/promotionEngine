package com.promotionengine.promotion.model;

import java.util.HashMap;
import java.util.Map;

public class Promotion {

	private Map<String, Integer> map = new HashMap<>();
	private Long total = 0l;
	private Boolean isTotalFixedValue = false;

	public Map<String, Integer> getMap() {
		return map;
	}

	public Long getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Promotion [map=" + map + ", total=" + total + ", isTotalFixedValue=" + isTotalFixedValue
				+ ", isTotalDiscountedValue=" + isTotalDiscountedValue + "]";
	}

	public Boolean getIsTotalFixedValue() {
		return isTotalFixedValue;
	}

	public Boolean getIsTotalDiscountedValue() {
		return isTotalDiscountedValue;
	}

	private Boolean isTotalDiscountedValue = false;

	private Promotion(Map<String, Integer> map, Long total, Boolean isTotalDiscountedValue, Boolean isTotalFixedValue) {
		this.map = map;
		this.total = total;
		this.isTotalFixedValue = isTotalFixedValue;
		this.isTotalDiscountedValue = isTotalDiscountedValue;
	}

	public static class PromotionBuilder {
		private Map<String, Integer> map = new HashMap<>();
		Long total = 0l;
		Boolean isTotalFixedValue = false;
		Boolean isTotalDiscountedValue = false;

		public PromotionBuilder addSKU(String skuId) throws Exception {
			if (this.map.get(skuId) != null) {
				throw new Exception("Already the skuid is used for this promotion");
			} else {
				this.map.put(skuId, 1);
			}
			return this;

		}

		public PromotionBuilder addSKU(String skuId, int count) throws Exception {
			if (this.map.get(skuId) != null) {
				throw new Exception("Already the skuid is used for this promotion");
			} else {
				this.map.put(skuId, count);
			}
			return this;
		}

		public PromotionBuilder totalAmountFixedValue(Long value) throws Exception {
			if (this.isTotalFixedValue || this.isTotalDiscountedValue) {
				throw new Exception("Already Total Defined");
			} else {
				this.isTotalFixedValue = true;
				this.isTotalDiscountedValue = false;
				this.total = value;

			}
			return this;
		}

		public PromotionBuilder totalAmountPercentage(Long value) throws Exception {
			if (this.isTotalFixedValue || this.isTotalDiscountedValue) {
				throw new Exception("Already Total Defined");
			} else {
				this.isTotalFixedValue = false;
				this.isTotalDiscountedValue = true;
				this.total = value;

			}
			return this;
		}

		public Promotion build() throws Exception {

			if(!isTotalDiscountedValue && !isTotalFixedValue) {
				throw new Exception("Invalid Data Total is not set");
			}
			if(map.isEmpty()) {
				throw new Exception("Promotion is empty");
			}
			return new Promotion(this.map, total, isTotalDiscountedValue, isTotalFixedValue);
		}
	}

}
