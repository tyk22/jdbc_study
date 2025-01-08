package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

// DB에 접속 > Connection 객체 생성
public class Service {
	private Dao dao = new Dao();
	
	public int changeDate(String carDate, int carNo) {
		Connection conn = getConnection();
		int result = dao.changeDate(conn,carDate,carNo);
		close(conn);
		return result;
	}
	
	public int changePrice(int carPrice, int carNo) {
		Connection conn = getConnection();
		int result = dao.changePrice(conn,carPrice,carNo);
		close(conn);
		return result;
	}
	
	public int ChangeCar(String ChangeName,int carNo) {
		Connection conn = getConnection();
		int result = dao.ChangeCar(conn,ChangeName,carNo);
		close(conn);
		return result;
	}
	
	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(conn,carNo);
		close(conn);
		return result;
	}
	
	public List<Car> selectDate(String carDate){
		Connection conn = getConnection();
		List<Car> list = dao.selectDate(conn,carDate);
		close(conn);
		return list;
	}
	
	public List<Car> selectPrice(int carPrice){
		Connection conn = getConnection();
		List<Car> list = dao.selectPrice(conn,carPrice);
		close(conn);
		return list;
	}
	
	public List<Car> selectNumber(int carNo){
		Connection conn = getConnection();
		List<Car> list = dao.selectNumber(conn,carNo);
		close(conn);
		return list;
	}
	
	public List<Car> singleSelect(String carName){
		Connection conn = getConnection();
		List<Car> list = dao.singleSelect(conn,carName);
		close(conn);
		return list;
	}
	
	public List<Car> selectCarAll(){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
	}
	
	public int insertCarOne(Car car) {
		
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;
		
		
//		Connection conn=null;
//		int result = 0;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String user = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url, user, pw);
//			result = dao.insertCarOne(car,conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn!=null)conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}
}
