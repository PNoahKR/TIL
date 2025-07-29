package com.ssafy.comparable;

//나와 얘를 비교할 기준을 정의하겠다!
public class Person implements Comparable<Person>{
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

	@Override
	public int compareTo(Person o) {
//		if(age == o.age) return 0;
//		else if (age > o.age) return 1;
//		else return -1;
		
		
		//나이를 기준으로 정렬을 하자!(오름차순)
//		return this.age - o.age;
//		return -(this.age - o.age);
//		return o.age - this.age;
		return Integer.compare(age, o.age);
	}

}
