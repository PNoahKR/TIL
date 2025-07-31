package com.ssafy.pjt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 싱글턴 패턴
public class StudentManagerImpl implements StudentManager{
	
	// 학생들 목록을 관리하자!
	// 1. 배열(고정된 길이)
	// 2. 리스트(동적 길이)
	// 2-1. 리스트 종류 고르기~
	
	private List<Student> studentList = new ArrayList<>();
	
	private File file = new File("data/student.txt");
	
	private static final String DELIM = "\t";
	
	// 2. 나라도 생성하자
	private static StudentManager manager = new StudentManagerImpl();
	
	// 1. 외부에서 생성할 수 없게 되어따!
	private StudentManagerImpl() {
		roadData();
	}
	
	// 3. 가져다가 쓰십셔
	public static StudentManager getManager() {
		return manager;
	}

	@Override
	public boolean add(Student student) {
		//100정도면 관리할래~ 하면 
		if(studentList.size() > 100) {
			System.out.println("더이상 기억할 수 없어요");
			return false;
		}
		
		////////////////////////////////////////////////////////
		// 추후 고려 포인트 student 객체는 완벽한가? -> 믿어야함..
		// 유효성 검사! -> 모든 필드가 완벽하게 작성이 되어있는지 유요한지 체크
		
		return studentList.add(student); // 길이 확인 하지 않아도 됨~
	}

	@Override
	public List<Student> getAll() {
		return studentList;
	}

	@Override
	public Student getStudent(int studentId) {
		for(Student st : studentList) {
			if(st.getStudentId() == studentId) {
				return st;
			}
		}
		return null;
	}

	//해당 코드는 일치해야만 가져온다
	//일부 포함 검색이라면 어떻게 해야할지 작성해보시오~
	@Override
	public List<Student> searchName(String name) {
		List<Student> tmp = new ArrayList<>();
		for(Student st : studentList) {
			if (st.getName().equals(name)) {
				tmp.add(st);
			}
		}
		return tmp;
	}

	@Override
	public void update(Student student) throws StudentNotFoundException {
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudentId() == student.getStudentId()) {
				studentList.set(i, student);
				return;
			}
		}
		throw new StudentNotFoundException(student.getStudentId());
		
	}

	@Override
	public boolean delete(int studentId) {
//		for(int i = 0; i < studentList.size(); i++) {
//			//일치하면 지워 하나 지울때는 상관 ㄴ
//			// 여러개 지울때는 거꾸로 도는 경우 o
//		}
		for(int i = studentList.size() - 1; i>=0; i--) {
			if(studentList.get(i).getStudentId() == studentId) {
				studentList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveData() {
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
			for(Student st : studentList) {
				bw.write(st.getStudentId() + DELIM + st.getName() + DELIM + st.getTrack() + DELIM + st.getMajor());
				bw.newLine();
			}
			System.out.println("저장완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public void roadData() {
		if(file.exists()) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
				String line;
				
				while((line = br.readLine()) != null) {
					String[] tmp = line.split(DELIM);
					if(tmp.length != 4) continue; //이상한 데이터임;;
					int studentId = Integer.parseInt(tmp[0]);
					String name = tmp[1];
					String track = tmp[2];
					String major = tmp[3];
					
					studentList.add(new Student(studentId, name, track, major));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
	} 
}
