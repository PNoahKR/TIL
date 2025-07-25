package abstract_class02_inheritance;

public class Test {
	public static void main(String[] args) {
		Chef[] chefs = new Chef[2];
		
		//배열을 이용하여 다음과 같이 한식/일식 요리사를 담아두었다.
		chefs[0] = new KFoodChef();
		chefs[1] = new JFoodChef();
		
//		for(Chef chef : chefs) {
//			chef.eat();
//			chef.cook(); //한식조리, 일식조리 -> 동적 바인딩!
//		}
		
		//그냥 Chef는 없고! 무조건 전공이 있는 쉐프가 만들어진다!
		
		for(Chef chef : chefs) {
			chef.eat();
//			if(chef instanceof KFoodChef) {
//				KFoodChef k = (KFoodChef) chef;
//				k.cook();
//			} 
			
			if(chef instanceof KFoodChef k){
				k.cook();
			} else if(chef instanceof JFoodChef) {
				((JFoodChef) chef).cook();
			}
		}
	}
}
