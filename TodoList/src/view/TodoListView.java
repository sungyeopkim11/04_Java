package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	
	private TodoListService service = null;
	private BufferedReader br = null;
	
	// 기본 생성자
	public TodoListView() {
		
		try {
			// 객체 생성 중 발생한 예외를 view에 모아서 처리
			service = new TodoListServiceImpl();
			
			// 키보드를 입력 받기 위한 스트림 생성
			br = new BufferedReader((new InputStreamReader(System.in)));
		} catch(Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			
			e.printStackTrace();
			
			System.exit(0);
		}
	}

	// -----------------------------------------------------------------
	// [메인 메뉴]
	public void mainMenu() {
		int input = 0;
		do {
			
			try {
				//메뉴 출력 후 입력된 번호를 반환 받기
				input = selectMenu();
				
				// 선택된 메뉴 번호에 따라 case 선택
				switch(input) {
				case 1: fullView(); break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 0: System.exit(0);
				
				default : System.out.println("\n### 메뉴에 작성된 번호만 입력해 주세요\n");
				
				}
				
				System.out.println("===========================================");
				System.out.println("======");
			} catch(NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해 주세요 ###\n");
				input = -1;
			} catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
		
		
	}
	
	// ------------------------------------------------------------------
	// [메뉴 출력/ 선택 하는 메서드]
	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n===== Todo List =====\n");
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.print("select menu number >>>");
		
		int input = Integer.parseInt( br.readLine() );
		System.out.println();
		return input;
	}
	
	// ------------------------------------------------------
	// [Todo List Full View]
	public void fullView() {
		System.out.println("\n=========== [1. Todo List Full View] ==============\n");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
