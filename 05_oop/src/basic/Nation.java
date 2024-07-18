package basic;

// 클래스(class)
// - 객체가 가져야할 속성(값), 기능(메서드)를
//   글(코드)로 작성해둔 문서
//   -> 객체를 정의한 문서
// - 클래스는 객체를 만들 때 설계도로 사용된다.



/**
 * 국민 개체를 정의한 클래스
 *  == 국민이라는 객체를 만들기 위한 설계도
 */
public class Nation {
	
	/* 속성 */
	// - 국민이라면 모두 가지고있을 공통적인 속성만 작성
	String name;
	int age;
	char gender;
	String juminNumber;
	String tel;
	String addrees;

	/* 기능 */
	public void speakKorean() {
		System.out.println("한국어 가능");
	}
	
	public void 납세의의무() {
		
		// 19세 이상만 세금 납부 대상자
		if(age >= 19) {
			System.out.printf("%s 님은 세금 납부 대상자 입니다.", name);
		} else {
			System.out.printf("%s 님은 세금 납부 대상자 아닙니다.", name);
		}
		
		
			
	}
	
	public void introduce() {
		System.out.printf("이름은 %s이고, %d세 %c성 입니다\n", 
											name, age, gender);
	}
	
}
