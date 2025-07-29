package com.ssafy.collections;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		// boolean 반환
		stack.add(10);

		// item 반환
		stack.push(20);

		System.out.println(stack.peek());
		
		
//		int num = stack.remove(0); // vector
		int num2 = stack.pop(); // stack
		stack.pop();
		
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		
		
//		stack.pop();
//		stack.remove(0);
		
		
		
		
	}
}
