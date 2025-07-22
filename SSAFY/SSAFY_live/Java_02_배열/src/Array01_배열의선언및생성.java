import java.util.Arrays;

public class Array01_배열의선언및생성 {
	public static void main(String[] args) {
		//배열을 선언
		int[] arr1; //권장
		int arr2[]; //비권장
		
		//배열을 초기화
		int[] arr3 = new int[10];
		String[] arr4 = new String[5];
		
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
		
		//길이를 직접 명시할 수 없음!
		int[] arr5 = new int[] {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr5));
		
		
		String[] arr6 = {"박지우", "박지유", "박지으"}; //선언과 동시에 이루어질때만 가능
		System.out.println(Arrays.toString(arr6));
		
		arr6 = new String[] {"어라라", "아라라", "히히히"}; //재할당 가능
		//arr7 = {"1", "2", "3"}; 			 //재할당 불가능 
		
		System.out.println(arr6[0]);
		
	}

}
