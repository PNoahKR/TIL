package com.ssafy.set;

import java.util.*;

public class Set04_TreeSet {
	public static void main(String[] args) {
		NavigableSet<Integer> set = new TreeSet<>();

		// 이진탐색트리 (BST)
		set.add(10);
		set.add(20);
		set.add(50);
		set.add(150);
		set.add(25);
		set.add(10);
		set.add(10);

		System.out.println(set);
		System.out.println(set.first());
		System.out.println(set.last());
		System.out.println(set.size());

		// 근접탐색
		System.out.println(set.lower(25)); // 미만 이면서 가장 큰
		System.out.println(set.floor(25)); // 이하 이면서 가장 큰
		System.out.println(set.ceiling(25)); // 이상 이면서 가장 작은
		System.out.println(set.higher(25)); // 초과 이면서 가장 작은

		System.out.println(set.descendingSet());

		System.out.println(Arrays.toString(set.toArray()));
	}

}
