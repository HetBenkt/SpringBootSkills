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
import nl.bos.models.ProductList;

@RestController
public class ProducListController extends ApiController {
	Person person = new Person("John", 33);
	
	@RequestMapping(value = "/showAllProductsLists", method = RequestMethod.GET)
	public List<ProductList> showAllProductsLists() {
		List<ProductList> productsLists = new ArrayList<>();

		ProductList productList = new ProductList(1, "Tablets");

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Apple MacBook Air", new BigDecimal("999.99"), "http://www.apple.com", person));
		products.add(new Product(2, "MS Surface", new BigDecimal("795.00"), "http://www.microsoft.com", person));
		products.add(new Product(3, "Chromebook Pixel", new BigDecimal("449.95"), "http://www.google.com", person));
		
		productList.setProducts(products);

		productsLists.add(productList);

		return productsLists;
	}

	@RequestMapping(value = "/showProductsLists/{productListId}", method = RequestMethod.GET)
	public ProductList showProductList(@PathVariable("productListId") long productListId) {
		ProductList productList = new ProductList(productListId, "Tablets");

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Apple MacBook Air", new BigDecimal("999.99"), "http://www.apple.com", person));
		products.add(new Product(2, "MS Surface", new BigDecimal("795.00"), "http://www.microsoft.com", person));
		products.add(new Product(3, "Chromebook Pixel", new BigDecimal("449.95"), "http://www.google.com", person));
		productList.setProducts(products);

		return productList;
	}
}
