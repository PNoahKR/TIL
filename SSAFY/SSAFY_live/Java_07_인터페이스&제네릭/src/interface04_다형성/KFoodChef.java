package interface04_다형성;

public class KFoodChef implements Chef{

	@Override
	public void cook() {
		System.out.println("한식을 요리한다.");
	}

}
