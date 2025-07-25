package abstract_class03;

public class KFoodChef extends Chef {
	String speciality; //주전공
	
	@Override
	public void cook() {
		System.out.println("일식을 조리한다.");
	}
}
