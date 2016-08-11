package nl.bos.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import nl.bos.pojo.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController extends ApiController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello server side";
	}

	@RequestMapping(value = "/currentDate", method = RequestMethod.GET)
	public String currentDate() {
		LocalDateTime now = LocalDateTime.now();
		LocalDate date = now.toLocalDate();
		return date.toString();
	}

	@RequestMapping(value = "/randomNumber", method = RequestMethod.GET)
	public String randomNumber() {
		Random random = new Random();
		return "" + random.ints(1, 1, 10).toArray()[0];
	}
	
	@RequestMapping(value = "/personData", method = RequestMethod.GET)
	public Person personData() {
		Person person = new Person();
		person.setAge(33);
		person.setName("John");
		Map<String, String> keywords = new HashMap<String, String>();
		keywords.put("1", "Music");
		keywords.put("2", "Motors");
		keywords.put("3", "Kids");
		person.setKeywords(keywords);
		return person;
	}

}
