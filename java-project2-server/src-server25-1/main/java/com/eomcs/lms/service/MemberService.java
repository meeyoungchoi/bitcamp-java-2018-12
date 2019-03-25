package com.eomcs.lms.service;

import java.util.List;

import com.eomcs.lms.domain.Member;

public interface MemberService {

	List<Member> list();
	int add(Member member);
	Member detail(int no);
	Member get(int no);
	int update(Member member);
	int delete(int no);
}
