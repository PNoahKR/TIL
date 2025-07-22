import java.util.Arrays;

public class Array_참조테스트 {
	public static void main(String[] args) {
		// 참조형변수(참조타입)은 "원본"을 가리킨다.
		//		//		은 할당(=) 시에 주소(address)를 복사
		int[] arr1 = new int[] {1, 2, 3, 4};
		int[] arr2 = arr1;
		
		arr2[2] = 10;
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		// 기본자료형(int, boolean, char, ...)은 값을 직접 저장한다.
		//			//			은 할당(=)시에 값(value)를 복사
		int a = 100;
		int b = 200;
		a = b;
		a = 300;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}
