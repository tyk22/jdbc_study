package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
	private int memberno;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberGender;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public Member() {
	
	}
	public Member(int memberno,String memberId, String memberPw) {
		this.memberno=memberno;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.regDate = LocalDateTime.now();
		this.modDate = LocalDateTime.now();
	}
	public Member(String memberId, String memberPw, String memberName, String memberEmail,
			String memberPhone, String memberGender) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
	}
	public Member(String memberId, String memberPw) {
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	public Member(int memberno, String memberId, String memberPw, String memberName, String memberEmail,
			String memberPhone, String memberGender, LocalDateTime regDate, LocalDateTime modDate) {
		this.memberno = memberno;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	public Member(String memberName, String memberPhone, String memberEmail) {
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDateTime getModDate() {
		return modDate;
	}
	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return "회원 [번호=" + memberno 
				+ ", 아이디=" + memberId 
				+ ", 비밀번호=" + memberPw 
				+ ", 이름="+ memberName 
				+ ", 이메일=" + memberEmail 
				+ ", 전화번호=" + memberPhone 
				+ ", 성별="+ memberGender 
				+ ", 가입일=" + dtf.format(regDate) 
				+ ", 수정일=" + dtf.format(modDate) + "]";
	}
	
	
	
	
	
	
	
	
	
}
