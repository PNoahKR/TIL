import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 수 T
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 입력 : 10개의 수를 입력 받기
			// 배열 선언 10개의 수 입력을 받을 공간 arr
			int[] arr = new int[10];
			// 정수 입력 10번 받기...!
			for (int i = 0; i < 10; i++) { // 10회 반복
				arr[i] = sc.nextInt(); // 1회 입력...
			}

			// 로직 : 10개의 수 중에서 최댓값과 최솟값 찾기!!
			// 1. 최댓값 찾기
			// 반복문을 통해서 모든 배열의 요소를 순회하여 비교
			// (가장 큰 값을 가지고 있는 원소를 찾기!)
			// 가장 큰 값을 가지고 있는 임시 변수 mx
//			int mx = arr[0];
//			for(int i = 1; i < 10; i++) {
//				// 임의의 값 mx보다 더 큰 수가 있다면 변경!
//				if(arr[i] > mx) {
//					mx = arr[i];
//				}
//			}
//			
//			// 최솟값 찾기 (배열의 임의의 원소값)
//			int mn = arr[0];
//			for(int i = 1; i < 10; i++) {
//				// 임의의 값 mx보다 더 작은 수가 있다면 변경!
//				if(arr[i] < mn) {
//					mn = arr[i];
//				}
//			}
//			

			int mx = arr[0];
			int mn = arr[0];
			for (int i = 1; i < 10; i++) {
//				// 임의의 값 mx보다 더 큰 수가 있다면 변경!
//				if(arr[i] > mx) {
//					mx = arr[i];
//				}
//				// 임의의 값 mx보다 더 작은 수가 있다면 변경!
//				if(arr[i] < mn) {
//					mn = arr[i];
//				}

				mx = Math.max(arr[i], mx);
				mn = Math.min(arr[i], mn);
			}

			// 정렬을 사용하기...!
			Arrays.sort(arr); // 오름차순 정렬
			mn = arr[0];
			mx = arr[9];

			// 4. Stream API 라는 것을 사용하여 최댓값 뽑아내기..!
			mx = Arrays.stream(arr).max().getAsInt();
			mn = Arrays.stream(arr).min().getAsInt();

			// 마지막 로직... 최댓값 최솟값을 제외한 중간의 값들의 평균...!
			// 평균 계산 : 전체합 / 요소의갯수 -> 평균값
			// 전체합 total
			int total = 0;
			for (int i = 0; i < 10; i++)
				total += arr[i];

			// 최솟값과 최댓값 제거...!
			total = total - mx - mn;

			int average = (int) ((double) total / 8 + 0.5); // 반올림??? -> 0.5 더하기


			// 출력
			System.out.println("#" + tc + " " + average);

		}
	}
}