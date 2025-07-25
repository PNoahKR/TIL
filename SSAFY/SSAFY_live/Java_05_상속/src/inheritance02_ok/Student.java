package inheritance02_ok;

//Person을 상속받기 위해서 extends 키워드를 사용
public class Student extends Person{
	
	String major;
	
	public void study() {
		System.out.println("공부를 한다");
	}

}
