package student.view;

import java.util.Scanner;

import student.service.StudentService;



// 콘솔창에 보여지는 용도
// == 클라이언트의 입력/출력을 담당하는 클래스
public class StudentView {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	/**
	 * 메인 메뉴 출력
	 */
	public void mainMenu() {
		
		int input = 0; // 입력 받은 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			
			System.out.println("0. 종료");
			System.out.println("메뉴 선택 >>");
			
			input = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			
			switch(input) {
			case 1: addStudent(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
			
			case 0: System.out.println("***프로그램 종료***"); ;break;
			default: System.out.println("***메뉴 번호 잘못 입력***");
			}
			
			
		} while(input != 0);
	}
	
	/**
	 * 학생 추가 화면 
	 * 
	 * 학번, 이름, 성별을 입력 받아
	 * Student 객체로 만들어서
	 * StudentService로 전달
	 * -> 추가 성공 시 true / 실패 시 false 반환 받아
	 *    결과 출력
	 */
	private void addStudent() {
		
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.print("학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		
		
		
		
		
	}

}
