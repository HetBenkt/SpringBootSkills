package nl.bos.controller;

import static com.jayway.restassured.RestAssured.get;
import nl.bos.ApplicationIntegrationTest;

import org.junit.Assert;
import org.junit.Test;

public class IndexControllerTest extends ApplicationIntegrationTest {

	@Test
	public final void testHello() {
		String result = get(STR_API_PATH + "/hello").asString();
		Assert.assertEquals("Hello server side", result);
	}
}
