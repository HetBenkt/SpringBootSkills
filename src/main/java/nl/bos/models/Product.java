package nl.bos.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private final long id;
	
	@Column(nullable=false)
	@NotNull
	@Size(min=1, max=32, message="Out of range")
	private final String name;
	
	@Column(nullable=true)
	private final String url;
	
	@Column(nullable=false)
	@NotNull
	@DecimalMin(value="0")
	private final BigDecimal price;

	@ManyToMany(mappedBy="products")
	@JsonBackReference
	private List<ProductList> lists;
	
	public String getUrl() {
		return url;
	}

	public Product() {
		url = "";
		price = new BigDecimal(0);
		name = "";
		id = 0;
	}
	
	public Product(String name, BigDecimal price, String url, Person person) {
		this.id = -1;
		this.name = name;
		this.price = price;
		this.url = url;
	}

	public Product(long id, String name, BigDecimal price, String url, Person person) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
