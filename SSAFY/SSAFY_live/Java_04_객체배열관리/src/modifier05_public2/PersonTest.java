package modifier05_public2;

import modifier05_public.Person;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
		p.age = 100; //public 접근 가능.
		p.info();
	}
}
