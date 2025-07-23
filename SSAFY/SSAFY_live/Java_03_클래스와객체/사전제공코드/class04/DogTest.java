package class04;

public class DogTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
//		
//		dog.name = "마루";
//		dog.age = 8;
		
		Dog dog2 = new Dog("마리", 5);
		
		Dog dog3 = new Dog(10);
		System.out.println(dog3.name);
		
	}
}
