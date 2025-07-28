package com.ssafy.list;

import java.util.ArrayList;
import java.util.List;

public class List01_ArrayList {
	public static void main(String[] args) {
		//List : 순서 o / 중복 o
//		ArrayList<String> names = new ArrayList<String>();
//		ArrayList<String> names = new ArrayList<>();
		
		List<String> names = new ArrayList<>();
		
		//원소 추가
		names.add("박지우");
		names.add("방혜민");
		names.add("박지우");
		names.add(3, "kim");
//		names.add(1000, "PARK"); //이거 불가능
		
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println(names);
		
		//전체를 비우는 법
		//1. 인스턴스를 새로 만든다.
		//2. 전체를 반복 돌면서 하나씩 제거하기
		//3. clear()
		names.set(2, "이지은");
		
		
		names.remove("방혜민");
		System.out.println(names);
		
		
		names.clear();
		System.out.println(names.isEmpty());
	}

}
