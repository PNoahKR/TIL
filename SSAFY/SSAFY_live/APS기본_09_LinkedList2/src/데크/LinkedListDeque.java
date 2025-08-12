package 데크;

public class LinkedListDeque<T> {
	private class Node {
		T data;
		Node prev;
		Node next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node front;
	private Node rear;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(T item) {
		Node node = new Node(item);
		// 공백인지 아닌지 쳌
		if (isEmpty()) {
			front = rear = node;
		} else {
			node.next = front;
			front.prev = node;
			front = node;
		}
		size++;
	}

	public void addLast(T item) {
		Node node = new Node(item);
		if (isEmpty()) {
			front = rear = node;
		} else {
			rear.next = node;
			node.prev = rear;
			rear = node;
		}
		size++;
	}

	public T removeFirst() {
		if (isEmpty())
			return null;
		T data = front.data;
		if (size == 1)
			front = rear = null;
		else {
			front = front.next;
			front.prev = null;
		}
		size--;
		return data;
	}

	public T removeLast() {
		if (isEmpty()) {
			return null;
		}

		T data = rear.data;
		if (size == 1)
			front = rear = null;
		else {
			rear = rear.prev;
			rear.next = null;
		}
		size--;
		return data;
	}
	
	public T peekFirst() {
		if(isEmpty())
			return null;
		return front.data;
	}
	public T peekLast() {
		if(isEmpty())
			return null;
		return rear.data;
	}
}
