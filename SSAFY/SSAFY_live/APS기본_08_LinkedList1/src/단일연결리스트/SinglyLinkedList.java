package 단일연결리스트;

public class SinglyLinkedList {
	Node head; // 연결리스트 시작점(더미X)
	int size; // 사이즈 알고 있으면 쓸데가 있음

	// 아래처럼 쓸거면 사실 업성도 될지도
//	public SinglyLinkedList() {
//		this.head = null;
//		this.size = 0;
//	}
	
	// 조회
	public Node get(int idx) {
		// idx 가 정상적인지를 판단
		if(idx < 0 || idx >= size) {
			// 예외발생 시킬 수도 있음
			// idx < 0 : 그냥 0번인덱스
			// idx >= size : 마지막 인덱스
			return null;
		}
		Node curr = head;
		//curr 해당 노드를 idx 위치까지 옮기겠다
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		
		return curr;
	}

	// 노드 삽입(첫번째 위치, 마지막 위치, 중간 위치)
	// 노드 데이터가 String 이라서 data도 해당 문자열을 넘기게 만들었다
	// Node 자체를 파라미터로 넘겨도 될 것 같다.
	public void addFirst(String data) {
		// 1. Node 생성
		Node node = new Node(data);
		// 2. Node의 링크는 head를 저장한다.
		node.link = head;
		// 3. head를 새로 만든 node로 바꾼다!
		head = node;
		size++;
	}

	// 가장 마지막 위치에 넣을거야!
	public void addLast(String data) {
		if (size == 0) {
			addFirst(data);
			return;
		}
		// 1. Node 생성
		Node node = new Node(data);
		// 2. 마지막 노드를 찾아 가지고 있어야 한다! (size 만큼 이동하면 된다!)
		Node curr = head; // curr 첫번째 노드
		
		while(curr.link != null) {
			curr = curr.link;
		}
		// curr : 마지막 노드에 위치하게 되어 있음!
		curr.link = node;
		size++;
	}
	
	// 중간 위치 삽입
	public void add(int idx, String data) {
		if(idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else if(idx < 0 || idx > size) {
			// 커스텀의 묘미
			// 음수면 가장 앞에 넣어야지..?
			// 사이즈를 벗어나느 수라면 그냥 마지막에 넣어야징
			// 아무것도 하지 말아야지~ 예외처리?
		} else {
			// idx위치에 넣고 싶다.
			// idx-1 위치에 있는 노드가 필요
//			Node pre = for문으로 작성할 것
			Node pre = get(idx - 1);
			
			// 새로운 노드 생성
			Node node = new Node(data);
			
			// 순서가 중요하다.
			node.link = pre.link;
			pre.link = node;
			
			
		}
	}
	
	// 조회
	public void printList() {
		Node curr = head;
		
		if(head == null) {
			System.out.println("공백 리스트");
			return;
		}
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}

	// 삭제 (첫번째위치, 마지막위치, 중간위치)
	public String removeFirst() {
		// 예외상황 발생도 가능
		if(head == null) {
			return null;
		}
		
		// 더미 head : head.link.data;
		String data  = head.data;
		head = head.link;
		size--;
		return data;
	}
	
	// 중간 위치
	public String remove (int idx) {
		if(idx == 0) {
			return removeFirst();
		}
		
		//범위를 벗어나면..
		if(idx < 0 || idx >= size) {
			return null;
		}
		
		Node pre = get(idx-1); // 이전 노드 가져오기
		Node rm = pre.link; // 삭제하고 싶은 위치의 노드
		
		// 지우고 싶은 데이터
		String data = rm.data;
		size--;
		return data;
		
	}
	
	// 마지막 위치 삭제 -> 중간 위치 삭제에 마지막 인덱스를 넣으면 되는 부분임으로 과감하게 생략~
}
