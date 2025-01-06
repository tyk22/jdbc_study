package com.gn.study.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// View : 사용자와의 상호작용
	public void mainMenu() {
		System.out.println("환영합니다!!");
		// 사용자에게 정보 입력받아서
		// Controller에게 전달
		while(true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1 : createMember();break; 
			case 2 : selectMemberAll();break;
			case 3 : searchMemberOneById();break;
			case 4 : searchMemberNameAnalogy();break;
			case 5 : updateMember();break;
			case 6 : deleteMember();break;
			case 0 : System.out.println("잘가요~안녕~");return;
			
			default : System.out.println("잘못된 번호입니다.");break;
			}
		}
	}
	
	// 1. 회원 추가 화면
	public void createMember() {
		System.out.println("=== 회원 정보 추가 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		System.out.print("성별 : ");
		String memberGender = sc.nextLine();
		
		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		
		if(result > 0) {
			System.out.println("성공 !!");
		}else {
			System.out.println("실패. . ");
		}
	}
	// 2. 전체 회원 조회
	public void selectMemberAll() {
		System.out.println("=-=회원 전체 조회=-=");
		
		List<Member> list = mc.selectMemberAll();
		// (1) 만약에 list가 비어있다면 > 조회된 결과가 없습니다
		// (2) Member 목록 출력
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
	}
	// 3. 아이디로 회원 조회
	public void idSearch() {
		System.out.print("회원 아이디 :");
		String id = sc.next();
		List<Member> list = mc.selectId(id);
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다");
		}else {
			for(Member m :list) {
				System.out.println(m);
			}
		}
	}
	//수업때 만든 회원 조회
	public void searchMemberOneById() {
		System.out.println("===회원 아이디 검색===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		Member m = mc.searchMemberOneById(id);
		if(m!=null) {
			System.out.print(m);
		}else {
			System.out.println(id+"는 존재하지 않는 정보입니다.");
		}
	}
	// 4. 회원 이름으로 키워드 검색
	public void searchMemberNameAnalogy() {
		System.out.println("===회원 이름으로 키워드 검색===");
		System.out.print("키워드 : ");
		String NameAnalogy = sc.nextLine();
		List<Member> list = mc.searchMemberNameAnalogy(NameAnalogy);
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다");
		}else {
			for(Member m :list) {
				System.out.println(m);
			}
		}
	}
	// 5번 회원 정보 수정
	public void updateMember() {
		
		// 관리자 > 모든 회원 정보 수정
		// 사용자 > 내것만 수정
		System.out.println("=-=회원 정보 수정=-=");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		List<Member> m = mc.selectMemberOneByIdAndPw(id,pw);
		if(m != null) {
			System.out.println(m);
			// 이메일, 전화번호, 이름 > 수정
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("전화번호 : ");
			String phone = sc.nextLine();
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			int resul = mc.updateMemberInfo(id,pw,name,phone,email);
			if(resul>0) {
				System.out.println("수정 성공 !");
			}else {
				System.out.println("수정 실패 ㅠㅁㅠ");
			}
		}else {
			System.out.println("잘못된 아이디 혹은 비밀번호입니다.");
		}
	}	
	
	
	
	public void deleteMember() {
		
		System.out.println("=-=회원 탈퇴=-=");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		List<Member> m = mc.selectMemberOneByIdAndPw(id,pw);
		if(m!=null) {
		System.out.println(m);
		
		int resul = mc.deleteMember(id,pw);
		if(resul>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제실패 ㅠㅁㅠ");
		}
		}else {
			System.out.println("잘못된 아이디 혹은 비밀번호입니다.");
		}
		
	}
	
	
	
	
	
	
	
	
}
