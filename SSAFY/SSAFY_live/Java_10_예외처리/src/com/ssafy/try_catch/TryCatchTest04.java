package com.ssafy.try_catch;

//다중처리
public class TryCatchTest04 {
	public static void main(String[] args) {
		int[] nums = { 10 }; // 선언과 동시에 초기화할 때만 가능

		try {
			System.out.println("1");
			System.out.println(nums[10]);
			System.out.println("2");
//			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("3");
			return;
		} finally {
			// 중간에 return 이 존재하더라도 얘는 실행한다.
			System.out.println("4");
		}
		
		System.out.println("5");
	}
}
