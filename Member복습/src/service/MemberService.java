package service;

public interface MemberService {

	// 인터페이스 메서드 
	// - public abstract method
	// - default method
	
	
	/**
	 * 전달 받은 이름, 휴대폰 번호를 이용해서 회원 추가
	 * 단, 목록에 있는 회원 중 같은 번호의 회원이 존재하면
	 * false 반환 / 없으면 가입 후 true 반환
	 * @param name
	 * @param phone
	 * @return true / false(중복된번호)
	 */
	public abstract boolean addMember(String name, String phone);

}
