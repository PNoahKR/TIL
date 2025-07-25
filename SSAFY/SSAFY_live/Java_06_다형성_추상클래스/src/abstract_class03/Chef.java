package abstract_class03;

public abstract class Chef {
	String name;
	int age;
	
	public void eat() {
		System.out.println("음식을 먹는다");
	}
	
	
	public abstract void cook();

}

