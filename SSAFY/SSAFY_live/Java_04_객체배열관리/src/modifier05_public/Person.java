package modifier05_public;

public class Person {
	// public : 접근 가능 / 다른 패키니 접근가능
	
	public String name;
	public int age;
	
	
	public void info() {
		this.name = "yang"; // 접근이 가능
	}

}
