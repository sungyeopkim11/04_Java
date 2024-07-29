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
			System.out.println("4. 가격으로 조회");
			System.out.println("5. 카페 추가");
			System.out.println("6. 카페 삭제");
			System.out.println("0. 종료");
			
			System.out.println();
			
			System.out.print("메뉴 선택 >>");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 엔터 제거
			
			System.out.println();
			
			switch(input){
			case 1: selectAll(); break;
			case 2: selectIndex(); break;
			case 3: selectStore(); break;
			case 4: selectPrice(); break;
			case 5: addCafe(); break;
			case 6: removeCafe(); break;
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
	
	/**
	 * 입력 받은 index번째 CafeDTO를 반환 받아와 출력
	 */
	private void selectIndex() {
		System.out.println("\n***** index로 조회 *****\n");
		System.out.print("조회할 카페의 index 번호 입력 : ");
		int index = sc.nextInt();
		
		CafeDTO cafe = service.selectIndex(index);
		
		if(cafe == null) {
			System.out.println("----- 인덱스 번호를 잘못 입력 하셨습니다 -----");
			return;
		}
		
		System.out.println("제목 :" + cafe.getStore());
		System.out.println("제목 :" + cafe.getCoffee());
		System.out.println("제목 :" + cafe.getPrice() + "원");
	}
	
	/**
	 * 입력받은 카페 이름이 포함된 카페 출력하기
	 * 단, 없으면 "조회결과가 없습니다" 출력하기
	 */
	private void selectStore() {
		System.out.println("\n***** 카페 이름으로 검색 *****\n");
		System.out.print("검색할 카페 이름 입력");
		String store = sc.nextLine();
		
		List<CafeDTO> searchList = service.selectStore(store);
		
		if(searchList.isEmpty()) {
			System.out.println("조회 결과가 없습니다");
			return;
		}
		for(CafeDTO storeName : searchList) {
			System.out.println(storeName);
		}
	}
	
	
	private void selectPrice() {
		System.out.println("\n***** 가격으로 조회 *****\n");
		
		System.out.print("커피의 최소값 입력 :");
		int min = sc.nextInt();
		
		System.out.print("커피의 최대값 입력 :");
		int max = sc.nextInt();
		
		List<CafeDTO> searchList = service.selectPrice(min, max);
		if(searchList.isEmpty()) {
			System.out.println("조회결과가 없습니다");
			return;
		}
		
		for(CafeDTO storename : searchList ) {
			System.out.println(storename);
		}
	}
	
	
	private void addCafe() {
		System.out.println("\n***** 카페 추가 *****\n");
		
		System.out.print("카페 : ");
		String store = sc.nextLine();
		
		System.out.print("커피 : ");
		String coffee = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		
		CafeDTO newCafe = new CafeDTO(store, coffee, price);
		
		boolean result = service.addCafe(newCafe);
		
		if(result) {
			System.out.println("***** 추가 완료 *****");
		} else {
			System.out.println("***** 추가 중 문제 발생 *****");
		}
	}
	
	
	private void removeCafe() {
		System.out.println("\n***** 카페 삭제 *****\n");
		
		System.out.print("제거할 카페의 index 번호 :");
		int index = sc.nextInt();
		
		String result = service.removeCafe(index);
		
		if(result == null) {
			System.out.println("해당 인덱스 책이 존재하지 않습니다");
			return;
		}
		System.out.printf("[%s] 카페가 목록에서 제거 되었습니다 ", result);
	}
		
		
	

}
