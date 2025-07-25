package abstract_class02_inheritance;

public class JFoodChef extends Chef{
	String speciality; //주전공
	
//	@Override
	public void cook() {
		System.out.println("한식을 조리한다.");
	}
}
