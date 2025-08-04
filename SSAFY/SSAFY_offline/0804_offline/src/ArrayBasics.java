public class ArrayBasics {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };

		// 배열 길이
		System.out.println("배열 길이: " + arr.length);

		// 배열 요소 접근
		System.out.println("첫 번째 요소: " + arr[0]);
		System.out.println("마지막 요소: " + arr[arr.length - 1]);

		// 배열 순회
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// Q1. 그러면 배열을 역순으로 순회하려면???
		// 인덱스 i = 4, 3, 2, 1, 0
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 그러면 배열의 요소를 제곱값(x^2)으로 만드려면???
		for (int i = 0; i < arr.length; i++) {
//			int value = arr[i]; // 모든 배열 요소 접근...!
//			value = value * value; // 제곱값으로 연산
//			// 다시 배열에 할당
//			arr[i] = value;
			arr[i] = arr[i] * arr[i];
//			arr[i] = pow2(arr[i]);
//			arr[i] = arr[i] ^ 2; // No! 비트 XOR 연산자! 
//			arr[i] = Math.pow(i, 2); // No! 실수(부동소숫점 = 신뢰가 할 수 X)

		}

		// 향상된 for문 (Enhanced for loop)
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}

	private static int pow2(int i) {
		return i * i;
	}
}