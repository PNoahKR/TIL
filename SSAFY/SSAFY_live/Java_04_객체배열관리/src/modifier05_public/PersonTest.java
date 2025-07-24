package modifier05_public;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
		p.age = 100; //public 접근 가능.
		p.info();
	}
}
