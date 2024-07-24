package student.service;

import java.util.Random;

import student.dto.StudentDTO;

public class StudentService {
	
	// StudentDTO 객체를 참조하는
	// StudentDTO 참조 변수 5개 묶음 배열 생성
	// 인덱스 : 0 ~ 4
	// 각 인덱스 요소 : 초기 값 null
	private StudentDTO[] students = new StudentDTO[5];
	
	/* 기본 생성자 */ 
	public StudentService() {
		
		// 학생 객체 배열(students)에 샘플 학생 1명 추가
		
		// students[0] = StudentDTO 자료형 참조 변수
		students[0] = new StudentDTO("24001", "짱구", '남');
		// students[1],[2],[3],[4] == null
		
		// 0 ~ 100 사이 난수
		
		// 1) Math.floor( Math.random() * 101 ) == 0 ~ 100
		// 2) Random random = new Random();
		//    random.naxtInt(101); == 0 ~ 100
		
		Random random = new Random();
		
		for(StudentDTO std : students) {
			
			// 현재 접근한 요소가 참조하는 객체가 없다면
			// 반복을 종료
			if(std == null) break;
			
			// random.nextInt(101) : 0 이상 101 미만 정수형 난수
			
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
		
	}

}
