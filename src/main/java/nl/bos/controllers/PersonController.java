package nl.bos.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;

@RestController
public class PersonController extends ApiController {
	@RequestMapping(value = "/personData", method = RequestMethod.GET)
	public Person personData() {
		Person person = new Person("John", 33);
		Map<String, String> keywords = new HashMap<String, String>();
		keywords.put("1", "Music");
		keywords.put("2", "Motors");
		keywords.put("3", "Kids");
		person.setKeywords(keywords);
		return person;
	}
}
