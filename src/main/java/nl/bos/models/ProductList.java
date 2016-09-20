package nl.bos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProductList {
	@Id
	@GeneratedValue
	private final long id;
	
	@Column(nullable=false)
	private final String name;
	
	@ManyToMany
	@JsonManagedReference
	private List<Product> products;

	public ProductList() {
		id = 0;
		name = "";
	}
	
	public ProductList(String name) {
		this.id = -1;
		this.name = name;
	}

	public ProductList(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
