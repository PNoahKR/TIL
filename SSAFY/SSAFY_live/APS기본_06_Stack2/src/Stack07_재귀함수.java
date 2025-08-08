
public class Stack07_재귀함수 {
	public static void main(String[] args) {
		function2(10);
	}
	
	// 단순히 나 자신을 호출하게 되면... 무한 호출
	public static void function1() {
		System.out.println("function1 호출");
		function1();
	}
	
	public static void function2(int num) {
		// 1. 기본 부분(재귀를 끝내는 조건)
		if(num < 0) {
			return;
		}
		
		// 2. 재귀를 호출하는 부분
		else {
			System.out.println("function2 호출");
			function2(num - 1);			
		}
	}
}
