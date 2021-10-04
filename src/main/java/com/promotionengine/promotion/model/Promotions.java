package com.promotionengine.promotion.model;

import java.util.ArrayList;
import java.util.List;

public class Promotions {

	private List<Promotion> promotions;

	@Override
	public String toString() {
		return "Promotions [promotions=" + promotions + "]";
	}

	public List<Promotion> getPromotions() {
		if(promotions==null) {
			promotions = new ArrayList<>();
		}
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	
	public void addPromotions(Promotion promotion) {
		if(this.promotions==null) {
			this.promotions = new ArrayList<Promotion>();			
		}
		this.promotions.add(promotion);
	}
}
