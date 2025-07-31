package com.ssafy.pjt;

public class Test {
	public static void main(String[] args) {
		StudentManager mgr = StudentManagerImpl.getManager();
		
		Student st1 = new Student("양띵균", "컴퓨터공학", "Java 비전공");
		Student st2 = new Student("양명균", "컴퓨터공학", "Java 비전공");
		Student st3 = new Student("양땅균", "컴퓨터공학", "Java 비전공");
		Student st4 = new Student("양뗭균", "컴퓨터공학", "Java 비전공");
		Student st5 = new Student("양띙균", "컴퓨터공학", "Java 비전공");
		
		mgr.add(st1);
		mgr.add(st2);
		mgr.add(st3);
		mgr.add(st4);
		mgr.add(st5);
		

//		for(Student st : mgr.getAll()) {
//			System.out.println(st);
//		}
		
//		System.out.println(mgr.getStudent(7));
		
		for(Student st : mgr.searchName("양띵균")) {
			System.out.println(st);
		}
		
		Student st6 = new Student("양면균", "경제학", "Java 비전공");
		st6.setStudentId(15);
		
		try {
			mgr.update(st6);
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
		for(Student st : mgr.getAll()) {
			System.out.println(st);
		}
		
		mgr.saveData();
		
	}
}
