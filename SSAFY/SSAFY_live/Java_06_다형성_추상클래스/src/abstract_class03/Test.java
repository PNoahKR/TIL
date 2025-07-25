package abstract_class03;

public class Test {
	public static void main(String[] args) {
		Chef[] chefs = new Chef[2];
		
		//배열을 이용하여 다음과 같이 한식/일식 요리사를 담아두었다.
		chefs[0] = new KFoodChef();
		chefs[1] = new JFoodChef();
		
		for(Chef chef : chefs) {
			chef.eat();
			chef.cook(); //한식조리, 일식조리 -> 동적 바인딩!
		}
	}
}
