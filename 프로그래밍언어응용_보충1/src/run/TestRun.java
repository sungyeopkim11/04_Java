package run;

import java.util.HashSet;
import java.util.Set;

// 문제점 1. 이론 지식이 너무 약하다
// 문제점 2. 오류가 나면 원인을 찾아야 하는데 못 찾는다
// 문제점 3. 답안 작성 하는 방법

public class TestRun {

	public static void main(String[] args) {
		
		// 컬렉션 : 자바 자료구조 모음
		
		// List : 
		// - 인덱스가 존재해서 순서 유지
		// - 중복 데이터 저장 가능
		
		// Set  : (주머니, 집합)
		// - 순서 X
		// - 중복 저장을 못함
		
		// Map  : 
		// - K:V 한쌍으로 데이터 저장
		// - 중복 K 불가
		// - 대신 K를 이용해서 V 구분 가능 -> V 중복 O
		
		// Set 객체 생성
		Set<String> menuSet = new HashSet<String>();
		
		// set에 객체 추가
//		menuSet.add("라면");
		menuSet.add("김밥");
		menuSet.add("우동");
		menuSet.add("우동"); // 중복되서 제거됨
		menuSet.add("우동"); // 중복되서 제거됨
		
		System.out.println(menuSet);
		
		// menuSet에 라면이 있는지 검사하기
		
		// 문제 원인
		// -> 일반 for문을 이용해서 다루고 있는 i 값을 통해
		//    Set의 i번째 인덱스를 가져오려고함
		//   하지만 Set은 인덱스가 없어서 오류가 발생함
		
		// -> if문에 문자열 비교 시 비교연산자를(==)를 사용해서
		//    값이 아닌 주소를 비교하고 있음
		
		// -> 메뉴가 존재 할 때도 
		//   있음/없음 모두 출력되는 문제 발생
		//   왜? 같은 메뉴를 찾았을 경우 
		//   없음을 출력하지 못하게 하는 처리가 되어있지 않아서
		
		
//		for(int i=0 ; i<menuSet.size(); i++) {
//			
//			if(menuSet.get(i) == "라면") {
//				System.out.println("라면 없음");
//			}
//		}
//		System.out.println("라면 없음");

		
		// 해결 방법
		// -> 일반 for문 -> 향상된 for문
		// -> get() 구문 -> 하나씩 꺼내 저장한 변수명으로 변경
		// -> if문 비교 연산자를 equals()로 변경
		// -> 메뉴가 있을 경우 if문에
		//   1) return을 추가해서 프로그램 종료
		//   2) flag를 이용해 없음 구문 실행 여부를 처리
		
		boolean flag = true;
		for(String menu : menuSet) {
			
			if(menu.equals("라면")) {
				System.out.println("라면 있음");
				flag = false;
			}
		}
		// for문이 끝났을 떄 
		// 라면이 있었으면 flag == flase;
		// 라면이 있었을 때 flag == true;
		
		if(flag) System.out.println("라면 없음");
			
		
	}
}
