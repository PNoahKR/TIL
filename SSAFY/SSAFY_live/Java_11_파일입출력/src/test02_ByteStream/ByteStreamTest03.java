package test02_ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest03 {
	public static void main(String[] args) {

		// 생성자에 file 객체를 넣던지 문자열로 경로를 넣던지
		// try with resources : 통로가 try문 끝나면 알아서 close() 호출 되도록
		try (FileInputStream fis = new FileInputStream("zzanggu.jpg");
				FileOutputStream fos = new FileOutputStream("zzanggu-copy3.jpg");) {

			int b; // byte를 담을 손
			byte[] buffer = new byte[100]; //바구니!
			while ((b = fis.read(buffer)) != -1) {
//				System.out.println(b);
				fos.write(buffer, 0, b);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음 이슈");
		} catch (IOException e) {
			System.out.println("통로 이슈");
		}
	}
}
