package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import dto.Todo;

public interface TodoListService {

	Map<String, Object> todoListFullView();

	String dateFormat(LocalDateTime regDate);

	String todoDetailView(int index);

	
}
