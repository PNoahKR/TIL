
public class IOStreamTest {
	public static void main(String[] args) {
		// 출력 스트림 System.in 메서드들...
		// 1. println 메서드 : 입력값을 화면 내에 출력해주는 메서드 (줄바꿈 있음)
		System.out.println("안녕하세요. 좋은 오후입니다.");
		System.out.println("날이 너무 덥죠? ^^;;");
		System.out.println("");
		// 2. print   메서드 :             //             ( //  x )
		System.out.print("안녕하세요. 좋은 오후입니다.");
		System.out.print("날이 너무 덥죠? ^^;;");
		System.out.print("\n");
		// 3. printf  메서드 : 우리가 원하는 서식을 지정해서 출력
		// *특수문자를 통해서 개행(\n)을 추가를 넣을 수 있다.
		System.out.printf("원하는 데이터 출력: %d \n", 100);
		System.out.printf("원하는 데이터 출력: %c \n", 97);
		
//				System.out.printf("원하는 데이터 출력: %d \n", 'A');
		System.out.printf("원하는 데이터 출력: %c \n", 'a');
		
		System.out.println('a' == 97); // true? false?
		
//				'7' 입력을 받았다... 값을 출력하라...!
		char ch2 = '7'; 
		int digit = ch2 - 48; // '0';
		System.out.println(digit);
		
		// 'd' -> 100 정수
		// 정수, 실수형에 대한 연산 결과 예측하기...
		System.out.println('d' + 0 + 'd'); // ??
		System.out.println(100 + 1.0); // ??
		System.out.println(100 / 3.0); // ??
		System.out.println(0.1 + 0.2);
		System.out.println(0.3);
		System.out.println(0.1 + 0.2 == 0.3); // ??
		System.out.println( 0.299999999999 < (0.1 + 0.2) && (0.1 + 0.2) <= 0.300000001);
		System.out.println(100 / 3);   // ??
		System.out.println('d' / 3);   // ??
		
		// 문자열과의 연산 (암묵적 형변환)
		System.out.println("1000" + 123);          // "1000123"
		System.out.println('d' + 100 + "300");      // "200300"
		System.out.println('7' + 7 + "7");          // "627"
		System.out.println("7" + 7 + '7');          // "777"
		System.out.println(true + "1" + 1);         // "ture11"
//				System.out.println(true + 1 + "1");
		
		
		System.out.println((int) 3.14); // 명시적으로 정수형 형변환!
		
		// 문자열인 경우...!
		System.out.println(Integer.parseInt("1234")); // 정수형으로 바꾸고 싶다...???
		System.out.println(Float.parseFloat("3.14")); // 실수형으로 변환 가능...!
		System.out.println(Boolean.parseBoolean("true")); // boolean(참, 거짓)으로 변환 가능...!
		
		
		
	}
}

