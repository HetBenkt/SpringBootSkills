package nl.bos.models;

import java.math.BigDecimal;

public class Product {
	private final long id;
	private final String name;
	private final String url;
	private final Person person;
	
	public String getUrl() {
		return url;
	}

	private final BigDecimal price;

	public Product(String name, BigDecimal price, String url, Person person) {
		this.id = -1;
		this.name = name;
		this.price = price;
		this.url = url;
		this.person = person;
	}

	public Product(long id, String name, BigDecimal price, String url, Person person) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.url = url;
		this.person = person;
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

	public Person getPerson() {
		return person;
	}
}
