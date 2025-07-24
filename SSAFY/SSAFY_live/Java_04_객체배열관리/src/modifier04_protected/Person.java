package modifier04_protected;

public class Person {
	// protected : 같은 패키지 안에서 접근 가능 / 다른 패키니 내의 하위클래스
	
	protected String name;
	protected int age;
	
	
	protected void info() {
		this.name = "yang"; // 나는 내부이니까 접근이 가능
	}

}
