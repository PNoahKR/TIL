package modifier06_getter_setter;

public class Person {
	//외부에서 접근이 불가능
	
	private String name;
	private int age;
	
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//나이를 수정하기 위해서는 메서드를 구현한다
	//메서드의 이름을 하고싶은데로 해도 상관없지만 관례가 존재!
	//
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	
	
	public void info() {
		System.out.println(name + ":" + age);
	}


}
