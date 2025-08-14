import java.util.Scanner;

public class SWEA_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// N과 M 받기
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] aArr = new int[N];
			int[] bArr = new int[M];

			for (int i = 0; i < N; i++) {
				aArr[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				bArr[i] = sc.nextInt();
			}

			// 로직
			// N과 M을 비교해 작은 쪽을 고정시켜 긴쪽을 범위에 벗어나지 않게 해서 곱의 합을 구해보자!
			// 만일 길이가 같아면 전부 곱해!
			int max = Integer.MIN_VALUE;
			
			int[] arr1, arr2;
			int len1, len2;
			
			if (N > M) {
			    arr1 = bArr; len1 = M;
			    arr2 = aArr; len2 = N;
			} else {
			    arr1 = aArr; len1 = N;
			    arr2 = bArr; len2 = M;
			}

			for (int i = 0; i < len2 - len1 + 1; i++) {
			    int sum = 0;
			    for (int j = 0; j < len1; j++) {
			        sum += arr1[j] * arr2[i + j];
			    }
			    max = Math.max(max, sum);
			}

			// 출력
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
}
