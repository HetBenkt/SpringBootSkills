package nl.bos;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public abstract class ApplicationIntegrationTest {
	@Value("${local.server.port}")
	private int port;
	public final static String STR_API_PATH = "/api";

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
	}
}
