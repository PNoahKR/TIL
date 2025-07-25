package polymorphism01;


public class Person {
	
	String name;
	private int age;
	
	//파이널 변수 -> 값을 고정시킨다는 것!-> 반드시 초기화 해야한다.
	final String PNAME = "익명";
	//객체를 생성할 때는 무조건 생성자를 통해서 만든다!
	final String PNAME2;
	
	
	public void eat() {
		System.out.println("음식을 냠냠 먹는다");
	}

	public Person() {
//		super();
		PNAME2 = "익명2";
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		PNAME2 = "익명2";
	}

}
