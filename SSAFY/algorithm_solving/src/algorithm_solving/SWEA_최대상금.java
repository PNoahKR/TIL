import java.util.HashSet;
import java.util.Scanner;

public class SWEA_최대상금 {
	static int max = 0;
	static HashSet<String>[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * 재귀함수를 통해서 i번 교환
			 * 0. 종료 조건
			 * 
			 * 1. 교환할 인덱스 i, j 선정
			 * 2. n[i] <-> n[j] 교환
			 * 3. 재귀 호출 i-1번 교환
			 * 4. n[i] <-> n[j] 교환
			 */
			// 입력
			String nums = sc.next();
			int turn = sc.nextInt();
			
			// 로직 (완전 탐색) -> 모든 경우의 수를 재귀함수를 통해 진행
			char[] arr = new char[nums.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nums.charAt(i);
			}
			
			visited = new HashSet[turn + 1];
			 for(int i=0; i<=turn; i++) {
			     visited[i] = new HashSet<>();
			 }
			
			getMax(arr, turn);
			
			// 출력
			System.out.println("#" + test_case + " " + max);
			max = 0;
		}
	}

	public static void getMax(char[] arr, int turn) {
		// 현재 숫자 조합 만들기
		String currentNum = new String(arr);
		// 가지치기: 현재 교환 횟수에서 이미 만들어본 숫자라면 탐색 중단
	    if (visited[turn].contains(currentNum)) {
	        return;
	    }
	    // 현재 상태를 방문했다고 기록
	    visited[turn].add(currentNum);
		
		if(turn == 0) {
			max = Math.max(max, Integer.parseInt(currentNum));
	        return;
		}
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				// 1. i, j 교환
				char temp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp1;
				getMax(arr, turn - 1);
				char temp2 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp2;
			}
		}
	}
}
