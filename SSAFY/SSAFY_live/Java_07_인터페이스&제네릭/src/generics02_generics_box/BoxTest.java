package generics02_generics_box;


class Box<T> {
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
//		Box box1 = new Box(); //Object -> Raw타입 (비권장)
//		Box<Object> box2 = new Box<Object>();
		
		Box<String> stringBox = new Box<>(); //생성자 쪽 꺽쇠 안은 생략해도 됨(O)
//		Box<> stringBox = new Box<String>(); //선언 쪽 꺽쇠 안은 생략하면 안됨(X)
		
		stringBox.setObj("안녕하세요!");
		System.out.println(stringBox.getObj());
		
		////////////////////////////////////////////////
		//정수형을 넣고 싶어!
		//기초자료형은 넣을 수 없음!
//		Box<int> intBox = new Box<>();
		//참조자료형을 넣어야 함!
		Box<Integer> intBox = new Box<>();
		
		//기초자료형 -> 참조자료형 Wrapper 클래스
		//int -> Integer
		//char -> Character
		//boolean -> Boolean
		// ...
		
		int i1 = 11;	 //객체 X
		Integer i2 = 11; //객체 O : AutoBoxing
		
		Integer i3 = Integer.valueOf(11); //객체 O -> Boxing
		
		int i4 = i3; //객체 X : AutoUnBoxing
		int i5 = i3.intValue(); //객체X : UnBoxing
		
		
		
		
	}
}
