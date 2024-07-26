package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.CafeDTO;
import list.service.CafeService;

// view : 사용자에게 보여지는 부분(출력, 입력)
public class CafeView {
	private Scanner sc = new Scanner(System.in);
	private CafeService service = new CafeService();
	
	
	/**
	 * 사용자에게 보여질 메인 화면
	 */
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n***** 카페 검색 프로그램 *****\n");
			
			System.out.println("1. 전체조회");
			System.out.println("2. index로 조회");
			System.out.println("3. 카페이름으로 조회");
			System.out.println("4. 카페 추가");
			System.out.println("5. 카페 삭제");
			System.out.println("6. 커피 가격 수정");
			System.out.println("0. 종료");
			
			System.out.println();
			
			System.out.print("메뉴 선택 >>");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 엔터 제거
			
			System.out.println();
			
			switch(input){
			case 1: selectAll(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 0: System.out.println("***** 프로그램 종료 *****"); break;
			default: System.out.println("-=-= 잘못 입력 -=-=");
			}
			
		} while(input != 0);
	} // mainMenu 메서드 종료
	
	/**
	 * 전체조회
	 * - CafeService에 있는 cafeList를 얻어와
	 *   존재하는 모든 요소의 정보를 출력
	 */
	private void selectAll() {
		System.out.println("\n***** 전체조회 *****\n");
		
		List<CafeDTO> cafeList = service.selectAll();
		
		for(CafeDTO cafe : cafeList) {
			System.out.println(cafe);
		}
	}
		
		
	

}
