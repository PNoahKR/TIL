package polymorphism01;

public class Test2 {
	public static void main(String[] args) {
		Person p = new Student();
		
		//아래의 코드는 문법적으로 문제없지만 실행 시키면 곤란
//		Student st = (Student) p;
		
		if(p instanceof Student) {
			Student st = (Student) p;
			st.study();
		}
		
	}

}
