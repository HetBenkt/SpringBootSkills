package nl.bos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;
import nl.bos.repositories.PersonRepository;
import nl.bos.services.npo.NPOService;
import nl.bos.services.npo.api.NPOHits;
import nl.bos.services.sw.SWService;
import nl.bos.services.sw.api.SWResult;

@RestController
public class PersonController extends ApiController {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	NPOService npoService;
	
	@Autowired
	SWService swService;
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public List<Person> showPersons() {
		return (List<Person>) personRepository.findAll();
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public Person insertPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@RequestMapping(value = "/persons/{personId}/npo", method = RequestMethod.GET)
	public NPOHits getNPOItems(@PathVariable("personId") long personId) {
		Person person = personRepository.findOne(personId);
		return npoService.searchItems(person.getName());
	}
	
	@RequestMapping(value = "/persons/{personId}/sw", method = RequestMethod.GET)
	public List<SWResult> getSSWItems(@PathVariable("personId") long personId) {
		return swService.searchItems(personId);
	}
}
