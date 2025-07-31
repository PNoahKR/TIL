package 오프라인_수업;

import java.io.Serializable;

// 1. 직렬 -> 파일을 만듬 ... persons.dat
// 2. Person 안에 있는 필드를 수정...
//    -> 다른 버전이니까 이 때에는 uid도 변경
// 3. persons.dat -> 역직렬화 -> 객체? O/X
public class Person implements Serializable {

	private static final long serialVersionUID = 1L; // 임시
	
	private String name;
	public int age;
	public String className;
	public int score;
//	Object inventory;
	
	public Person(){
		this.name = "홍길동";
		this.age = 24;
		this.className = "서울 17반";
		this.score = 60;
//		this.inventory = new Object();
	}

}
