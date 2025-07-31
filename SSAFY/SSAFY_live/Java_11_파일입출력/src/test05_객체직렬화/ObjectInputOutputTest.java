package test05_객체직렬화;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputTest {
	public static void main(String[] args) {
		Person p = new Person("Kim", 40);
		
		//List, Array 객체니까 가능하다!

		// 실제로 파일로 저장을 해보자!
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));){
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 실제로 파일을 읽어서 객체로 바꾸어보자!
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));) {
			Object obj = ois.readObject();
			System.out.println(obj); // 동적바인딩에 의해 Person의 toString이 동작을 한것이다!!
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
