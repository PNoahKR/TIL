package polymorphism01;

public class Test {
	public static void main(String[] args) {
		Student st = new Student();
		Person p = new Student();
		Object obj = new Person();
		Object obj2 = new Student();
		
//		Student st1 = new Person();
		
		//묵시적 형변환
		p = st; //자식 타입을 부모로 캐스팅 할 때는 문제없다
		obj = p;
		
		//명시적 형변환
		Person person = new Person();
		Student student = (Student) person; //부모 -> 자식 캐스팅은 명시적으로 써줘야한다
		
		
		
		
		Person person2 = new Student();
		Student student2 = (Student) person2;
		
		
	}
}
