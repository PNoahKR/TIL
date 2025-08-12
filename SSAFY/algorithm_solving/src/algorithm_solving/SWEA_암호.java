import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_암호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 숫자의 개수
			int N = sc.nextInt();
			// '지정위치'로 부터 M 번째
			int M = sc.nextInt();
			// 반복 횟수
			int K = sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			// 로직
			
			
			// 출력
			
			
		}
		sc.close();
	}
}
