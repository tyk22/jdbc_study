package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	public List<Member> selectId(String id){
		List<Member> list = new MemberDao().selectId(id);
		return list;
	}
	
	public int insertMember(String memberId, String memberPw, String memberName
			,String memberEmail ,String memberPhone, String memberGender) {
		Member m = new Member(memberId,memberPw,memberName,memberEmail,memberPhone,memberGender);
		
		int result = new MemberDao().insertMember(m);
//		if(result>0) {
//			// 성공
//		}else {
//			// 실패
//		}
		return result;
	}
	
	
	
}
