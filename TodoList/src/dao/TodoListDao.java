package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListDao {
	
	void saveFile() throws FileNotFoundException, IOException;

	List<Todo> todoListFullView();

	

}
