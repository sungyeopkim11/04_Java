package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao {
	
	private final String FILE_PATH = "TodoList.dat";
	
	private List<Todo> todoList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream  ois = null;
	
	
	// 기본 생성자
	public TodoListDaoImpl() throws IOException, ClassNotFoundException {
		
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			todoList = new ArrayList<Todo>();
		
		} else {
			try {
				// 객체 생성 시 외부 파일에 작성된 List<Todo> 객체를 입력 받아 todoList에 대입
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				todoList = (ArrayList<Todo>)ois.readObject();
			
			} finally {
				if(ois!=null) ois.close();
			}
		}
	}
	
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		// 예외는 throws를 던져 버리기 때문에 catch문 불필요
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(todoList);
		} finally {
			oos.close(); // 예외 발생 여부 관계 없이 무조건 닫기
		}
		
	}
	
	@Override
	public List<Todo> todoListFullView() {
		
		return todoList;
	}
	
	
}
