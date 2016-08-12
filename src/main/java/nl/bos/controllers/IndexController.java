package nl.bos.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

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
}
