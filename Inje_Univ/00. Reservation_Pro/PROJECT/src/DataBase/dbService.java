package DataBase;

import java.sql.*;
//import java.io.*;

public class dbService {
	String []retServiceInfo = new String[10];

	
	/*
	public boolean abledPage(String name) { // �ش� ���� ��/�� Ȯ�� �� �α��� ����
		String sql=null;
		ResultSet rs=null;
		Statement stmt=null;
		boolean isPage = false;
		
		try {
			sql = "SELECT * FROM service_info WHERE service_name='" + name + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next() == false || name.isEmpty() == true)
				isPage = false;
			else {
				sql = "SELECT * FROM service_info WHERE service_name='" + name + "'";
				rs = stmt.executeQuery(sql);
				while (rs.next() == true) {
					if (rs.getString(40).equals(ser))
						isPage = true;
					else
						isPage = false;
				}
			}
		} catch (SQLException e) {
			System.out.println("�˻������� ����");
		}

		return isPage;
	}
	*/
	public dbService() {
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
			rs = stmt.executeQuery("select * from service_info");
//			
			printData(rs, "service_name", "service_type", "service_location", "service_tel");
		}
		catch (ClassNotFoundException e) {
			 System.out.println("���� JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("���� SQL ���� ����");
		}
	}
	public void printData(ResultSet rs, String col1, String col2, String col3,
			String col4) throws SQLException {
			 while (rs.next()) {
			 if (col1 != "")
			 System.out.print(new String(rs.getString("service_name")));
			 if (col2 != "")
			 System.out.print("\t|\t" + rs.getString("service_type"));
			 if (col3 != "")
			 System.out.print("\t|\t" + new String(rs.getString("service_location")));
			 if (col4 != "")
				 System.out.println("\t|\t" + new String(rs.getString("service_tel")));
			 else
			 System.out.println();
			 }
	}
	public String getService(String info, int tri) {
		// tri 0 = name, 1 = primary_id
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String retStore = ""; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			System.out.println("\n\n���� �����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from service_info where service_name like '%" + info + "%'");
			
			retStore = searchData(rs, info, tri);
		} 
		catch (ClassNotFoundException e) {
			 System.out.println("ȸ������ JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("ȸ������ SQL ���� ����");
		}
		return retStore;
	}
	public String searchData(ResultSet rs, String src, int tri) throws SQLException{
		rs.next();
		if(tri == 0)
			return (new String (rs.getString("service_name")));
		else if(tri == 1)
			return (new String (rs.getString("primary_id")));
		return "-1";
	}
	
	public String getServiceName(int key) {
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String retStore = ""; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			System.out.println("\n\n���� �����ͺ��̽� ���� ����!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM service_info WHERE primary_id='" + key + "'");
			rs.next();
			return (new String(rs.getString("service_name")));
		} 
		catch (ClassNotFoundException e) {
			 System.out.println("ȸ������ JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			 System.out.println("�����̸� SQL ���� ����");
		}
		return "-1";
	}
}
