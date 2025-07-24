package com.ssafy.pjt;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("양싸피1", 50, 190, "ISTP", false);
		Person p2 = new Person("양싸피2", 50, 190, "ISTP", false);
//	
//		System.out.println(p.toString());

//		PersonManager mgr1 = new PersonManager();
//		PersonManager mgr2 = new PersonManager();

		PersonManager mgr1 = PersonManager.getManager();
		PersonManager mgr2 = PersonManager.getManager();
		
		System.out.println(mgr1 == mgr2);
		
		
		mgr1.addPerson(p1);
		mgr1.addPerson(p2);
		
		mgr1.remove("양싸피1");

		for (Person pp : mgr1.getAll()) {
			System.out.println(pp.toString());
		}
		
//		System.out.println(mgr1.search("양싸피1"));
		
		p1.setHungry(true);
		
		mgr1.update(p1);
		
//		System.out.println(mgr1.search("양싸피1"));
	}
	
}
