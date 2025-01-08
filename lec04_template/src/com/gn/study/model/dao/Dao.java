package com.gn.study.model.dao;

import static com.gn.study.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Car;
public class Dao {
	
	public int changeDate(Connection conn,String carDate, int carNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql ="UPDATE car SET car_date = ? WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carDate);
			pstmt.setInt(2, carNo);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int changePrice(Connection conn,int carPrice, int carNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql ="UPDATE car SET car_price = ? WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carPrice);
			pstmt.setInt(2, carNo);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int ChangeCar(Connection conn, String ChangeName,int carNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql ="UPDATE car SET car_model = ? WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ChangeName);
			pstmt.setInt(2, carNo);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int deleteCarOne(Connection conn, int carNo) {
		PreparedStatement pstmt=null;
		int result = 0;
		try {
			String sql = "DELETE FROM car WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carNo);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<Car> selectDate(Connection conn, String carDate){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car WHERE car_date = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carDate);
			rs = pstmt.executeQuery();	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date" ) != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				list.add(car);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Car> selectPrice(Connection conn, int carprice){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car WHERE car_price = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carprice);
			rs = pstmt.executeQuery();	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date" ) != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				list.add(car);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Car> selectNumber(Connection conn, int carNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carNo);
			rs = pstmt.executeQuery();	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date" ) != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				list.add(car);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Car> singleSelect(Connection conn, String carName){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car WHERE car_model = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carName);
			rs = pstmt.executeQuery();	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date" ) != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				list.add(car);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	public List<Car> selectCarAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			while(rs.next()) {
//				Car car = new Car(rs.getInt("car_no")
//						,rs.getString("car_medal")
//						,rs.getInt("car_price")
//						,sdf.format(rs.getDate("car_date")));
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date" ) != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				list.add(car);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertCarOne(Car car, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO car(car_model ,car_price ,car_date) "
						+ "VALUES(?,?, STR_TO_DATE(?,'%Y-%m-%d'))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
			close(pstmt);
		}
		return result;
	}
	
	
}

