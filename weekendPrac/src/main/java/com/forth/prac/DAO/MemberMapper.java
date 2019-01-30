package com.forth.prac.DAO;

import com.forth.prac.VO.Member;

public interface MemberMapper {
	public int touroku(Member mem);
	public Member login(Member mem);
}
