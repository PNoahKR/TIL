package modifier03_default;

public class Person {
	// default : 같은 패키지 안에서 접근이 가능
	
	String name;
	int age;
	
	
	void info() {
		this.name = "yang"; // 나는 내부이니까 접근이 가능
	}

}
