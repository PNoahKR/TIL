package modifier01_static;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		
		System.out.println(p.pCount++);
		
		Person p2 = new Person();
		System.out.println(p2.pCount);
		
		p.eat();
		
		Person.study();
		
		
	}
	
	public static int add (int a, int b) {
		return a + b;
	}
}
