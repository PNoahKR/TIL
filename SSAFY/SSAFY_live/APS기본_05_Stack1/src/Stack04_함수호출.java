import java.util.Arrays;

public class Stack04_함수호출 {
	public static void main(String[] args) {
		System.out.println("메인함수 실행");
		int a = 10;
		function1();
		System.out.println(a);
		System.out.println("메인함수 종료");
	}

	private static void function1() {
		System.out.println("함수 1 실행");
		int a = 20;
		int[] arr = {1,2,3};
		System.out.println(Arrays.toString(arr));
		function2(a, arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(a);
		System.out.println("함수 1 종료");
	}

	private static void function2(int a, int[] arr) {
		System.out.println("함수 2 실행");
		System.out.println(a);
		System.out.println(Arrays.toString(arr));
		a = 30;
		arr[1] = 1000;
		System.out.println(a);
		System.out.println("함수 2 종료");
	}
}
