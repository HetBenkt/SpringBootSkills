package nl.bos;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import nl.bos.controllers.IndexController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringBootSkillsApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/api/hello").accept(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string(equalTo("Hello server side")));
	}

}
