package com.promotionengine.test.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.promotionengine.cart.CartHolder;
import com.promotionengine.cart.model.Cart;
import com.promotionengine.cart.model.Carts;
import com.promotionengine.cart.repository.CartFetch;
import com.promotionengine.cart.service.CartFetchImpl;
import com.promotionengine.cart.service.CartSaveImpl;
import com.promotionengine.promotion.PromotionHolder;
import com.promotionengine.promotion.model.Promotion.PromotionBuilder;
import com.promotionengine.promotion.repository.PromotionFetch;
import com.promotionengine.promotion.repository.PromotionSave;
import com.promotionengine.promotion.service.PromotionFetchImpl;
import com.promotionengine.promotion.service.PromotionSaveImpl;
import com.promotionengine.sku.SKUHolder;
import com.promotionengine.sku.model.SKU;
import com.promotionengine.sku.repository.SKUFetch;
import com.promotionengine.sku.repository.SKUSave;
import com.promotionengine.sku.service.SKUFetchImpl;
import com.promotionengine.sku.service.SKUSaveImpl;

class CartTest {

	private Carts carts;
	private PromotionHolder promotionHolder;
	private SKUHolder skuHolder;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		promotionHolder = PromotionHolder.getInstance();
		PromotionSave promotionSave = new PromotionSaveImpl(promotionHolder);
		promotionSave.addPromotion(new PromotionBuilder()
				.addSKU("A", 3)
				.totalAmountFixedValue(130l)
				.build());
		promotionSave.addPromotion(new PromotionBuilder()
				.addSKU("B", 2)
				.totalAmountFixedValue(45l)
				.build());
		promotionSave.addPromotion(new PromotionBuilder()
				.addSKU("C")
				.addSKU("D")
				.totalAmountFixedValue(30l)
				.build());
		skuHolder = SKUHolder.getInstance();
		SKUSave skuSave = new SKUSaveImpl(skuHolder);
		skuSave.addSKU(new SKU("A", 50l));
		skuSave.addSKU(new SKU("B", 30l));
		skuSave.addSKU(new SKU("C", 20l));
		skuSave.addSKU(new SKU("D", 15l));
		carts = new Carts(promotionHolder,skuHolder);
		carts.addCart(new Cart("A",1));
		carts.addCart(new Cart("B",1));
		carts.addCart(new Cart("C",1));
		//carts.addCart(new Cart("D",1));
	}

	@AfterEach
	void tearDown() throws Exception {
		promotionHolder.setPromotions(null);
		skuHolder.setSkus(null);
	}

	@Test
	void cartFetchTest() throws Exception {
		CartHolder cartHolder = CartHolder.getInstance(promotionHolder,skuHolder);
		cartHolder.setCarts(carts);
		CartFetchImpl cartFetchImpl = new CartFetchImpl(cartHolder);
		Carts actual = cartFetchImpl.listCart();
		assertNotNull(actual);
		assertEquals(carts.getCarts().size(), actual.getCarts().size());
	}

	
	@Test
	void cartFetchAndTestTest() throws Exception {
		CartHolder cartHolder = CartHolder.getInstance(promotionHolder,skuHolder);
		cartHolder.setCarts(carts);
		CartSaveImpl cartSaveImpl = new CartSaveImpl(cartHolder);
		cartSaveImpl.addToCart(new Cart("A",2));
		CartFetchImpl cartFetchImpl = new CartFetchImpl(cartHolder);
		Carts actual = cartFetchImpl.listCart();
		assertEquals(carts.getCarts().size(), actual.getCarts().size());
	}
	
	@Test
	void cartPromotionTest() throws Exception {
		CartHolder cartHolder = CartHolder.getInstance(promotionHolder,skuHolder);
		
		
		
		
		Carts carts = new Carts(promotionHolder,skuHolder);
		carts.addCart(new Cart("A",1));
		carts.addCart(new Cart("B",1));
		carts.addCart(new Cart("C",1));
		cartHolder.setCarts(carts);
		
		CartSaveImpl cartSaveImpl = new CartSaveImpl(cartHolder);
		cartSaveImpl.addToCart(new Cart("A",2));
		
		
		SKUFetch skuFetch = new SKUFetchImpl(skuHolder);
		PromotionFetch promotionFetch = new PromotionFetchImpl(promotionHolder);
		CartFetch cartFetch = new CartFetchImpl(cartHolder);
		assertEquals(4,skuFetch.listSKU().size());
		assertEquals(3,promotionFetch.listPromotion().getPromotions().size());
		assertEquals(4,cartFetch.listCart().getCarts().size());
		
	}
	
	
	@Test
	public void testApplyPromotion() throws Exception {
		System.out.println(carts.applyPromotion());
	}
	
	

}
