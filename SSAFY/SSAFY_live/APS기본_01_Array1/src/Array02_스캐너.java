import java.util.Scanner;

public class Array02_스캐너 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스 수를 입력 받는다.
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			int N = sc.nextInt();
			System.out.println(N);
			
			// 주의 요망!
//			sc.next();
//			sc.nextLine();
			
			
			
			System.out.println("#" + tc + " " + ans);
		} //tc 반복문
	}//main
}
