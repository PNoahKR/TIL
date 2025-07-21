
public class OperatorTest1 {
	public static void main(String[] args) {
		// 비교 연산자
		System.out.println(3 < 5); // true
		System.out.println(3 > 5); // false

		
		System.out.println(3 <= 5); // true
		System.out.println(3 >= 5); // false (3 > 5 || 3 == 5)
		System.out.println(4 >= 4); // true
		
		// 동등 연산자
		System.out.println(3 == 3); // ture
		System.out.println('a' == 97); // ture
		System.out.println(0 == 0.0); // ture
		// System.out.println("1234" == 1234); // complie Error
		
		System.out.println("hello" instanceof String); // true
		System.out.println("hello" instanceof Object); // true
		// 모든 참조형은 Object 하위..
		//System.out.println(123 instanceof int); // Error (기본타임은 객체가 아니다)
		
		// 문자열에 대한 동등 연산
		// 참조형 타입의 값들은 주소값을 비교한다 "==" 동등연산자를 썼을 때
		String str1 = "hello";
		String str2 = "hello";
		System.out.println("hello" == "hello"); // true?? 
		//JVM으로 최적화하는 코드가 있는데 String Pool에 상수로 선언해서 두번 선언되지 않게 최적화해줌;
		System.out.println(str1 == str2); // true??
		System.out.println(str1 == "hello"); // true??
		
		String str3 = new String("hello");
		System.out.println(str1 == str3); // false
		
		System.out.println(str1.equals(str3)); // true (equals 메서드는 값이 동일한지 비교)
	}
}
