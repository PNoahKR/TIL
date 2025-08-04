import java.util.Arrays;
import java.util.Iterator;

public class SelectionSort {
	private static void selectionSort(int[] arr) {
		// 선택 정렬: 아직 정렬되지 않은 원소들 중에 최솟값 찾아 앞에 배치(교환) 방법으로 진행
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			// 최솟값을 가진 인덱스를 임의로 i로 지정
			int minIdx = i; // i = 0
			// [i+1, n) => i + 1 <= x < n // j = 1 ~ 6
			for (int j = i + 1; j < n; j++) {

				// 두 개의 값 [minIdx] <-> [j] 비교해서 (교환)
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			
			// 최솟값을 가지고 있는 minidx 인덱스가 탄생!
			if(minIdx == i)
				continue;
			// 최솟값과 현재 위치(i)를 교환
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
	}

	public static void main(String[] args) {
		// 아직 정렬되지 않은 배열
		int[] arr = { 4, 2, 1, 6, 8, 9, 7, 3 };

		// 정렬 전
		System.out.println(Arrays.toString(arr));

		// 버블 정렬을 실행...! (메서드 작성)
		selectionSort(arr);

		// 정렬 후
		System.out.println(Arrays.toString(arr));
	}

}
