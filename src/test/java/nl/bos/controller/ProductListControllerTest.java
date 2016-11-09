package nl.bos.controller;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.junit.Assert.*;

import java.util.HashMap;

import nl.bos.ApplicationConfiguration;
import nl.bos.ApplicationIntegrationTest;

import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.response.Response;

public class ProductListControllerTest extends ApplicationIntegrationTest {

	private HashMap<String, Object> stubProductList1 = new HashMap<String, Object>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", 1);
			put("name", "Boodschap");
		}
	};

	private HashMap<String, Object> stubProductList2 = new HashMap<String, Object>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", 2);
			put("name", "Tech");
		}
	};

	private HashMap<String, Object> stubProductList3 = new HashMap<String, Object>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", 3);
			put("name", "Hobby");
		}
	};

	@Test
	public final void testShowAllProductsLists() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testShowProductList() {
		Response getResponse = get(STR_API_PATH + "/productslists/{productListId}", 1);
		Assert.assertEquals(200, getResponse.getStatusCode());

		String getJson = getResponse.asString();

		HashMap<String, Object> getProduct = from(getJson).get();

		for (String key : stubProductList1.keySet()) {
			Assert.assertTrue(getProduct.containsKey(key));
			Assert.assertEquals(getProduct.get(key), stubProductList1.get(key));
		}
	}

	@Test
	public final void testInsertProductList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddProductToProductList() {
		fail("Not yet implemented"); // TODO
	}

}
