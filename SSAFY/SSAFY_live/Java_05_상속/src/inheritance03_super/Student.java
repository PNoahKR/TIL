package inheritance03_super;

//Person을 상속받기 위해서 extends 키워드를 사용
public class Student extends Person {

	String major;

	public void study() {
		System.out.println("공부를 한다");
	}

	public Student() {
//		super(); //기본적으로 생략 -> 부모의 기본 생성자 호출
		this("익명", 0, "자유전공");
	}

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

}
