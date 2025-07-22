import java.util.Scanner;

public class BOJ_5585 {
	
	static int count, change;
	
	public static void solution(int yen) {
		count += change / yen;
		change %= yen;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//지불할 금액
		int pay_amount = sc.nextInt();
		//거스름돈
		change = 1000 - pay_amount;
		
		count = 0;
		
//		//500엔 받기
//		count += change / 100;
//		change %= 100;
//		
//		//100엔 받기
//		count += change / 100;
//		change %= 100;
//		
//		//50엔 받기
//		count += change / 50;
//		change %= 50;
//		
//		//10엔 받기
//		count += change / 10;
//		change %= 10;
//		
//		//5엔 받기
//		count += change / 5;
//		change %= 5;
//		
//		//1엔 받기
//		count += change / 1;
//		change %= 1;
		
		solution(500);
		solution(100);
		solution(50);
		solution(10);
		solution(5);
		solution(1);
		
		System.out.println(count);
	}
}
