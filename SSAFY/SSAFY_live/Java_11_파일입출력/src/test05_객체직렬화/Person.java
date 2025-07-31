package test05_객체직렬화;

import java.io.Serializable;

//객체 직렬화 하기 위해서는
public class Person implements Serializable {
	/**
	 * 테스트를 위해.. 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;

	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
