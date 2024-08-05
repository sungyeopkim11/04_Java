package 과연;

import java.util.Scanner;

public class Todo {

	public static void main(String[] args) {

		
		
		import java.util.ArrayList;
		import java.util.Scanner;
		import java.util.Date;
		import java.text.SimpleDateFormat;

		class Todo {
		    int id;
		    String title;
		    boolean completed;
		    String date;

		    Todo(int id, String title) {
		        this.id = id;
		        this.title = title;
		        this.completed = false;
		        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		    }

		    @Override
		    public String toString() {
		        return String.format("%d\t%s\t%s\t%s", id, date, completed ? "Yes" : "No", title);
		    }
		}

		public class TodoListApp {
		    private static ArrayList<Todo> todos = new ArrayList<>();
		    private static int currentId = 1;

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        int choice;

		        do {
		            System.out.println("1. Todo List Full View");
		            System.out.println("2. Todo Detail View");
		            System.out.println("3. Todo Add");
		            System.out.println("4. Todo Complete");
		            System.out.println("5. Todo Update");
		            System.out.println("6. Todo Delete");
		            System.out.println("0. EXIT");
		            System.out.print("select menu number >>> ");

		            choice = scanner.nextInt();
		            scanner.nextLine(); // consume newline

		            switch (choice) {
		                case 1:
		                    viewTodoList();
		                    break;
		                case 2:
		                    viewTodoDetail(scanner);
		                    break;
		                case 3:
		                    addTodoAndDisplay(scanner);
		                    break;
		                case 4:
		                    completeTodo(scanner);
		                    break;
		                case 5:
		                    updateTodo(scanner);
		                    break;
		                case 6:
		                    deleteTodo(scanner);
		                    break;
		                case 0:
		                    System.out.println("Exiting...");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Try again.");
		            }
		        } while (choice != 0);

		        scanner.close();
		    }

		    private static void viewTodoList() {
		        int completedCount = (int) todos.stream().filter(todo -> todo.completed).count();
		        System.out.printf("\n완료된 Todo 개수 / 전체 Todo 수 : %d / %d\n", completedCount, todos.size());
		        System.out.println("--------------------------------------------------------------------");
		        System.out.println("인덱스\t등록일\t\t완료여부\t할 일 제목");

		        for (Todo todo : todos) {
		            System.out.println(todo);
		        }
		        System.out.println();
		    }

		    private static void viewTodoDetail(Scanner scanner) {
		        System.out.print("Enter Todo ID to view: ");
		        int id = scanner.nextInt();
		        scanner.nextLine(); // consume newline

		        Todo todo = findTodoById(id);
		        if (todo != null) {
		            System.out.println("\nTodo Detail:");
		            System.out.println(todo);
		        } else {
		            System.out.println("Todo not found.");
		        }
		        System.out.println();
		    }

		    private static void addTodoAndDisplay(Scanner scanner) {
		        System.out.print("Enter Todo title: ");
		        String title = scanner.nextLine();

		        Todo newTodo = new Todo(currentId++, title);
		        todos.add(newTodo);
		        System.out.println("Todo added.\n");
		        viewTodoList();
		    }

		    private static void completeTodo (Scanner scanner){
		        System.out.print("Enter Todo ID to mark as complete: ");
		        int id = scanner.nextInt();
		        scanner.nextLine(); // consume newline

		        Todo todo = findTodoById(id);
		        if (todo != null) {
		            todo.completed = true;
		            System.out.println("Todo marked as complete.\n");
		        } else {
		            System.out.println("Todo not found.\n");
		        }
		    }

		    private static void updateTodo (Scanner scanner){
		        System.out.print("Enter Todo ID to update: ");
		        int id = scanner.nextInt();
		        scanner.nextLine(); // consume newline

		        Todo todo = findTodoById(id);
		        if (todo != null) {
		            System.out.print("Enter new title: ");
		            String newTitle = scanner.nextLine();
		            todo.title = newTitle;
		            System.out.println("Todo updated.\n");
		        } else {
		            System.out.println("Todo not found.\n");
		        }
		    }

		    private static void deleteTodo(Scanner scanner) {
		        System.out.print("Enter Todo ID to delete: ");
		        int id = scanner.nextInt();
		        scanner.nextLine(); // consume newline

		        Todo todo = findTodoById(id);
		        if (todo != null) {
		            todos.remove(todo);
		            System.out.println("Todo deleted.\n");
		        } else {
		            System.out.println("Todo not found.\n");
		        }
		    }

		    private static Todo findTodoById(int id) {
		        for (Todo todo : todos) {
		            if (todo.id == id) {
		                return todo;
		            }
		        }
		        return null;
		    }
		}
	}
}
