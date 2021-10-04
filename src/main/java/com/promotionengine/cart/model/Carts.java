package com.promotionengine.cart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import com.promotionengine.promotion.PromotionHolder;
import com.promotionengine.promotion.model.Promotion;
import com.promotionengine.sku.SKUHolder;

public class Carts {

	private PromotionHolder promotionHolder;
	private SKUHolder skuHolder;

	public Carts(PromotionHolder promotionHolder, SKUHolder skuHolder) {
		this.promotionHolder = promotionHolder;
		this.skuHolder = skuHolder;
	}

	private List<Cart> carts;

	public List<Cart> getCarts() {
		return carts;
	}

	public void addCart(Cart cart) {
		if (carts == null) {
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
		Map<String, Promotion> promotionPatter = new HashMap<String, Promotion>();
		List<Promotion> tempPromotion = new ArrayList<Promotion>();
		tempPromotion.addAll(promotionHolder.getPromotions().getPromotions());
		AtomicReference<Long> sum = new AtomicReference<>(0l);
		HashMap<String, Long> carts = new HashMap<>();
		HashMap<String, Long> skus = new HashMap<>();
		this.carts.stream().forEach(cart -> {
			carts.put(cart.getSku(), cart.getValue());
		});
		this.skuHolder.getSkus().parallelStream().forEach(sku -> {
			skus.put(sku.getSkuId(), sku.getSkuAmount());
		});
		promotionHolder.getPromotions().getPromotions().parallelStream().forEach(action -> {
			StringBuffer strr = new StringBuffer("");
			action.getMap().keySet().stream().forEach(cart -> {
				strr.append(action.getMap().get(cart) + cart);
			});
			promotionPatter.put(strr.toString(), action);
		});

		promotionPatter.keySet().stream().forEach(action -> {

			if (action.length() == 2) {

				if (carts.get(action.charAt(1) + "") != null) {
					long minimumCount = Long.parseLong(action.charAt(0) + "");
					if (carts.get(action.charAt(1) + "") / minimumCount != 0) {
						sum.set(sum.get() + (carts.get(action.charAt(1) + "") / minimumCount)
								* promotionPatter.get(action).getTotal());
						sum.set(sum.get()
								+ (carts.get(action.charAt(1) + "") % minimumCount) * skus.get(action.charAt(1) + ""));
						carts.remove(action.charAt(1) + "");
					}

					tempPromotion.remove(promotionPatter.get(action));
				}
			} else if (action.length() == 4) {
				String firstChar = action.charAt(1) + "";
				String secondChar = action.charAt(3) + "";
				Long firstCharCount = carts.get(action.charAt(1) + "");
				Long secondCharCount = carts.get(action.charAt(3) + "");
				System.out.println(firstChar);
				System.out.println(secondChar);
				System.out.println(firstCharCount);
				System.out.println(secondCharCount);
				if (firstCharCount!=null && secondCharCount!=null) {
					if((firstCharCount+"").equals(action.charAt(0) + "") && 
							(secondCharCount+"").equals(action.charAt(2) + "") ) {
						sum.set(sum.get() + promotionPatter.get(action).getTotal());
						carts.remove(firstChar);
						carts.remove(secondChar);
					}
				}
			}

		});

		carts.keySet().forEach(action -> {
			sum.set(sum.get() + skus.get(action));
		});
		System.out.println(carts.toString());
		System.out.println(promotionPatter);

		return sum.get();
	}

}
