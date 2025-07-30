package com.ssafy.throwstest;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
	void method1() throws IOException {
		// 코드 있고..
	}
	
	void method2() throws ClassNotFoundException {
		// 코드 있고..
	}
}

class Child extends Parent {
	@Override
	void method1() throws FileNotFoundException {
	}
	@Override
	void method2() {
	}
}
public class ThrowsTest03 {
	public static void main(String[] args) {
		Child c = new Child();
//		c.method();
	}
}
