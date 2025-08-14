import java.util.PriorityQueue;

public class Heap02_PriorityQueue {
	public static void main(String[] args) {
		
		// 컬렉션 프레임워크에서 사용할 수 있게 이미 구현이 되어 있다.
		// 최소힙이 기본
		// 생성할때 비교기준을 넣어주면 최대힙도 가능하겠다!
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 부호를 반대로 바꾸어서 넣~자!
		pq.add(-10);
		pq.add(-20);
		pq.add(-15);
		pq.add(-30);
		pq.add(-25);
		
		System.out.println(pq);
		// 부호를 바꿨다면 원상복구해서 뽑아줘야함
		System.out.println(-pq.poll());
	}
}
