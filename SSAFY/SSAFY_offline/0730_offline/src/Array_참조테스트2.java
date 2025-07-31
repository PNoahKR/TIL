import java.util.Arrays;

public class Array_참조테스트2 {
	public static void main(String[] args) {
		// 참조형변수(참조타입)은 "원본"을 가리킨다.
		//		//		은 할당(=) 시에 주소(address)를 복사
		int[] arr1 = new int[] {1, 2, 3, 4};
//		
//		// 새로운 배열을 만들어서 값만을 따로 복사한다.
//		int[] arr2 = new int[arr1.length];
//		
//		// 반복문을 사용해서 요소 하나하나를 복사
//		for (int i = 0; i < arr1.length; i++) {
//			arr2[i] = arr1[i];
//		}
		
		// 1. Arrays.copyOf 메서드 사용
//		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		// 2. Arrayy.copoyOfRange 메서드 사용
//		int[] arr2 = Arrays.copyOfRange(arr1, 0, 4);
		
		// 3. System.arraycopy 메서드 사용
		int[] arr2 = new int[arr1.length];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
	}
}
