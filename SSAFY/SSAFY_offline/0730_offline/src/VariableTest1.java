
public class VariableTest1 {
	public static void main(String[] args) {
		// 1. 변수 a와 b를 정수형으로 선언
		// int a;
		// int b;
		
		// 2. a에 3을 b에 4를 할당하라
		// a = 3;
		// b = 4;
		
		// 3. 변수 a와 b를 선언하며 a에는 3, b에는 4로 초기화해라
		int a = 3;
		int b = 4;
		
		// 4-1. a와 b 변수의 값을 교환 해봐라
		//int c = a;
		//a = b;
		//b = c;
		
		// 4-2. XOR 연산
		a = a ^ b;
		b = a ^ b; // a ^ b ^ b = a
		a = a ^ b; // a ^ a ^ b = b
		
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		// overflow
		int c = 2000000000;
		int d = 200000000;
		System.out.println("c + d: " + (c + d));
	}

}