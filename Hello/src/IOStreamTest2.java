import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IOStreamTest2 {
	public static void main(String[] args) throws IOException {
		// 표준 입력 스트림 System.in (byte로 가져옴)
		//byte byte1 = (byte)System.in.read();
		//System.out.println(byte1);
		// Scanner 의 역할 : 표준 입력으로 받은 byte의 형식 데이터를 char형으로 전환...!
		Scanner scanner = new Scanner(System.in);
		
		// 문자열 데이터 한번에 가져오기 (문자열 가져오는 메서드)
		//System.out.println(scanner.next());			// 공백문자(spacebar, tab, nextline)에 해당되는 데이터 전까지 문자열을 가져옴
		//System.out.println(scanner.nextLine());		// 개행문자(nextline) 에 해당되는 데이터 전까지 문자열을 가져온다.
		
		
		// 정수 하나를 입력 받아보기...!
		//int a = scanner.nextInt();
		//System.out.println("a: " + a);
		
		//float b = scanner.nextFloat();
		//double d = scanner.nextDouble();
		//boolean c = scanner.nextBoolean();
		
		// 정수형 입력 두개를 받아서 a, b변수에 할당한다..!
		//int a = scanner.nextInt();
		//int b = scanner.nextInt();
		
		// a + b를 합하여 출력해보세요..!!
		//System.out.println(a + b);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		System.out.println(c + d);
	}
}
