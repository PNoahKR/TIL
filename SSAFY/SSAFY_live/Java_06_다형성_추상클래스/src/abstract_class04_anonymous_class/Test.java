package abstract_class04_anonymous_class;

public class Test {
	public static void main(String[] args) {
		//cook() => 추상메서드 이므로 인스턴스 생성 불가능
		//1회 한정으로 미완성인 부분을 구현해줌으로써 -> 인스턴스를 생서할 수 있게 해준다.
		Chef chef = new Chef() {

			@Override
			public void cook() {
				System.out.println("랜덤 "
						+ "요리를 합니다..!");
			}
			
		};
		

		chef.eat();
		chef.cook();
		chef.cook();
	}
}
