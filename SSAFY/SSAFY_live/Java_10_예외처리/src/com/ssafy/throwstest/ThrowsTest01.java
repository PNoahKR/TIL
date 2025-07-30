package com.ssafy.throwstest;

// UnCheck 계열 던져보자!
public class ThrowsTest01 {
	public static void main(String[] args) {
		
		try {
			method1();			
		} catch (ArithmeticException e) {
			System.out.println("수학적인 이슈 발생");
		}
	}
	
	
	// 메서드를 정의할 건데~ 
	public static void method1() {
		method2();
	}


	private static void method2() {
		//Checked 계열을 발생시키자
		// 1. 직접 처리하는 방법 (try-catch)
		// 2. 간접 처리 (throws) -> 나를 호출한 곳으로 던져!
//		int i = 1/0; // 0으로 나누는 것을 허용하지 않는다.
	}
}
