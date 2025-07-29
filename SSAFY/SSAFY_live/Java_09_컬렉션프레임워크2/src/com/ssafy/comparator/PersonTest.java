package com.ssafy.comparator;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonTest {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("강", 29));
		list.add(new Person("은혜", 10));
		list.add(new Person("양", 45));
		
		Collections.sort(list, new PersonComparator());
		
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		
		Collections.sort(list, (p1, p2) -> Integer.compare(p1.age, p2.age));
		
		
		
		
		
		
		for(Person p : list) {
			System.out.println(p);
		}
		
	}
}
