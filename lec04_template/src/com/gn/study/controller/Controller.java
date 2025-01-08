package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

// View로부터 전달받은 데이터 가공 > Service 전달
public class Controller {	
	private Service service = new Service();
	
	public int changeDate(String carDate, int carNo) {
		return service.changeDate(carDate,carNo);
	}
	
	public int changePrice(int carPrice, int carNo) {
		return service.changePrice(carPrice,carNo);
	}
	
	public int ChangeCar(String ChangeName,int carNo) {
		return service.ChangeCar(ChangeName,carNo);
	}
	
	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}
	public int insertCarOne(String modelName, 
							int price,String date) {
		Car car = new Car(modelName,price,date);
		int result = service.insertCarOne(car);
		return result;
	}
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	// 번호
	public List<Car> selectNumber(int carNo){
		return service.selectNumber(carNo);
	}
	
	// 모델명
	public List<Car> singleSelect(String carName){
		return service.singleSelect(carName);
	}
	// 가격
	public List<Car> selectPrice(int carPrice){
		return service.selectPrice(carPrice);
	}
	//
	public List<Car> selectDate(String carDate){
		return service.selectDate(carDate);
	}
	
}
