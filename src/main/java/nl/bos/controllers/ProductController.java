package nl.bos.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;
import nl.bos.models.Product;
import nl.bos.repositories.ProductRepository;

@RestController
public class ProductController extends ApiController {
	Person person = new Person("John", 33);

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> showAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public Product showProduct(@PathVariable("productId") long productId) {
		return productRepository.findOne(productId);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST) //TODO Use JSON payload!
	public void insertProduct(@RequestParam("name") String name, @RequestParam("price") BigDecimal price) {
		Product product = new Product(name, price, "", person);
		productRepository.save(product);
	}
}
