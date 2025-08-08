package algorithm_solving;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4835 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			//로직
			//M개의 연속되는 이웃된 수의 합 중 최대 최소 값을 구하자
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			//N개의 정수 중에서 M개의 이웃된 수를 합하는 것으로,
			//0에서 M개의 숫자 부터 N-M 부터 N개까지의 수만 구하자
			for(int i = 0; i <= N-M; i++) {
				int sum = 0;
				for(int j = 0; j < M; j++) {
					sum += arr[i + j];
				}
				if(max < sum) {
					max = sum;
				}
				
				if(min > sum ) {
					min = sum;
				}
			}
			
			
			//출력
			System.out.println("#" + test_case + " " + (max - min));
			
		}//테이스 케이스 for문
	}
}
