package inheritance05_final;

//Person을 상속받기 위해서 extends 키워드를 사용
public class Student extends Person {

	String major;
	
	//오버라이딩 했다 -> 어노테이션쓰면 강제성이 부여 된다.
	//부모클래스에 정의된 메서드와 동일해야함
	// 메서드 이름/매개변수/반환타입
	//접근 제한자는 부모보다 넓어야함
	@Override
	public void eat() {
		System.out.println("지식을 먹는다.");
	}

	//메서드 오버로딩
	//메서드명 동일, 매개변수 순선, 개수가 다른것
	// 반환 타입만 다른건 노 인정
	public void eat(int time) {
		System.out.println(time + "지식을 먹는다.");
	}
	
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
