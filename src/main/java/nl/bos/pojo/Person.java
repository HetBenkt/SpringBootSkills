package nl.bos.pojo;

import java.util.Map;

public class Person {
	private String name;
	private int age;
	private Map<String, String> keywords;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, String> getKeywords() {
		return keywords;
	}
	public void setKeywords(Map<String, String> keywords) {
		this.keywords = keywords;
	}
}
