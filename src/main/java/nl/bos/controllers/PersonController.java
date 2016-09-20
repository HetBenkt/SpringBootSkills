package nl.bos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;
import nl.bos.repositories.PersonRepository;

@RestController
public class PersonController extends ApiController {
	@Autowired
	PersonRepository personRepository;

	@RequestMapping(value = "/personData", method = RequestMethod.GET)
	public List<Person> personData() {
		return (List<Person>) personRepository.findAll();
	}
}
