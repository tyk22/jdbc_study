package com.gn.watermelonMusic.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Controller {
	
	/*public int insertMember(String memberId, String memberPw) {
		Connection conn = null;	
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "INSERT INTO MEMBER (m_id ,m_pw ,m_name ,m_email ,m_gender ,m_phone)"
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()+"','"+m.getMemberName()+"'"
							+ ",'"+m.getMemberEmail()+"','"+m.getMemberGender()+"','"+m.getMemberPhone()+"')";
			result = stmt.executeUpdate(sql);
			// pstmt.setString(1, projectName);
			// pstmt.setString(2, managerName);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
*/	
}
