package com.ssafy.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
	String name;
	int age;
	
	public Person() {
		
	}
	
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	
	
}


public class Set02_HashSet_Person {
	public static void main(String[] args) {
		Set<Person> names = new HashSet<>();
		
		names.add(new Person("양띵균", 40));
		names.add(new Person("박지우", 29));
		names.add(new Person("양명균", 30));
		names.add(new Person("양띵균", 40));
		
		for	(Person p : names) {
			System.out.println(p);
		}
		
		System.out.println(names);
		
		
	}
}
