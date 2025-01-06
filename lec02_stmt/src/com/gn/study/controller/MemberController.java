package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	
	
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	// 내가 만든 회원 아이디
	public List<Member> selectId(String id){
		List<Member> list = new MemberDao().selectId(id);
		return list;
	}
	
	//수업때 만든 아이디
	public Member searchMemberOneById(String memberId) {
//		Member m = new MemberDao().searchMemberOneById(memberId);
//		return m;
		return new MemberDao().searchMemberOneById(memberId);
	}
	
	public List<Member> searchMemberNameAnalogy(String NameAnalogy) {
		List<Member> list = new MemberDao().searchMemberNameAnalogy(NameAnalogy);
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
	
	public List<Member> selectMemberOneByIdAndPw(String memberId, String memberPw) {
		List<Member> list = new MemberDao().selectMemberOneByIdAndPw(memberId,memberPw); 
		return list;
	}
	public int updateMemberInfo(String memberId, String memberPw,String memberName, String memberPhone, String memberEmail){
		
		int result = new MemberDao().updateMemberInfo(memberId,memberPw,memberName,memberPhone,memberEmail);
		return result;
	}
	public int deleteMember(String memberId, String memberPw) {
		int result = new MemberDao().deleteMember(memberId,memberPw);
		return result;
	}
	
}
