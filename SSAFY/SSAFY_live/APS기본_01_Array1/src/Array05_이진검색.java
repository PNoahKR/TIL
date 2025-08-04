import java.util.Arrays;

// 정렬 필수~!!
public class Array05_이진검색 {
	public static void main(String[] args) {
		int[] arr = new int[] { 93, 13, 45, 2, 3, 7, 49, 65, 8, 14, 22 };
		Arrays.sort(arr);
		System.out.println(binarySearch(arr, 14));
		
		
	}
	
	public static int binarySearch(int[] arr, int key) {
		//범위를 컨트롤 하는 변수 2개
		int L = 0;
		int R = arr.length - 1;
		
		//교체가 되면 멈춘다!
		while(L <= R) {
			int mid = (L + R) / 2; //정수처리 가능
			if(arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				//찾고자하는 값이 중앙 값보다 작다면 R을 움직여...
				R = mid - 1;
			} else {
				// 반대의 경우 L을 움직여...
				L = mid + 1;
			}
		}
		return -1;
	}
}
