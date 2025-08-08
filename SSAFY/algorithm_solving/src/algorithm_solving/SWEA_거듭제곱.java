package algorithm_solving;

import java.util.Scanner;

public class SWEA_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int test_case = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + test_case + " " + pow(N, M));
		}
	}

	private static int pow(int n, int m) {
		if(m == 1) {
			return n;
		}
		return n * pow(n, --m);
	}
}
