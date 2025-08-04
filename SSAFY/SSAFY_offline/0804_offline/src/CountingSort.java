import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		// 아직 정렬되지 않은 배열
		int[] arr = { 4, 2, 1, 6, 8, 9, 7, 3 };

		// 정렬 전
		System.out.println(Arrays.toString(arr));
		
		// 카운팅 정렬 실시
		// 우리가 수행하게 될 배열의 원소 가장 큰 값 찾기
		// 1. 카운팅 배열을 (크기) 선언
		int[] count = new int[10]; // 인덱스로 0부터 9까지
		
		
		// 2. 카운팅 배열에 개수 세기!
		for (int v : arr) {
			count[v]++;
		}
		
		// 3. 카운팅 -> 누적합 배열로 구하기
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		
		// 4. 결과 배열 생성
		int[] result = new int[arr.length];
		// 안정정렬 구현하기 위해서!
		// 5. 원본 배열을 뒤에서부터 처리 (안정 정렬을 위해)
		for(int i = arr.length-1; i >= 0; i--) {
			// 원소를 넣을 위치를 찾느다
			int value = arr[i]; //원소값
			int idx = count[value]; //실제 인덱스 번호
			result[idx - 1] = value;
			count[value]--;
		}
		
		// 정수 하나만을 정렬... 아래의 코드를 바로 써도 무방하다!
		
		// 3. 최종적으로 누적된 값을 해당되는 인덱스 갯수만큼 출력
		for(int i = 0; i < 10; i++) {
			// 카운팅 되어 있는 횟수 반복!
			for(int j = 0; j < count[i]; j++) {
				System.out.print(i + ", ");
			}
		}
		System.out.println();
		
		
		
		// 정렬 후
//		System.out.println(Arrays.toString(arr));
	}
}
