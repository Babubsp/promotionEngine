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
import com.promotionengine.cart.service.CartFetchImpl;
import com.promotionengine.cart.service.CartSaveImpl;

class CartTest {

	private Carts carts = new Carts();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		carts = new Carts();
		carts.addCart(new Cart("A",2));
		carts.addCart(new Cart("B",2));
		carts.addCart(new Cart("C",2));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void cartFetchTest() throws Exception {
		CartHolder cartHolder = CartHolder.getInstance();
		cartHolder.setCarts(carts);
		CartFetchImpl cartFetchImpl = new CartFetchImpl(cartHolder);
		Carts actual = cartFetchImpl.listCart();
		assertNotNull(actual);
		assertEquals(carts.getCarts().size(), actual.getCarts().size());
	}

	
	@Test
	void cartFetchAndTestTest() throws Exception {
		CartHolder cartHolder = CartHolder.getInstance();
		cartHolder.setCarts(carts);
		CartSaveImpl cartSaveImpl = new CartSaveImpl(cartHolder);
		cartSaveImpl.addToCart(new Cart("A",2));
		CartFetchImpl cartFetchImpl = new CartFetchImpl(cartHolder);
		Carts actual = cartFetchImpl.listCart();
		assertEquals(carts.getCarts().size(), actual.getCarts().size());
	}

}
