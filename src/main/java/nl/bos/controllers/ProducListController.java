package nl.bos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<ProductList> showAllProductsLists(@RequestParam("showEmptyValues") boolean showEmptyValues) {
		List<ProductList> result = null;
		if(showEmptyValues)
			result = (List<ProductList>) productListRepository.findByName("Tech");
		else
			result = (List<ProductList>) productListRepository.findAll();
		return result;
	}

	@RequestMapping(value = "/showProductsLists/{productListId}", method = RequestMethod.GET)
	public ProductList showProductList(@PathVariable("productListId") long productListId) {
		return productListRepository.findOne(productListId);
	}
}
