package com.gn.study.contrller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gn.study.model.vo.Test;

public class B_Select_One {
	// 1. Map형태로 추출
	public static void main(String[] args) {
		
		// (1) 작업용 객체 선언
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		// (2) try~catch~finally 작성
		try {
			// (3) Driver 등록
			Class.forName("org.mariadb.jdbc.Driver");
			// (4) 
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			// (5) Statement
			stmt=conn.createStatement();
			// (6) 결과 전달받기(ResultSet)
			String sql ="SELECT t_no ,t_name ,t_date"
					+" FROM test"
					+" WHERE t_no = 1";
			
			rs = stmt.executeQuery(sql);
//			// (7) 데이터 추출
//			Map<String,Object> map = new HashMap<String,Object>();
//			if(rs.next()) {
//				map.put("번호", rs.getInt("t_no"));
//				map.put("이름", rs.getString("t_name"));
//				map.put("날짜", rs.getTimestamp("t_date"));
//			}
			// 출력
//			System.out.println(map);
			
			
			Test t = new Test();
			if(rs.next()) {
				t.setTsetNo(rs.getInt("t_no"));
				t.setTsetName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
			}
			System.out.println(t);
			
		}catch(Exception e) {
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
