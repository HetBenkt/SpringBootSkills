package nl.bos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private final long id;

	@Column(nullable = false)
	private final String name;

	@Column(nullable = false)
	private final int age;

	@Column(nullable = true)
	private String keywords;

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
