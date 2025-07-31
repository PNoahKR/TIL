package com.ssafy.pjt;

import java.io.Serializable;

// 설계도~! 
public class Student implements Serializable, Comparable<Student> {
	
	private static final long serialVersionUID = 1L;
	private static int autoIncreaseId = 1;
	private int studentId; //고유한데... 셀프로 하면 처리할 일이 늘어나니까~
	private String name;
	private String major;
	private String track;
	
	public Student() {
	}
	
	public Student(String name, String major, String track) {
		this.studentId = autoIncreaseId++;
		this.name = name;
		this.major = major;
		this.track = track;
	}

	public Student(int studentId, String name, String major, String track) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.track = track;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", major=" + major + ", track=" + track + "]";
	}

	@Override
	public int compareTo(Student o) {
		// - 로 해두었는데
		// 음수 0 양수
		return this.studentId - o.studentId;
	}
	
	
	
}
