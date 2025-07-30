package com.ssafy.user_exception;

public class UserExceptionTest {
	public static String[] fruits = {"망고", "수박", "복숭아"};
	
	
	
	public static void main(String[] args) {
		//과일장사 ㄱㄱ
		
		try {
			sell("망고"); //요녀석 입장에서 과일이 없는데여
			sell("사과");
		} catch (FruitNotFoundRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //요녀석 입장에서 과일이 없는데여
		
		try {
			sell("사과");
		} catch (FruitNotFoundRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}



	private static boolean sell(String name) throws FruitNotFoundRuntimeException {
		// 과일 목록을 찾아서 그거 판매
		for(int i = 0; i < fruits.length; i++) {
			if(name.equals(fruits[i])) {
				//해당 라인이 수행된다는 것은 과일이 있어!
				System.out.println("판매 완료!");
				fruits[i] = null; // 나머지 앞으로 밀착 하면 좋으나 안함~
				return true;
			}
		}
		throw new FruitNotFoundRuntimeException(name);
	}

}
