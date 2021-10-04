package com.promotionengine.test.sku;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.promotionengine.sku.SKUHolder;
import com.promotionengine.sku.model.SKU;
import com.promotionengine.sku.repository.SKUFetch;
import com.promotionengine.sku.service.SKUFetchImpl;
import com.promotionengine.sku.service.SKUSaveImpl;

class SKUTest {

	static List<SKU> skus = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		skus = new ArrayList<SKU>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void skuFetchTest() throws Exception {
		SKUHolder skuHolder = SKUHolder.getInstance();
		skuHolder.setSkus(skus);
		SKUFetch promotionFetch = new SKUFetchImpl(skuHolder);
		List<SKU> actual = promotionFetch.listSKU();
		System.out.println(actual);
		System.out.println(skus.size());
		assertEquals(skus.size(), actual.size());
	}

	
	@Test
	void skuFetchAndTestTest() throws Exception {
		SKUHolder skuHolder = SKUHolder.getInstance();
		skuHolder.setSkus(skus);
		SKUSaveImpl skuSaveImpl = new SKUSaveImpl(skuHolder);
		skuSaveImpl.addSKU(new SKU("A", 10l));
		skuSaveImpl.addSKU(new SKU("B", 20l));
		skuSaveImpl.addSKU(new SKU("C", 30l));
		SKUFetch promotionFetch = new SKUFetchImpl(skuHolder);
		List<SKU> actual = promotionFetch.listSKU();
		System.out.println(actual);
		System.out.println(skus.size());
		
		assertEquals(skus.size(), actual.size());
		
	}

}
