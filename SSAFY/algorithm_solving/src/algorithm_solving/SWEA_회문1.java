package algorithm_solving;

import java.util.Iterator;
import java.util.Scanner;

public class SWEA_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// 입력
			// 회문 길이
			int n = sc.nextInt();
			char[][] arr = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 로직
			// 제시된 길이의 회문 개수
			int count = 0;

			// 수평 찾기
			// row 행은 고정
			for (int i = 0; i < 8; i++) {
				// column 열은 (열의 길이)8 - (회문길이)n + 1 만큼 탐색
				for (int j = 0; j < 8 - n + 1; j++) {
					// 회문 조건
					boolean isOk = true;
					// 회문을 찾기 위해 n/2만큼 순회
					for (int k = 0; k < n / 2; k++) {
						// column 값에 j + k 와 j + n - 1 - k 비교
						// j <-> j+n-1 은 n길이 만큼의 비교점
						if (arr[i][j + k] != arr[i][j + n - 1 - k]) {
							isOk = false;
							break;
						}
					}
					if (isOk) {
						count++;
					}
				}
			} // 고정된 row 반복문

			// 수직 찾기 (수평과 같은 맥락)
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - n + 1; i++) {
					boolean flag = true;
					for (int k = 0; k < n / 2; k++) {
						if (arr[i + k][j] != arr[i + n - 1 - k][j]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						count++;
					}
				}
			}

			// 출력
			System.out.println("#" + t + " " + count);
		}
	}
}
