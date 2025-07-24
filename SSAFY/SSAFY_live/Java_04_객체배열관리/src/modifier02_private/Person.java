package modifier02_private;

public class Person {
	// 같은 클래스 내부에서만 접근이 가능
	
	private String name;
	private int age;
	
	
	private void info() {
		this.name = "yang"; // 나는 내부이니까 접근이 가능
	}

}
