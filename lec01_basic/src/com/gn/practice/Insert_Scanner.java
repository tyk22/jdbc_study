package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Insert_Scanner {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 :");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			//
			conn.setAutoCommit(false);
			//
			stmt = conn.createStatement();
			
			String str = sc.next();
			String sql1 = "SELECT COUNT(*) FROM test WHERE t_name='"+str+"'";
			rs = stmt.executeQuery(sql1);
			int count = 0;
			
			String sql ="SELECT t_no ,t_name ,t_date"
					+" FROM test"
					+" WHERE t_name ='"+str+"'";
			if (rs.next()) {
				count = rs.getInt(1);
			}
			Map<String,Object> map = new HashMap<String,Object>();
			if(rs.next()) {
				map.put("번호", rs.getInt("t_no"));
				map.put("이름", rs.getString("t_name"));
				map.put("날짜", rs.getTimestamp("t_date"));
			}
//			System.out.println(t);
			
			if(count==0) {
				String sqll = "INSERT INTO test(t_name) VALUES('"+str+"')";
				count = stmt.executeUpdate(sqll);
				if(count>0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
			}else {
				System.out.println("이미 존재하는 이름");
				System.out.println(map);
			}
			//
			conn.commit();
			//

		}catch(Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
