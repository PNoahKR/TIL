package com.ssafy.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		
		deque.addLast("양띵균");
		deque.addFirst("유승준");
		deque.addFirst("신영준");
		
		System.out.println(deque);
		
	}
}
