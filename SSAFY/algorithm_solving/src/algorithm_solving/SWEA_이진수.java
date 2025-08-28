import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA_이진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_casse = 1; test_casse <= T; test_casse++) {
			// 입력
			// 16진수 길이
			int N = sc.nextInt();

			// 16진수 -> 2진수
			Map<String, String> mapping = new HashMap<>();
			mapping.put("0", "0000");
			mapping.put("1", "0001");
			mapping.put("2", "0010");
			mapping.put("3", "0011");
			mapping.put("4", "0100");
			mapping.put("5", "0101");
			mapping.put("6", "0110");
			mapping.put("7", "0111");
			mapping.put("8", "1000");
			mapping.put("9", "1001");
			mapping.put("A", "1010");
			mapping.put("B", "1011");
			mapping.put("C", "1100");
			mapping.put("D", "1101");
			mapping.put("E", "1110");
			mapping.put("F", "1111");
			
			// 16진수 받기
			String str = sc.next();
			// StringBuilder 에 담기
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				String s = str.charAt(i) + "";
				sb.append(mapping.get(s));
			}
			
			// 출력
			System.out.println(sb);
		}
	}
}
