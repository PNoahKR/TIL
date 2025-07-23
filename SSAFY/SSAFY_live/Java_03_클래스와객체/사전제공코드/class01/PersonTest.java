package class01;

public class PersonTest {
	public static void main(String[] args) {
		//사람의 정보를 관리하자!
		
		String name1 = "Yang";
		int age1 = 45;
		String hobby1 = "Youtube";
		
		String name2 = "Park";
		int age2 = 29;
		String hobby2 = "Baseball";
		
		//만약 사람이 100명이라면..
		
		//배열!
		int size = 100;
		String[] names = new String[size];
		int[] ages = new int[size];
		String[] hobbies = new String[size];
		
		names[0] = "Yang";
		names[1] = "Park";
		ages[0] = 45;
		ages[1] = 29;
		hobbies[0] = "Youtube";
		hobbies[1] = "Baseball";
	}

}
