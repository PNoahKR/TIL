package interface04_다형성;

public class Test {
	public static void main(String[] args) {
		KFoodChef k = new KFoodChef();
		
		k.cook();
		
		//참조타입으로 Chef 사용 가능 -> 다형성!
		Chef chef = new KFoodChef();
		
		chef.cook(); //동적바인딩
		
		//익명 클래스 문법으로 1회한정 구현 가능 -> 쓸일이 왕왕~ 있음
		Chef chef2 = new Chef() {

			@Override
			public void cook() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
