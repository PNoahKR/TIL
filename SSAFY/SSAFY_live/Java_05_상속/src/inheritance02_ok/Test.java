package inheritance02_ok;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		Student st = new Student();
		
		//이제는 서로 연관이 있다.
		p.eat();
		st.eat();

	}

}
