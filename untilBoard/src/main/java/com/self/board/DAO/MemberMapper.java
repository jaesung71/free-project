package com.self.board.DAO;

import com.self.board.VO.Member;

public interface MemberMapper {
	public int insertMember(Member m);
	public Member loginMember(Member m);
}
