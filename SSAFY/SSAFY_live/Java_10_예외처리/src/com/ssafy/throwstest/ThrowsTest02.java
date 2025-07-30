package com.ssafy.throwstest;

// Check 계열 던져보자!
public class ThrowsTest02 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// 메서드를 정의할 건데~ 
	public static void method1() throws ClassNotFoundException {
		// 나도 두가지 선택권~
		// 1. 직접 처리하는 방법 (try-catch)
		// 2. 간접 처리 (throws) -> 나를 호출한 곳으로 던져!
		method2();
	}


	private static void method2() throws ClassNotFoundException {
		//Checked 계열을 발생시키자
		// 1. 직접 처리하는 방법 (try-catch)
		// 2. 간접 처리 (throws) -> 나를 호출한 곳으로 던져!
		Class.forName("Hello");
	}
}
