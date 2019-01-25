package com.redhat.coolstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.redhat.coolstore.model.Product;
import com.redhat.coolstore.service.MongoCatalogService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "CATALOG_ENDPOINT=localhost", classes = TestConfiguration.class)
@ActiveProfiles("test")
public class CatalogServiceTest {

	@Autowired
	MongoCatalogService mCatalogService;

	@Test
	public void testGetProducts() {
		// mCatalogService.setMongoClient(mMongoClient);
		List<Product> aProducts = mCatalogService.getProducts();
		assertNotNull(aProducts);
		assertTrue(aProducts.size() > 0);
		System.out.println(aProducts);

	}
	
	@Test
	public void testAddProduct() {
		// mCatalogService.setMongoClient(mMongoClient);
		List<Product> aProducts = mCatalogService.getProducts();
		assertNotNull(aProducts);
		Integer aInitialProductCount = aProducts.size();
		mCatalogService.add(new Product("777777", "Red Fedora Demo ", "Official Red Hat Online", 77.77));
		Integer aFinalProdCount = mCatalogService.getProducts().size();
		assertTrue(aFinalProdCount == (aInitialProductCount + 1));
		System.out.println(aProducts);

	}

}