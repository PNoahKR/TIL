package com.ssafy.user_exception;

public class FruitNotFoundException extends Exception {

	public FruitNotFoundException(String name) {
		super(name + "에 해당하는 과일은 없다!");
	}

	
}
