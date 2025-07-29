package com.ssafy.comparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	//문자열을 비교하고 싶어!
	//나이순으로 정렬하고~>이름 순으로 정렬을 해라!
	@Override
	public int compare(Person o1, Person o2) {
		if(o1.age == o2.age)
			return o1.name.compareTo(o2.name);
		return o1.age - o2.age;
		
	}

}
