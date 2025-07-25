package polymorphism01;

class Parent {
	String x = "parent";
	
	public String method() {
		return "parent method";
	}
	
	public static String method2() {
		return "static parent method";
	}
}

class Child extends Parent{
	String x = "child";
	
	@Override
	public String method() {
		return "child method";
	}
	
	public static String method2() {
		return "static child method";
	}
}

public class BindingTest {

	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
//		System.out.println(p.x);
//		System.out.println(c.x);
		
		//동적 바인딩
		System.out.println(p.method());
		System.out.println(c.method());
		
		
		System.out.println(p.method2());
		System.out.println(c.method2());
		
		System.out.println(p);// obj toString -> 동적바인딩에 의해 p의 toString이 동작
		System.out.println(p.toString());
		
		
	}
}
