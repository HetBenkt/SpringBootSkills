package nl.bos.controller;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;

import java.util.ArrayList;
import java.util.HashMap;

import nl.bos.ApplicationIntegrationTest;

import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class ProductControllerTest extends ApplicationIntegrationTest {

	private HashMap<String, Object> stubProduct1 = new HashMap<String, Object>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", 1);
			put("name", "Macbook Air");
			put("price", 999.95F);
		}
	};

	private HashMap<String, Object> stubProduct2 = new HashMap<String, Object>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", 2);
			put("name", "Magic Mouse");
			put("price", 69.95F);
		}
	};

	private HashMap<String, Object> stubProduct3 = new HashMap<String, Object>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("id", 3);
			put("name", "Sunglasses");
			put("price", 14.99F);
		}
	};

	@Test
	public final void testShowAllProducts() {
		Response getResponse = get(STR_API_PATH + "/products");
		Assert.assertEquals(200, getResponse.getStatusCode());

		String getJson = getResponse.asString();

		ArrayList<HashMap<String, Object>> products = from(getJson).get();

		HashMap<String, Object> product1 = (HashMap<String, Object>) products
				.get(0);
		for (String key : stubProduct1.keySet()) {
			Assert.assertTrue(product1.containsKey(key));
			Assert.assertEquals(product1.get(key), stubProduct1.get(key));
		}

		HashMap<String, Object> product2 = (HashMap<String, Object>) products
				.get(1);
		for (String key : stubProduct2.keySet()) {
			Assert.assertTrue(product2.containsKey(key));
			Assert.assertEquals(product2.get(key), stubProduct2.get(key));
		}
	}

	@Test
	public final void testShowProduct() {
		Response getResponse = get(STR_API_PATH + "/products/{productId}", 1);
		Assert.assertEquals(200, getResponse.getStatusCode());

		String getJson = getResponse.asString();

		HashMap<String, Object> getProduct = from(getJson).get();

		for (String key : stubProduct1.keySet()) {
			Assert.assertTrue(getProduct.containsKey(key));
			Assert.assertEquals(getProduct.get(key), stubProduct1.get(key));
		}
	}

	@Test
	public final void testInsertProduct() {
		Response postResponse = given().contentType(ContentType.JSON)
				.body("{\"name\": \"Sunglasses\", \"price\": 14.99}")
				.post(STR_API_PATH + "/products");
		Assert.assertEquals(200, postResponse.getStatusCode());

		String postJson = postResponse.asString();
		HashMap<String, Object> postProduct = from(postJson).get();

		Response getResponse = get(STR_API_PATH + "/products/{productId}",
				postProduct.get("id"));
		Assert.assertEquals(200, getResponse.getStatusCode());

		String getJson = getResponse.asString();

		HashMap<String, Object> getProduct = from(getJson).get();

		for (String key : stubProduct3.keySet()) {
			Assert.assertTrue(getProduct.containsKey(key));
			Assert.assertEquals(getProduct.get(key), stubProduct3.get(key));
		}
	}
}
