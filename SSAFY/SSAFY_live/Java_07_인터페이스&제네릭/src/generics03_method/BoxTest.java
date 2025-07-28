package generics03_method;


class Box<T> {
	private T obj;
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	//제네릭 메서드
	public <A> void printClassName(A item) {
		System.out.println(item.getClass().getName());
	}
}


public class BoxTest {
	public static void main(String[] args) {
		Box<Integer> box = new Box<>();
		
		box.printClassName("String");
		box.printClassName(12.5);
		box.<Long>printClassName(12L);
		
	}
}
