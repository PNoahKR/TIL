package com.ssafy.pjt;

import java.util.Arrays;

//딱 1개만 만들어지도록 -> 싱글턴 패턴을 적용해보자!
public class PersonManager {

	final int MAX_SIZE = 100; //상수!
	int size = 0; // 이것의 용도는?
	private Person[] arr = new Person[MAX_SIZE];

	// 1번 : 외부에서 생성하지 못하도록 막아야한다!
	private PersonManager() {

	}

	// 2번 : 외부에서 생성하지 못하니 내가 생성해서 가지고 있자!
	// 4번 : 애네도 미리 메모리에 올려두자!
	private static PersonManager manager = new PersonManager();

	// 3번 : 내가 만든 Manager를 외부에서 쓸 수 있게 해줘!(접근자)
	// 3-1번 : 그런데 외부에서 인스턴스를 만들 수는 없다! -> static 키워드를 통해 미리 메모리에 올리자
	public static PersonManager getManager() {
		return manager;
	}

	// 추가(1. void 2. 성공여부
	public void addPerson(Person p) {
		// 조건을 걸어! 우리의 최대 관리 범위를 벗어나지 않게!
		if (size < MAX_SIZE) {
			arr[size++] = p;
		} else {
			System.out.println("더 이상 사람을 관리할 수 없다!");
		}
	}

	// 조회(2가지)
	// 2-1 전체조회
	public Person[] getAll() {
		Person[] tmp = new Person[size];
		for (int i = 0; i < size; i++) {
			tmp[i] = arr[i];
		}
		return tmp;
	}
	
	
	
	// 2-2 상세조회(검새!) -> 선택지 2개!
	public Person search(String name) {
		for (int i = 0; i < size; i++) {
			Person tmp = arr[i];
			if (tmp.getName().equals(name)) {
				return tmp;
			}
		}
		System.out.println("찾을 수 없음");
		return null;
	}

	// 수정(잘 수정이 되었는지의 유무를 췤)
	public boolean update(Person p) {
		for (int i = 0; i < size; i++) {
			if(arr[i].getName().equals(p.getName())) {
				//1번째 방식 갈아끼기
				arr[i] = p;
				
				//2번째 방식 정보만 빼서 수정하기!
//				arr[i].setHungry(p.isHungry());
				return true;
			}
		}
		
		return false;
	}

	// 삭제 -> 여러개 삭제! / 1개만 삭제 할 수도 있다.
	public void remove(String name) {
		//1. 앞으로 밀착!
		
		//2. 순서가 중요치 않다면 맨 뒤에 친구 잡아다가 빈자리로 쏙 넣기
		for (int i = 0; i < size; i++) {
			if(arr[i].getName().equals(name)) {
				arr[i] = arr[size - 1];
				size--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	

}
