package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService {
	
	private TodoListDao dao = null;
	
	public TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		dao = new TodoListDaoImpl();
	}

@Override
public Map<String, Object> todoListFullView() {
	
	// 할 일 목록 가져오기
	List<Todo> todoList = dao.todoListFullView();
	
	// 완료된 할 일 개수 카운트
	int completeCount = 0;
	
	for(Todo todo : todoList) {
		if(todo.isComplete()) {
			completeCount++;
		}
	}
	
	// 메서드에서 반환은 하나의 값 또는 객체 밖에 할 수 없기 때문에
	// Map이라는 컬렉션을 이용해 여러 값을 한 번에 담아서 반환
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("todoList", todoList);
	map.put("completeCount", completeCount);
	
	
	return map;
}

@Override
public String dateFormat(LocalDateTime regDate) {
	
	// 날짜와 시간을 원하는 포멧으로 출력하기
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDateTime = regDate.format(formatter);
	
	return formattedDateTime;
}
	
}

