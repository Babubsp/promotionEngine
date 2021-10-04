package com.promotionengine.test.promotion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.promotionengine.cart.model.Cart;
import com.promotionengine.cart.model.Carts;
import com.promotionengine.promotion.PromotionHolder;
import com.promotionengine.promotion.model.Promotion;
import com.promotionengine.promotion.model.Promotions;
import com.promotionengine.promotion.model.Promotion.PromotionBuilder;
import com.promotionengine.promotion.repository.PromotionFetch;
import com.promotionengine.promotion.repository.PromotionSave;
import com.promotionengine.promotion.service.PromotionFetchImpl;
import com.promotionengine.promotion.service.PromotionSaveImpl;

class PromotionTest {

	static Promotions promotions = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		promotions = new Promotions();
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void promotionFetchTest() throws Exception {
		PromotionHolder promotionHolder = PromotionHolder.getInstance();
		promotionHolder.setPromotions(promotions);
		PromotionFetch promotionFetch = new PromotionFetchImpl(promotionHolder);
		Promotions actual = promotionFetch.listPromotion();
		System.out.println(actual);
		System.out.println(promotions.getPromotions().size());
		assertEquals(promotions.getPromotions().size(), actual.getPromotions().size());
	}

	
	@Test
	void promotionFetchAndTestTest() throws Exception {
		PromotionHolder cartHolder = PromotionHolder.getInstance();
		cartHolder.setPromotions(promotions);
		PromotionSave promotionSave = new PromotionSaveImpl(cartHolder);
		Promotion promotion = new PromotionBuilder()
				.addSKU("A")
				.totalAmountFixedValue(10l)
				.build();
		
		promotionSave.addPromotion(promotion);
		PromotionFetch promotionFetch = new PromotionFetchImpl(cartHolder);
		Promotions actual = promotionFetch.listPromotion();
		System.out.println(actual);
		System.out.println(promotions.getPromotions().size());
		
		assertEquals(promotions.getPromotions().size(), actual.getPromotions().size());
		
	}

}
