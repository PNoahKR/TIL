package 오프라인_수업;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		// File 클래스 : 파일 또는 디렉토리를 관리하기 위한 클래스
		File f = new File("cat.jpg"); // 상대 경로
		System.out.println(f.exists()); // 파일이 존재하면 true (아니면 false)
		
		System.out.println(f.isFile()); // 파일 입니까?
		System.out.println(f.isDirectory()); // 디렉토리 입니까?
		System.out.println(f.isAbsolute()); // 절대경로 입니까?
		System.out.println(f.getAbsolutePath()); // 절대경로 반환
		
		
		System.out.println("==============================================================");
		File bin = new File("bin");
		
		System.out.println(bin.isDirectory());
		System.out.println(bin.exists());
		
		System.out.println("==============================================================");
		// 없는 폴더를 지정
		File folder = new File("static/2025/07/31"); // 현업에서도 이럼 -> 검색, 색인 속도 향상을 위해
		System.out.println(folder.exists());
		
		// 폴더 생성 mkdir vs mkdirs
//		System.out.println(folder.mkdir()); // 부모 디렉토리가 있는 경우에만 생성
		System.out.println(folder.mkdirs());
	}
}
