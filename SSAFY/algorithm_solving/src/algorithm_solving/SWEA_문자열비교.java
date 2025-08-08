package algorithm_solving;

import java.util.Scanner;

public class SWEA_문자열비교 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			//입력
			String str1 = sc.next();
			String str2 = sc.next();
			//로직
			if(str2.contains(str1)) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);
			}
			//출력
		}
	}

}
