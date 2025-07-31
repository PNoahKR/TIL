package test01_File;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		//File 클래스 : 파일 & 폴더(디렉토리) 관리하기 위한 클래스
//		File file = new File("zzanggu.jpg");
		File file = new File("C:\\Users\\SSAFY\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\Java_11_파일입출력\\zzanggu.jpg");
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		
		System.out.println(file.isAbsolute()); //절대경로 아니넹..
		System.out.println(file.getAbsolutePath());
		
//		File src = new File("src");
		
		File folder = new File("folder");//이름이 폴더인 디렉토리 생성 X 메모리에만 올림
		System.out.println(folder.exists());
		folder.mkdir();
		System.out.println(folder.exists());
		
		//파일을 생성할 수 도 있고 / 폴더를 생성하고 관리할 수 도 있다.
	}

}
