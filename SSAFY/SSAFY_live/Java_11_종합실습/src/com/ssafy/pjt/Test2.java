package com.ssafy.pjt;

public class Test2 {
	public static void main(String[] args) {
		StudentManager mgr = StudentManagerImpl.getManager();
		
		for(Student st : mgr.getAll()) {
			System.out.println(st);
		}
	}

}
