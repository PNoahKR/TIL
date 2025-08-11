import java.util.LinkedList;
import java.util.Queue;

public class Queue02_API {
	public static void main(String[] args) {
		// Queue 는 인터페이스
		// 따라서 구현체로 자주 사용하는 거 2가지 있음
		// 1. LinkedList
		// 2. ArrayDeque
		Queue<String> q = new LinkedList<>();
		q.add("김태희");
		q.offer("박지우");
		
		// 삭제
		q.remove(); // 공백일 때 예외발생
		q.poll();   // 공백일 때 null 반환
		
		// 조회
		q.element(); // 예외 발생
		q.peek();    // null 반환
		
		// add, remove, element : 예외를 발생시키는 조합
		// offer, poll, peek : 값을 반환하는 조합
	}
}
