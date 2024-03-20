package edu.kh.jdbc.member.model.service;

import java.sql.Connection;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.memeber.view.List;
import edu.kh.jdbc.memeber.view.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	public List<Member> selectMemberList() {
	
		return null;
	}

	
	
	/** 회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception{
	
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, memberName, memberGender, memberNo);
		
		// 트랜잭션 처리
		if(result > 0) commit(conn);
		else            rollback(conn);
		
		close(conn);
		
		return 0;
	}

}
