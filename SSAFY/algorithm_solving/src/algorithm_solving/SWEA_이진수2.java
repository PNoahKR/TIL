import java.util.Scanner;

public class SWEA_이진수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			double N = sc.nextDouble();
			
			// 로직
			String binary = "";
			
			while(binary.length() <= 13) {
				if(binary.length() > 12) {
					binary = "overflow";
					break;
				}
				
				int a = (int) Math.floor(N * 2);
				binary += String.valueOf(a);
				N = (N * 2) % 1;
				if(N == 0) {
					break;
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + binary);
		}
	}
}
