package com.ssafy.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("신");
		names.add("유");
		names.add("주");
		names.add("이");
		names.add("손");
		names.add("강");
		names.add("강양");
		
		System.out.println(names);
		
		Collections.sort(names);
//		Collections.reverse(names);
		System.out.println(names);
		
		int[] nums = {4,6,8,2,1,6,7};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		
		
		
	}
}
