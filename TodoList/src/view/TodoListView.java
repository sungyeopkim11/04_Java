package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import dto.Todo;
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
	public void startView() {
		int input = 0;
		do {
			
			try {
				//메뉴 출력 후 입력된 번호를 반환 받기
				input = selectMenu();
				
				// 선택된 메뉴 번호에 따라 case 선택
				switch(input) {
				case 1: todoListFullView(); break;
				case 2: todoDetailView(); break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 0: System.out.println("@@프로그램 종료@@");
				        br.close();
				
				default : System.out.println("\n### 메뉴에 작성된 번호만 입력해 주세요\n");
				
				}
				
				System.out.println("===========================================");
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
		
		try {
			if(br != null) br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
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
	//=====================================================================
	
	/**
	 * 할 일 목록 모두 보기
	 */
	public void todoListFullView() {
		
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		
		Map<String, Object> map = service.todoListFullView();
		
		List<Todo> todoList = (List<Todo>)map.get("todoList");
		int completeCount = (int)map.get("completeCount");
		
		System.out.printf("[완료된 Todo 개수 / 전체 Todo 수 : %d / %d]\n",
				completeCount,todoList.size());
		
		System.out.println("-----------------------------------------------------");
		System.out.printf("%-3s %10s %10s %s\n", "인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("-------------------------------------------------------");
		
		for(int i=0, len = todoList.size(); i < len ; i++) {
			String title = todoList.get(i).getTitle();
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";
			String regDate = service.dateFormat(todoList.get(i).getRegDate());
			System.out.printf("[%3d] %20s (%s) %s\n",
					i, regDate, completeYN, title);
		}
	}
	// ------------------------------------------------------------------------
	
	/**
	 * 할 일 상세 조회
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoDetailView() throws NumberFormatException, IOException {
		
		System.out.println("\n========[2. todoDetailView] ====================\n");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		String todoDetail = service.todoDetailView(index);
		
		if(todoDetail == null) {
			System.out.println("--- 입력한 인덱스 번호에 할 일(Todo)가 존재하지 않습니다 ---");
			return;
		}
		
		System.out.println(todoDetail);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
