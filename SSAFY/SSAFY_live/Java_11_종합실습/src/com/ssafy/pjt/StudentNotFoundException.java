package com.ssafy.pjt;

public class StudentNotFoundException extends Exception {

	public StudentNotFoundException(int studentId) {
		super(studentId + "라는 학번의 학생은 없습니다.");
	}
	
	
}
