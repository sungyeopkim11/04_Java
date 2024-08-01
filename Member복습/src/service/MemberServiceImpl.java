package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService{

	// dao 객체 부모 참조 변수 선언
	private MemberDao dao = null;
	
	// 기본 생성자
	// - Member
	public MemberServiceImpl() throws FileNotFoundException,
	                                  ClassNotFoundException, 
	                                  IOException {
		
		
		dao = new MemberDaoImpl();
	}
	
	
	@Override
	public boolean addMember(String name, String phone) throws IOException {
		
		// 1) 회원 목록을 얻어와 휴대폰 번호 중복 검사
		List<Member> memberList = dao.getMembersList();
		
		for(Member member : memberList) {
			// 휴대폰 번호가 같은 경우 == 중복인 경우
			if(phone.equals(member.getPhone())) {
				return false;
			}
		}
		
		// 2) 중복이 아닌경우
		//    입력 받은 정보를 이용해 Member 객체를 생성하고
		//    DAO에 전달하여 파일에 저장
		Member member = new Member(name, phone, 0, Member.COMMON);
		
		// DAO 메서드 호출 후 결과 반환 받기
		boolean result = dao.addMember(member); 
		
		return false;
	}
	
}
