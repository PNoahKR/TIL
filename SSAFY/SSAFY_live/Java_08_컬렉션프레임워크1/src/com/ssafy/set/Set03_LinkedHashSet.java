package com.ssafy.set;

import java.util.*;

public class Set03_LinkedHashSet {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		
		//추가
		
		set.add("A");
		set.add("C");
		set.add(null);
		set.add("박지우");
		set.add(null);
		set.add("B");
		set.add("B");
		set.add("양띵균");
		set.add("양띵균");
		
		System.out.println(set);
		
		System.out.println(set.contains("A"));
		set.remove("A");
		
		for(String s : set) {
			System.out.println(s);
		}
		
		System.out.println(set.size());		
	}

}
