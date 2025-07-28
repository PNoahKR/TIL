package generics05_와일드카드;

import java.util.List;

class Box<T> {
	private T obj;
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public void getList(List<? extends Number> list) {
		System.out.println(list);
	}
	
}

class Parent {
	
}

class Person extends Parent {
	
}


public class BoxTest {
	public static void main(String[] args) {
		Box<?> box1 = new Box<Integer>();
		//Integer를 포함한 상속받고 있는 클래스들만 사용 가능
		Box<? extends Integer> box2 = new Box<>();
		//Double을 포함한 상위 클래스들만 가능
		Box<? super Double> box3 = new Box<>();
	}
}
