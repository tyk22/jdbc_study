package com.gn.watermelonMusic.menu;

import java.util.Scanner;

import com.gn.watermelonMusic.controller.Controller;

/*public class Vo {
	private Scanner sc = new Scanner(System.in);
	private Controller cr = new Controller();
	public void mainMenu() {
		System.out.println("환영합니다!!");
		// 사용자에게 정보 입력받아서
		// Controller에게 전달
		while(true) {
			System.out.println("=== 초기메뉴 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
//			System.out.println("3. 회원 아이디 검색");
//			System.out.println("4. 회원 이름으로 키워드 검색");
//			System.out.println("5. 회원 정보 수정");
//			System.out.println("6. 회원 탈퇴");
//			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1 :joinMemberShip();break; 
			case 2 : ;break;
			case 3 : ;break;
			case 4 : ;break;
			case 5 : ;break;
			case 6 : ;break;
			case 0 : System.out.println("잘가요~안녕~");return;
			
			default : System.out.println("잘못된 번호입니다.");break;
			}
		}
	}
	public void joinMemberShip() {
		
		System.out.println("===회원가입===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		int join = cr.insertMember(id,pw);
		if(join>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
}*/
