
public class Queue01_선형큐 {
	// 배열 X -> 큐임 ㅋㅋ (크기 결정은 문제를 보고 판단)
	public static int[] queue = new int[10];
	public static int front = -1; // 데이터 삭제 위치
	public static int rear = -1; // 데이터 삽입 위치
//	public static int head = -1, tail = -1;
	
	
	
	public static void main(String[] args) {
		enQueue(10);
		enQueue(20);
		enQueue(30);
		
		while(!isEmpty()) {
			System.out.println(deQueue());
		}
		System.out.println(deQueue());
	}
	
	// 포화 쳌
	public static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	// 공백 췤
	public static boolean isEmpty() {
		return front == rear;
	}
	
	// 삽입
	public static void enQueue(int item) {
		// 포화
		if(isFull()) {
			System.out.println("가득 차 있어서 넣지 못해!");
			return;
		}
		queue[++rear] = item;
	}
	
	// 삭제
	public static int deQueue() {
		// 공백 쳌
		if(isEmpty()) {
			System.out.println("꺼낼 값이 없으요");
			return -1; // -1이라는 값이 내가 사용할 수 도 있으니 문제의 제한범위에서 사용하지 않는 수를 사용해야..
		} else {
			return queue[++front]; // 실제로 데이터를 지운 것은 아니다
		}
	}
	
	
	
	// 큐를 초기화 하는 메서드(잘 안만드는 것 같다)
	public void createQueue(int size) {
		queue = new int[size];
		front = -1;
		rear = -1;
	}
}
