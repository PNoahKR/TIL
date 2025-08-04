import java.util.Arrays;

public class Array04_순차검색 {
	public static void main(String[] args) {
		int[] arr = new int[] { 93, 13, 45, 2, 7, 49, 65, 8, 14, 22 };

		System.out.println(searchWhileNoSort(arr, 2));
		System.out.println(searchForNoSort(arr, 2));
		Arrays.sort(arr);
		System.out.println(searchWhileSort(arr, 2));
		System.out.println(searchForSort(arr, 2));

	}

	// 반환타입 : 찾으면 해당 위치 반환 / 없으면 -1 반환
	public static int searchWhileNoSort(int[] arr, int key) {
		int i = 0;
		while (i < arr.length) {
			// 찾았으면 return 할거야~
			if (arr[i] == key) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static int searchForNoSort(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int searchForSort(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			//이렇게 마무리를 지으면 정렬 X와 차이가 없다
			if (arr[i] == key) {
				return i;
			} else if(arr[i] > key) {
				return -1;
			}
		} // 전체 정방향 순회 코드
		return -1;
	}

	public static int searchWhileSort(int[] arr, int key) {
		int i = 0;
		while (i < arr.length) {
			// 찾았으면 return 할거야~
			if (arr[i] == key) {
				return i;
			} else if(arr[i] > key) {
				return -1;
			}
			i++;
		}
		
		return -1;
	}
}
