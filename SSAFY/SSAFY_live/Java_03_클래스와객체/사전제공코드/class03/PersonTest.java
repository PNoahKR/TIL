package class03;

public class PersonTest {
	public static void main(String[] args) {
		//Yang을 생성!
		//클래스이름 변수이름 = new 클래스이름();
		Person yang = new Person();
		
		yang.name = "Yang";
		yang.age = 45;
		yang.hobby = "Youtube";
		
				
		Person park = new Person();
		
		park.name = "Park";
		park.age = 29;
		park.hobby = "Baseball";
		
//		yang.info();
//		park.info();
		
		//아래에 전달된 값을 인자라고 한다.
		yang.study(10);
		park.study(100);
		
		
	
	}
	

}
