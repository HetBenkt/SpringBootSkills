package nl.bos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private final long id;

	@Column(nullable = false)
	@NotNull
	@Size(min=1, max=32, message="Out of range")
	private final String name;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value="1")
	@DecimalMax(value="150")
	private final int age;

	@Column(nullable = true)
	private String keywords; //TODO Make it an ArrayList

	public Person() {
		id = 0;
		name = "";
		age = 0;
		keywords = "";
	}

	public Person(String name, int age) {
		this.id = -1;
		this.name = name;
		this.age = age;
	}

	public Person(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public long getId() {
		return id;
	}
}
