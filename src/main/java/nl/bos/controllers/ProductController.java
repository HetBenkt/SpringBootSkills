package nl.bos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;
import nl.bos.models.Product;
import nl.bos.repositories.ProductRepository;
import nl.bos.services.youtube.YouTubeService;
import nl.bos.services.youtube.api.YouTubeVideo;

@RestController
public class ProductController extends ApiController {
	Person person = new Person("John", 33);

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	YouTubeService youTubeService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> showAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public Product showProduct(@PathVariable("productId") long productId) {
		return productRepository.findOne(productId);
	}
	
	@RequestMapping(value = "/products/{productId}/youtube", method = RequestMethod.GET)
	public List<YouTubeVideo> getYouTubeVideos(@PathVariable("productId") long productId) {
		Product product = productRepository.findOne(productId);
		return youTubeService.searchVideos(product.getName());
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
}
