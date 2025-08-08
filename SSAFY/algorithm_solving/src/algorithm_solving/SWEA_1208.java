package algorithm_solving;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input (1).txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			//입력
			int[][] arr = new int[100][100];
			
			int t = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			//로직
			for (int i = 0; i < arr.length; i++) {
				int rSum = 0;
				for (int j = 0; j < arr.length; j++) {
					rSum += arr[i][j];
				}
				max = Math.max(max, rSum);
				int cSum = 0;
				for (int j = 0; j < arr.length; j++) {
					cSum += arr[j][i];
				}
				max = Math.max(max, cSum);
			}
			
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i][i];
			}
			max = Math.max(max, sum);
			
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i][arr.length - 1 - i];
			}
			max = Math.max(max, sum);
			
			
			
			
			
			
			
			
			
			//출력
			System.out.println("#" + t + " " + max);
		}
	}

}
