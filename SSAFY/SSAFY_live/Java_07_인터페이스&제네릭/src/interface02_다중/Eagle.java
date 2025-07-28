package interface02_다중;

public class Eagle implements Bird {

	// 구현의 강제성 부여!
	@Override
	public void swim() {
		System.out.println("물속 사냥을 한다.");
		
	}

	@Override
	public void fly() {
		System.out.println("날아다닌다.");
	}

	@Override
	public void eat() {
		System.out.println("먹는다!");
	}

}
