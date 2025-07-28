package generics01_nomal_box;

// 아무것나 넣을 수 있는 만능 박스
class Box {
	private Object obj;
	
	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
}

public class BoxTest {
	public static void main(String[] args) {
		
		Box box = new Box();//아무거나 넣을 수 있음!
		box.setObj("문자열");
		System.out.println(box.getObj()); //애는 Object
		
		box.setObj(1000);
		System.out.println(box.getObj()); //애도 Object
		
		if(box.getObj() instanceof String st) {
			System.out.println(st);
		} else if (box.getObj() instanceof Double d) {
			System.out.println(d);
		}
		
		
	}
}
