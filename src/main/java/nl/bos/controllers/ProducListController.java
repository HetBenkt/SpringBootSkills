package nl.bos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.controllers.exceptions.ProductListNotFoundException;
import nl.bos.models.Person;
import nl.bos.models.Product;
import nl.bos.models.ProductList;
import nl.bos.repositories.ProductListRepository;
import nl.bos.repositories.ProductRepository;

@RestController
public class ProducListController extends ApiController {
	Person person = new Person("John", 33);

	@Autowired
	ProductListRepository productListRepository;
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value = "/productslists", method = RequestMethod.GET)
	public List<ProductList> showAllProductsLists(@RequestParam("showEmptyValues") boolean showEmptyValues) {
		List<ProductList> result = null;
		if(showEmptyValues)
			result = (List<ProductList>) productListRepository.findByName("Tech");
		else
			result = (List<ProductList>) productListRepository.findAll();
		return result;
	}

	@RequestMapping(value = "/productslists/{productListId}", method = RequestMethod.GET)
	public ProductList showProductList(@PathVariable("productListId") long productListId) {
		return productListRepository.findOne(productListId);
	}
	
	@RequestMapping(value = "/productslists", method = RequestMethod.POST)
	public void insertProductList(@RequestBody ProductList productList) {
		productListRepository.save(productList);
	}
	
	@RequestMapping(value = "/productslists/{productListId}/addproduct", method = RequestMethod.POST) 
	public void addProductToProductList(@PathVariable("productListId") long productListId, @RequestParam("productId") long productId) {
		ProductList productList = productListRepository.findOne(productListId);
		Product product = productRepository.findOne(productId);
		
		if(productList != null) { 
			productList.getProducts().add(product);
			productListRepository.save(productList);
		} else
			throw new ProductListNotFoundException();
	}
}
