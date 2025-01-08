package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

// 사용자가 보게될 화면
// - 사용자에게 정보 입력받기
// - 결과 화면 출력
public class Menu {
	private Scanner sc= new Scanner(System.in);
	private Controller controller = new Controller();
	public void mainMenu() {
		while(true) {
			System.out.println("=-= 자동차 정보 관리 =-=");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertCarOne();break;
				case 2 : selectCarAll();break;
				case 3 : singleSelect();break;
				case 4 : ChangeCar();break;
				case 5 : deleteCarOne();break;
			}
			
		}
	}
	
	public void ChangeCar() {
		int result = 0;
		System.out.println("어떤 모델의 정보를 수정하시겠습니까?");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		
		System.out.print("모델명을 수정하시겠습니까? Y/N");
		String yesOrNo = sc.next();
		if("Y".equals(yesOrNo)) {
			System.out.print("모델명 : ");
			String ChangeName = sc.next();
			result = controller.ChangeCar(ChangeName,carNo);
		}
		
		System.out.println("가격을 수정하시겠습니까? Y/N");
		yesOrNo = sc.next();
		if("Y".equals(yesOrNo)) {
			System.out.print("가격 : ");
			int carPrice = sc.nextInt();
			result = controller.changePrice(carPrice,carNo);
		}
		
		System.out.println("출시일을 수정하시겠습니까? Y/N");
		yesOrNo = sc.next();
		if("Y".equals(yesOrNo)) {
			System.out.print("출시일 : ");
			String carDate = sc.next();
			result = controller.changeDate(carDate,carNo);
		}
		dmlResultPrint(result,"수정");
	}
	
	public void deleteCarOne() {
		System.out.println("=-= 삭제 =-=");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("삭제하고자 하는 자동차 번호를 입력하세요.");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		int result = controller.deleteCarOne(carNo);
		dmlResultPrint(result,"삭제");
	}
	public void singleSelect() {
		System.out.println("=== 단일 조회 ===");
		System.out.println("1. 번호 / 2. 모델명 / 3. 가격 / 4. 출시일 ");
		System.out.println("예시 ) 번호 : 3, 모델명 : 제네시스, 가격 : 5800, 출시일 : 2021-07-20");
		System.out.print("번호 선택 : ");
		int selectNumber = sc.nextInt();
		switch(selectNumber) {
			case 1 : selectOne();break;
			case 2 : selectOtwo();break;
			case 3 : selectThree();break;
			case 4 : selectFour();break;
			default : System.out.println("메뉴를 잘못 입력하셨습니다.");
		}
		
	}
	// 번호
	public void selectOne() {
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		List<Car> list = controller.selectNumber(carNo);
		printList(list);
	}
	// 모델명
	public void selectOtwo() {
		System.out.print("모델명 : ");
		String carName = sc.next();
		List<Car> list = controller.singleSelect(carName);
		printList(list);
	}
	// 가격
	public void selectThree() {
		System.out.print("가격 : ");
		int carPrice = sc.nextInt();
		List<Car> list = controller.selectPrice(carPrice);
		printList(list);
	}
	// 출시일
	public void selectFour() {
		System.out.print("출시일 : ");
		String carDate = sc.next();
		List<Car> list = controller.selectDate(carDate);
		printList(list);
		
	}
	
	
	public void selectCarAll() {
		System.out.println("=-= 목록 조회 =-=");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else{
			for(Car c : list) {
				System.out.println(c);
			}
		}
	
	}
	
	public void insertCarOne() {
		System.out.println("=== 추가 ===");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("다만, 출시일은 반드 oooo-oo-oo 형식으로 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("추시일 정보를 입력하시겠습니다?(Y/N)");
		String dateFlag = sc.nextLine();
		// char dateFlag = sc.nextLine().charAt(0);
		String date = null;
		if("Y".equals(dateFlag)) {
			System.out.println("출시일 : ");
			date = sc.nextLine();
		}
		int result = controller.insertCarOne(modelName,price,date);
		dmlResultPrint(result, "추가");
	}
	
	public void dmlResultPrint(int result, String menuName) {
		if(result>0)System.out.println(menuName+"이(가) 정상 수행되었습니다.");
		else System.out.println(menuName+"중 오류가 발생하였습니다.");
	}
	
}
