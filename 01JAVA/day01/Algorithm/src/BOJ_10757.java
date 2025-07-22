import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정수형 입력 두개를 받아서 a, b 변수에 할당한다...!
		// 가변적인 크기를 갖는 참조자료형을 사용해보자...! (정수형 가변적인 참조자료형 BigInteger)
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		
		
	}
}
