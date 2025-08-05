
public class BinarySearchTest {

	private static int binarySearch(int[] arr, int target) {
		/*
		 * 일상생활 예시: 1~100 UP/DOWN 게임! - 친구 1~100 사이의 수 하나를 생각하기...! (예: 72) - 나: 50! ->
		 * 친구 : UP! (51~100) - 나: 75! -> 친구 : DOWN! (51~74) - 나: 62! -> 친구 : UP! (63~74)
		 * - 나: 69! -> 친구 : UP! (70~74) - 나: 72! -> 친구: 정답!!!!
		 */
		// 우리가 탐색할 범위의 왼쪽 범위, 오른쪽 범위
		// 왼쪽 범위 left, 오른쪽 범위 right
		int left = 0;               // 배열의 0
		int right = arr.length - 1; // 배열의 마지막 인덱스
		
		// 반복문으로 우리가 외치는 수가 target이 되는 경우! 종료!
		while(left <= right) { // TODO: 조건문 바꿔야함;
			// 우리의 범위 중간값 계산
			int middle = (left + right) / 2;
			
			// 친구에게 1. UP 2. DOWN 3. 정답
			
			// 정답일 경우 = 내가 원하는 target을 배열에서 찾았을 경우
			if(arr[middle] == target) {
				return middle;
			}
			
			// 1. up 
			if(arr[middle] < target) {
				left = middle + 1; // 오른쪽 절반 탐색
			} else { // 2. down
				right = middle - 1; // 왼쪽 절반 탐색
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// 정렬이 되어 있는 배열
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 100, 10000, 100000 };

		System.out.println(binarySearch(arr, 8));
	}

}
