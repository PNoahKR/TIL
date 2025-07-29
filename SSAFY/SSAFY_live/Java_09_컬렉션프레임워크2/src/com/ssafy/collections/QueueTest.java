package com.ssafy.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
//		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(10);	//예외 발생
		queue.offer(20);	//실패반환
		
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
	}
}
