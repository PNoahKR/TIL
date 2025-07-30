package com.ssafy.user_exception;

public class FruitNotFoundRuntimeException extends Exception {

	public FruitNotFoundRuntimeException(String name) {
		super(name + "에 해당 과일은 실행시점에 없다");
	}

	
}
