package com.ssafy.pjt;

import java.util.List;

//인터페이스 -> 완벽히 추상클래스
public interface StudentManager {
	
	
	//메서드(CRUD)
	//등록
	boolean add(Student student);
	
	//조회(상세, 전체)
	List<Student> getAll();
	Student getStudent(int studentId);
	//검색 시 이름 중복 고려
	List<Student> searchName(String name);
	
	//수정
	void update(Student student) throws StudentNotFoundException;
	
	//삭제
	boolean delete(int studentId);
	
	//저장
	void saveData();
	
	//불러오기
//	void roadData();
}
