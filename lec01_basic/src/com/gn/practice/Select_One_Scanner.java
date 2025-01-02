package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.model.vo.Test;

public class Select_One_Scanner {

public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int number = sc.nextInt();
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
		String id = "scott";
		String pw = "tiger";
		con = DriverManager.getConnection(url, id, pw);
		stmt=con.createStatement();
		
		rs = stmt.executeQuery("SELECT t_no ,t_name ,t_date "+
				"FROM test "+"WHERE t_no ="+number);
//		List<Map<String,Object>> list =
//				new ArrayList<Map<String,Object>>();
		List<Test> map = new ArrayList<Test>();
		Test t = new Test();
		while(rs.next()) {
			t.setTsetNo(rs.getInt("t_no"));
			t.setTsetName(rs.getString("t_name"));
			t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
		}
		System.out.println(t);
	}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
