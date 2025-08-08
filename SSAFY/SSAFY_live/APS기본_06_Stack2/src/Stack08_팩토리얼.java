
public class Stack08_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(fact(5));
		
		System.out.println(fact(14));
	}
	
	public static int fact(int n) {
		// 1. 기본 부분
		if(n <= 1) { // 정답은 없고 문제를 보고 판단하자
			return 1;
		}
		// 2. 재귀 부분
		return n * fact(n - 1);
	}
}
