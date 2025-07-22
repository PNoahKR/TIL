import java.util.Arrays;

public class Array_참조테스트3 {
	public static void main(String[] args) {
		// 참조형변수(참조타입)은 "원본"을 가리킨다.
		//		//		은 할당(=) 시에 주소(address)를 복사
		int[][] arr1 = new int[][] {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
		int[][] arr2 = new int[3][3];
		
//		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
//		for (int i = 0; i < arr1.length; i++) {
//			for (int j = 0; j < arr1.length; j++) {
//				arr2[i][j] = arr1[i][j];
//			}
//		}
		
		for (int i = 0; i < arr1.length; i++) {
			System.arraycopy(arr1[i], 0, arr2[i], 0, arr1.length);
		}

		arr2[1][1] = 100;
	}
}
