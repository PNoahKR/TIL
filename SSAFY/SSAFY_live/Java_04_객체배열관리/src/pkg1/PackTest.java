package pkg1;

import pkg1.pkg2.pkg3.Pack;
//import pkg1.pkg2.Pack;

public class PackTest {
	public static void main(String[] args) {
		pkg1.pkg2.Pack p = new pkg1.pkg2.Pack();
		System.out.println(p.pkg);
		
		Pack p2 = new Pack();
		System.out.println(p2.pkg);
	}

}
