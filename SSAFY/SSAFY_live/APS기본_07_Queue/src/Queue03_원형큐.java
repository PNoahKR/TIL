import java.util.Arrays;

public class Queue03_원형큐 {
	// 배열처럼 보이지만 사실 원형 큐
	public static String[] cQ = new String[5];
	public static int front = 0, rear = 0;
	
	public static void main(String[] args) {
		enQueue("이서현");
		deQueue();
		
		// 데이터가 있는 것처럼 보이지만 사실은 없는 것
		System.out.println(Arrays.toString(cQ));
		
		while(!isEmpty()) {
			System.out.println(deQueue());
		}
	}
	
	// 공백(선형큐와 동일하다!)
	public static boolean isEmpty() {
		return front == rear;
	}
	
	// 포화(rear 들어갈 다음 위치와 front가 동일하다면 포화 상태)
	public static boolean isFull() {
		return front == (rear+1) % cQ.length;
	}
	
	// 삽입
	public static void enQueue(String item) {
		if(isFull()) {
			System.out.println("가득하있따");
			// 배열의 크기를 2배로 키우고 안에 내용을 복사해서 넣어두어도 괜찮겠다?
			return;
		}
		// rear 증사 -> 순환하는 것도 고려해야함!
		cQ[(rear + 1) % cQ.length] = item;
	}
	
	
	// 삭제
	public static String deQueue() {
		if(isEmpty()) {
			System.out.println("공백 상태라 꺼낼 게 없다");
			// 배열의 크기를 좀 줄일까?
			return null;
		}
		front = (front + 1) % cQ.length;
		// 실제로 데이터를 지우는가?
		return cQ[front];
	}
}
