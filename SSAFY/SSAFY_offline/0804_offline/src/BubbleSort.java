import java.util.Arrays;

public class BubbleSort {

	// 버블정렬 : 인접한 두개의 원소를 비교하여 큰 값을 뒤로 보내는 과정을 반복!
	private static void bubbleSort(int[] arr) {
		final int n = arr.length;
		
		// 면접관이 질문...??? 버블정렬 이거 최적화! 
		
		// n개의 원소를 순회하며 
		for(int i = 0; i < n; i++) { // TODO: 비교 로직 수정!
			
			// 교환이 발생하지 않으면 정렬 이미 완료!
			boolean swapped = false;
			
			for(int j = 0; j < n - i - 1; j++) {
				// 이전값과 이후값을 비교(교환)하는 과정...!
				if (arr[j] > arr[j+1]) {
					// 두 원소를 교환
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			
			// 교환이 아무것도 일어나지 않았으면 -> 정렬이 이미 완료되었으므로 종료!
			if(!swapped) break;
		}
	}

	public static void main(String[] args) {
		// 아직 정렬되지 않은 배열
		int[] arr = { 4, 2, 1, 6, 8, 9, 7, 3 };

		// 정렬 전
		System.out.println(Arrays.toString(arr));

		// 버블 정렬을 실행...! (메서드 작성)
		bubbleSort(arr);

		// 정렬 후
		System.out.println(Arrays.toString(arr));
	}

}