package student;

import java.util.ArrayList;

public class Student {
	
//	private ArrayList<Student> list = new ArrayList<Student>();
	
	private String name;
	private int score;
	
	public Student() {
//		ArrayList.add(new Student("강건강", 84));
//		list.add(new Student("강건강", 84));
//		list.add(new Student("강건강", 84));
//		list.add(new Student("강건강", 84));
		
	}
	
	

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}



//	public String getName() {
//		
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public int getScore() {
//		return score;
//	}
//	
//	public void setScore(int score) {
//		this.score = score;
//	}
	
	@Override
	public String toString() {
		return name + " " + "학생의 점수" + " " + score + "점";
	}

}
