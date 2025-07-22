
public class OperatorTest2 {
	public static void main(String[] args) {
		
		// 논리연산자 AND(&&), OR(||)
		int score = 70;
		
		System.out.println(score > 60 && score < 90); // true
		System.out.println(score > 60 || score < 90); // true
		
		// 단락(short circuit) 평가 : 이미 평가에 대한 결과 (논리 연산)이 명백히 나왔을 때, 뒤 연산을 더 진행하지 않고 결과를 반환
		//                false(거짓)  && true/false 뒤에가 뭐가 있든 false!
		System.out.println(score > 70 && score++ < 90); // false
		System.out.println(score);
		
		// false(거짓)  || true/false 뒤에까지 평가가 되어야 한다...!
		score = 70;
		System.out.println(score > 70 || score++ < 90); // true
		System.out.println(score);
		
		// 삼항 연산자
		String message = (score >= 60) ? "통과!" : "실패!";
		System.out.println(message);
	}
}
