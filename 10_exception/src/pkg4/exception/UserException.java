package pkg4.exception;

import java.util.StringJoiner;

/**
 * 사용자 정의 예외
 * - Java에서 제공하지 않는 사용자만의 예외를
 *   만들어 사용할 수 있다
 *   
 *  [만드는 방법]
 *  - 아무 Exception이나 상속 받으면 완성
 *    (내부 코드는 필요한대로 작성)
 *    
 * * Unchecked Exception을 만들고 싶으면
 *   RuntimeException 또는 그 자식을 상속 받아라!!
 */
public class UserException extends Exception{

	public UserException() { // 기본 생성자
		
		super("[사용자 정의 예외 발생]"); // 부모 생성자
		// -> 예외 객체 생성 시 보여질 기본 메시지
	}
	
	
	public UserException(String message) { // 매개 변수 생성자
		super(message);
	}
}
