package nl.bos.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;
import nl.bos.models.Product;

@RestController
public class ProductController extends ApiController {
	Person person = new Person("John", 33);
	
	@RequestMapping(value = "/showAllProducts", method=RequestMethod.GET)
	public List<Product> showAllProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Apple MacBook Air", new BigDecimal("999.99"), "http://www.apple.com", person));
		products.add(new Product(2, "MS Surface", new BigDecimal("795.00"), "http://www.microsoft.com", person));
		products.add(new Product(3, "Chromebook Pixel", new BigDecimal("449.95"), "http://www.google.com", person));
		return products; 
	}
	
	@RequestMapping(value="/showProduct/{productId}", method=RequestMethod.GET)
	public Product showProduct(@PathVariable("productId") long productId) {
		Product product = new Product(productId, "Apple MacBook Air", new BigDecimal("999.99"), "http://www.apple.com", person);
		return product;
	}
}
