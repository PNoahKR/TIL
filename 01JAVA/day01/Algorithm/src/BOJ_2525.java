import java.util.Scanner;

public class BOJ_2525 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        //로직
        int minutes = (A * 60) + B + C;
        
        int h = (minutes / 60) % 24;
        int m = minutes % 60;
        
        //출력
        System.out.print(h + " " + m);
	}
}
