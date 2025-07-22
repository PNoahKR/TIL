
public class VariableTest2 {
	public static void main(String[] args) {
		
		int a = 10;
		System.out.println(a); // 10
		System.out.println(++a); // 11
		System.out.println(a); // 11
		
		a = 10;
		System.out.println(a); // 10
		System.out.println(a++); // 10
		System.out.println(a); // 11
		
		a = 10;
		System.out.println(++a + a++); // 11 + 11
		
		a = 10;
		System.out.println(a++ + ++a); // 10 + 12
		
		a = 10;
		System.out.println(a++ + ++a + ++a); // 10 + 12 + 13
		
		a = 10;
		int b = 15;
		
		System.out.println(a + b * 2);
	}

}