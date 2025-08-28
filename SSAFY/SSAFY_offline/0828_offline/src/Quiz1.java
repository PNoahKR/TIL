import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int N = sc.nextInt();
		System.out.println(N);
		int r = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(r + " " + c);
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			String str = sc.next();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
}
