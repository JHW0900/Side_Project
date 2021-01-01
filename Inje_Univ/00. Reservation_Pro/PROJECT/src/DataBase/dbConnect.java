package DataBase;

import java.sql.*;
import java.io.*;

public class dbConnect {
	public dbConnect() {
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 연결 성공!");
			
			conn = DriverManager.getConnection(url);
			System.out.println("데이터베이스 접속 성공!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from identify");
//			
			printData(rs, "name","sex","phone_num","e-mail","id","card_num","card_com");
		}
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			 System.out.println("SQL 실행 에러");
		}
	}
	public void printData(ResultSet rs, String col1, String col2, String col3,
			String col4, String col5, String col7, String col8) throws SQLException {
			 while (rs.next()) {
			 if (col1 != "")
			 System.out.print(new String(rs.getString("name")));
			 if (col2 != "")
			 System.out.print("\t|\t" + rs.getString("sex"));
			 if (col3 != "")
			 System.out.print("\t|\t" + new String(rs.getString("phone_num")));
			 if (col4 != "")
				 System.out.print("\t|\t" + new String(rs.getString("e-mail")));
			 if (col5 != "")
				 System.out.print("\t|\t" + new String(rs.getString("id")));
			 if (col7 != "")
				 System.out.print("\t|\t" + new String(rs.getString("card_num")));
			 if (col8 != "")
				 System.out.println("\t|\t" + new String(rs.getString("card_com")));
			 else
			 System.out.println();
			 }
	}
	public void insertData(String col1, int col2, String col3,
			String col4, String col5, String col6, String col7, String col8) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			System.out.println("\n\n데이터베이스 접속 성공!");
			
			stmt = conn.createStatement();
			
			//name, sex, phone_num, e-mail, id, password, card_num, card_com
			/* 수정 part */
			stmt.executeUpdate("insert into identify values"
						+ "('" + col1 + "', "+ "'" + col2 + "', "
						+ "'" + col3 + "', "+ "'" + col4 + "', "+ "'" + col5 + "', "
						+ "'" + col6 + "', "+ "'" + col7 + "', '" + col8 + "', '" + 0 + "');");
			rs = stmt.executeQuery("select * from identify");
			printData(rs, "name","sex","phone_num","e-mail","id","card_num","card_com");
		} 
		catch (ClassNotFoundException e) {
			 System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
}
