package modifier06_getter_setter;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person("김싸피", 20);
		
		p.info();
		
		//나이를 수정하기 위해서는?
		p.setAge(21);
		System.out.println(p.getAge());
	}
}
