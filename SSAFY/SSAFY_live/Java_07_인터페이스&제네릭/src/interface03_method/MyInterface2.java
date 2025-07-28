package interface03_method;

public interface MyInterface2 {
	default void method2() {
		System.out.println("MyInterface1 -> default method");
	}
	
	default void method3() {
		System.out.println("MyInterface1 -> default method3");
	}
	
	static void method4() {
		System.out.println("스태틱메서드 입니다.");
	}
}
