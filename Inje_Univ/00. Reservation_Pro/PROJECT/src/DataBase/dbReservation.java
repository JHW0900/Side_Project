package DataBase;

import java.sql.*;
import java.io.*;

public class dbReservation {
	public dbReservation() {
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���� ����̹� ���� ����!");
			
			conn = DriverManager.getConnection(url);
			System.out.println("���� �����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from identify");
		}
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("���� SQL ���� ����");
		}
	}
	
	public int getService(String id) {
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���� ����̹� ���� ����!");
			
			conn = DriverManager.getConnection(url);
			System.out.println("���� �����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from reservation_info where user_id like '" + id + "'");
			rs.next();
			return (Integer.parseInt(rs.getString("primary_id")));
		}
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("���� SQL ���� ����");
		}
		return -1;
	}
	
	public int getSeatNum(String id) {
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���� ����̹� ���� ����!");
			
			conn = DriverManager.getConnection(url);
			System.out.println("���� �����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from reservation_info where user_id like '" + id + "'");
			rs.next();
			return (Integer.parseInt(rs.getString("seat")));
		}
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("���� SQL ���� ����");
		}
		return -1;
	}
	
	public String getUserId(String id) {
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���� ����̹� ���� ����!");
			
			conn = DriverManager.getConnection(url);
			System.out.println("���� �����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from reservation_info where user_id like '" + id + "'");
			rs.next();
			return (new String(rs.getString("user_id")));
		}
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("���� SQL ���� ����");
		}
		return "-1";
	}
	
	public void insertData(int col1, int col2, String col3) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			System.out.println("\n\n�����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			
			//name, sex, phone_num, e-mail, id, password, card_num, card_com
			/* ���� part */
			stmt.executeUpdate("insert into reservation_info values"
						+ "('" + col1 + "', "+ "'" + col2 + "', "
						+ "'" + col3 + "');");
		} 
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("���� SQL ���� ����");
		}
	}
}
