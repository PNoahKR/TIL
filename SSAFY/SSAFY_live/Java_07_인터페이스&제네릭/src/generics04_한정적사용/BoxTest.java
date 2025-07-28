package generics04_한정적사용;


class Box<T extends Number> { //숫자만 사용 가능!
	private T obj;
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
}


public class BoxTest {
	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		Box<Double> box2 = new Box<>();
		//이건 안됨!
//		Box<String> box3 = new Box<>();
		
		
	}
}
