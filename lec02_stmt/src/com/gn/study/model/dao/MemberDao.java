package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gn.study.model.vo.Member;

public class MemberDao {
	public List<Member> selectMemberAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT m_no "
					+ ",m_id "
					+ ",m_pw "
					+ ",m_name "
					+ ",m_email "
					+ ",m_phone "
					+ ",m_gender "
					+ ",reg_date "
					+ ",mod_date "
					+ "FROM `member`");
			// 전체 member 정보 조회 > List<Member>
		
			while (rs.next()) {
				Member mb = new Member();
				mb.setMemberno(rs.getInt("m_no"));
				mb.setMemberId(rs.getString("m_id"));
				mb.setMemberPw(rs.getString("m_pw"));
				mb.setMemberName(rs.getString("m_name"));
				mb.setMemberEmail(rs.getString("m_email"));
				mb.setMemberPhone(rs.getString("m_phone"));;
				mb.setMemberGender(rs.getString("m_gender"));
				mb.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());;
				mb.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(mb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	// 내가 만든 아이디 조회
	public List<Member> selectId(String hid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT m_no "
					+ ",m_id "
					+ ",m_pw "
					+ ",m_name "
					+ ",m_email "
					+ ",m_phone "
					+ ",m_gender "
					+ ",reg_date "
					+ ",mod_date "
					+ "FROM `member`"
					+ "WHERE m_id = '"+hid+"'");
			// 전체 member 정보 조회 > List<Member>
			
			if (rs.next()) {
				Member mb = new Member();
				mb.setMemberno(rs.getInt("m_no"));
				mb.setMemberId(rs.getString("m_id"));
				mb.setMemberPw(rs.getString("m_pw"));
				mb.setMemberName(rs.getString("m_name"));
				mb.setMemberEmail(rs.getString("m_email"));
				mb.setMemberPhone(rs.getString("m_phone"));;
				mb.setMemberGender(rs.getString("m_gender"));
				mb.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());;
				mb.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(mb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	// 수업때 만든 아이디로 조회
	public Member searchMemberOneById(String memId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id = '"+memId+"'");
			if(rs.next()) {
				 m = new Member(rs.getInt("m_no"),rs.getString("m_id"),rs.getString("m_pw"));
			}
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
		return m;
	}
	public List<Member> searchMemberNameAnalogy(String NameAnalogy) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT m_no "
					+ ",m_id "
					+ ",m_pw "
					+ ",m_name "
					+ ",m_email "
					+ ",m_phone "
					+ ",m_gender "
					+ ",reg_date "
					+ ",mod_date "
					+ "FROM `member` "
					+ "WHERE m_name LIKE '"+"%"+NameAnalogy+"%"+"'");
			// 전체 member 정보 조회 > List<Member>
		
			while (rs.next()) {
				Member mb = new Member();
				mb.setMemberno(rs.getInt("m_no"));
				mb.setMemberId(rs.getString("m_id"));
				mb.setMemberPw(rs.getString("m_pw"));
				mb.setMemberName(rs.getString("m_name"));
				mb.setMemberEmail(rs.getString("m_email"));
				mb.setMemberPhone(rs.getString("m_phone"));;
				mb.setMemberGender(rs.getString("m_gender"));
				mb.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());;
				mb.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(mb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO MEMBER (m_id ,m_pw ,m_name ,m_email ,m_gender ,m_phone)"
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()+"','"+m.getMemberName()+"'"
							+ ",'"+m.getMemberEmail()+"','"+m.getMemberGender()+"','"+m.getMemberPhone()+"')";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*public Member selectMemberOneByIdAndPw(String memberId,String memberPw) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id = '"+memberId+"'"+ "AND m_pw = '"+memberPw+"'");
			if (rs.next()) {
				m = new Member();
				m.setMemberno(rs.getInt("m_no"));
				m.setMemberId(rs.getString("m_id"));
				m.setMemberPw(rs.getString("m_pw"));
				m.setMemberName(rs.getString("m_name"));
				m.setMemberEmail(rs.getString("m_email"));
				m.setMemberPhone(rs.getString("m_phone"));;
				m.setMemberGender(rs.getString("m_gender"));
				m.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());;
				m.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
			}
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
		return m;
	}*/
	public List<Member> selectMemberOneByIdAndPw(String memberId, String memberPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id = '"+memberId+"'"+ "AND m_pw = '"+memberPw+"'");
			if (rs.next()) {
				Member mb = new Member();
				mb.setMemberno(rs.getInt("m_no"));
				mb.setMemberId(rs.getString("m_id"));
				mb.setMemberPw(rs.getString("m_pw"));
				mb.setMemberName(rs.getString("m_name"));
				mb.setMemberEmail(rs.getString("m_email"));
				mb.setMemberPhone(rs.getString("m_phone"));;
				mb.setMemberGender(rs.getString("m_gender"));
				mb.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());;
				mb.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(mb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public int updateMemberInfo(String memberId, String memberPw,String memberName, String memberPhone, String memberEmail) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			// 
			String sql = "UPDATE member "
					+ "SET m_name = '"+memberName+"', m_phone = '"+memberPhone+"', m_email = '"+memberEmail+"'"
					+ "WHERE m_id = '"+memberId+"'"+ "AND m_pw = '"+memberPw+"'";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMember(String memberId, String memberPw) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			// 
			String sql = "DELETE FROM member "
					+ "WHERE m_id = '"+memberId+"'"+ "AND m_pw = '"+memberPw+"'";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
