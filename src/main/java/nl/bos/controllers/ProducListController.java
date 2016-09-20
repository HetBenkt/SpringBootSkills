package nl.bos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.bos.models.Person;
import nl.bos.models.ProductList;
import nl.bos.repositories.ProductListRepository;

@RestController
public class ProducListController extends ApiController {
	Person person = new Person("John", 33);

	@Autowired
	ProductListRepository productListRepository;

	@RequestMapping(value = "/showAllProductsLists", method = RequestMethod.GET)
	public List<ProductList> showAllProductsLists() {
		return (List<ProductList>) productListRepository.findAll();
	}

	@RequestMapping(value = "/showProductsLists/{productListId}", method = RequestMethod.GET)
	public ProductList showProductList(@PathVariable("productListId") long productListId) {
		return productListRepository.findOne(productListId);
	}
}
