package dao;

import java.io.IOException;
import java.util.List;

import dto.Member;

public interface MemberDao {

	// 인터페이스 메서드는
	// 암묵적으로 public abstract다
	
	
	
	
	/**
	 * DAO 객체가 가지고 있는 memberList 반환
	 * @return MemberList
	 */	
	List<Member> getMembersList();
	
	
	/**
	 * 회원 추가
	 * @param member
	 * @return true
	 * @throws IOException
	 */
	boolean addMember(Member member) throws IOException;




	
}
