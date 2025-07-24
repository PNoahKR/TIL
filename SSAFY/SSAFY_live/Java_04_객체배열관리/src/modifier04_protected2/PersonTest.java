package modifier04_protected2;

import modifier04_protected.Person;

public class PersonTest extends Person {
	public static void main(String[] args) {
		Person p = new Person();
		
//		p.age = 100; //protected 다른 패키지 상속관계에서 접근 가능.
//		p.info();
		
		PersonTest pt = new PersonTest();
		pt.age = 100;
		pt.info();
	}
}
