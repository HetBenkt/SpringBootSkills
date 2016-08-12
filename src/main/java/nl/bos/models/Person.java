package nl.bos.models;

import java.util.Map;

public class Person {
	private final long id;
	private final String name;
	private final int age;
	private Map<String, String> keywords;

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

	public Map<String, String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Map<String, String> keywords) {
		this.keywords = keywords;
	}

	public long getId() {
		return id;
	}
}
