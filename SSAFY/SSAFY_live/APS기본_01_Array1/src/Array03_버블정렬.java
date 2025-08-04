import java.util.Arrays;

public class Array03_버블정렬 {
	public static void main(String[] args) {
		int[] arr = {55, 7, 78, 12, 42};
		
		System.out.println("사이클 정렬 전");
		System.out.println(Arrays.toString(arr));
		//함수로 만들어도 좋다
		int N = arr.length;
		
		// for문 2개
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				//오름차순(이슈 발생)
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}//인접한 두개를 비교하는 반복문
			System.out.println("사이클이 끝난 뒤 모습");
			System.out.println(Arrays.toString(arr));
		}//N-1번만 반복문 수행! (i 위치는 각 사이클에서 최대 데이터가 저장될 위치)		
		System.out.println(Arrays.toString(arr));
	}
}
