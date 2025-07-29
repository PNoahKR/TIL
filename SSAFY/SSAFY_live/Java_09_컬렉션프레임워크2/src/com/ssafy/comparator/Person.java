package com.ssafy.comparator;

//나와 얘를 비교할 기준을 정의하겠다!
public class Person {
	String name;
	int age;

	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
