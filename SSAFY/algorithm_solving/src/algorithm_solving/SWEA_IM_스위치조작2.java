package algorithm_solving;

import java.util.Scanner;

public class SWEA_IM_스위치조작2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 전등 개수
			int N = sc.nextInt();
			// 1번부터 N번까지 전등이 있으니 +1 해 인덱스를 보기 편하게
			int[] arr = new int[N + 1];
			// 초기 전등 상태 설정
			for (int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
			}

			// 목표 전등 상태 값 받기
			int[] goal = new int[arr.length];
			for (int i = 1; i <= N; i++) {
				goal[i] = sc.nextInt();
			}

			// 로직
			// 전등 조작 횟수
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (goal[i] != arr[i]) {
					// 조작횟수 추가
					count++;
					// i 이후로 역전 해주기
					for(int j = i; j <= N; j++) {
						arr[j] = 1 - arr[j];
					}
				}

			}

			// 출력
			System.out.println("#" + test_case + " " + count);
		}
	}

}
