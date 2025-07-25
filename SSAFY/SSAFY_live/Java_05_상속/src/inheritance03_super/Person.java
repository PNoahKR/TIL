package inheritance03_super;

public class Person {
	
	String name;
	private int age;
	
	public void eat() {
		System.out.println("음식을 냠냠 먹는다");
	}

//	public Person() {
//		super();
//	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
