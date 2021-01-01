package DataBase;

import java.sql.*;

public class dbLogin {
	String url = "jdbc:mysql://127.0.0.1:3306/teamproject?useSSL=false&user=root&password=1234";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = null;

	public dbLogin() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("회원 정보 드라이버 연결 성공!");

			conn = DriverManager.getConnection(url);
			System.out.println("회원 정보 데이터베이스 접속 성공!");

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from identify");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	
	//회원탈퇴 , 삭제
	////////////////////검색할때 테이블 읽어와야함...
	public void delete(String id) {
		
//		StringBuilder sb=new StringBuilder();
		 sql = "delete from identify where id='" + id + "'";
		 System.out.println("삭제 메소드 실행");
		 try {
			 
			 stmt.executeLargeUpdate(sql);
			 System.out.println("정상삭제됨");
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println("에러발생");
		 }
	}

	public boolean abledAccount(String id, String pw) { // 해당 계정 유/무 확인 및 로그인 진행
		boolean isLogined = false;

		try {
			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next() == false || id.isEmpty() == true)
				isLogined = false;
			else {
				sql = "SELECT * FROM identify WHERE id='" + id + "'";
				rs = stmt.executeQuery(sql);
				while (rs.next() == true) {
					if (rs.getString(6).equals(pw))
						isLogined = true;
					else
						isLogined = false;
				}
			}
		} catch (SQLException e) {
			System.out.println("로그인 SQL 실행 에러");
		}

		return isLogined;
	}

	public String getUserName(String id) { // 로그인 중인 회원의 이름을 반환
		String name = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					name = rs.getString(1);
				else
					name = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret name SQL 실행 에러");
		}

		return name;
	}

	public String getUserSex(String id) { // 로그인 중인 회원의 성별을 반환
		String sex = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					sex = rs.getString(2);
				else
					sex = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret sex SQL 실행 에러");
		}

		return sex;
	}

	public String getUserTel(String id) { // 로그인 중인 회원의 번호를 반환
		String tel = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					tel = rs.getString(3);
				else
					tel = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret tel SQL 실행 에러");
		}

		return tel;
	}

	public String getUserMail(String id) { // 로그인 중인 회원의 e-mail을 반환
		String mail = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					mail = rs.getString(4);
				else
					mail = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret mail SQL 실행 에러");
		}

		return mail;
	}

	public String getUserId(String id) { // 로그인 중인 회원의 계정를 반환
		String idf = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					idf = rs.getString(5);
				else
					idf = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret id SQL 실행 에러");
		}

		return idf;
	}
	
	public String getUserPw(String id) { // 로그인 중인 회원의 계정를 반환
		String pw = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					pw = rs.getString(6);
				else
					pw = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret pw SQL 실행 에러");
		}

		return pw;
	}

	public String getUserCard(String id) { // 로그인 중인 회원의 카드번호를 반환
		String card = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					card = rs.getString(7);
				else
					card = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret card SQL 실행 에러");
		}

		return card;
	}

	public String getUserCcom(String id) { // 로그인 중인 회원의 카드사를 반환
		String com = "";

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					com = rs.getString(8);
				else
					com = "null";
			}
		} catch (SQLException e) {
			System.out.println("ret com SQL 실행 에러");
		}

		return com;
	}
	
	public int getIsreservation(String id) { // 로그인 중인 회원의 카드사를 반환
		int resv = -1;

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM identify WHERE id='" + id + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next() == true) {
				if (rs.getString(5).equals(id))
					resv = Integer.parseInt(rs.getString(9));
				else
					resv = -1;
			}
		} catch (SQLException e) {
			System.out.println("ret com SQL 실행 에러");
		}

		return resv;
	}
	
	// 장소 좌석 날짜
	
	// 이메일, 비밀번호, 휴대폰, 카드
	public void editPassword(String id, String pw) {
		try {
			stmt = conn.createStatement();

			
			sql = "update identify set password='" + pw + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit pw SQL 실행 에러");
		}
	}
	
	public void editPhone(String id, String tel) {
		try {
			stmt = conn.createStatement();

			
			sql = "update identify set phone_num='" + tel + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit tel SQL 실행 에러");
		}
	}
	
	public void editCard(String id, String card) {
		try {
			stmt = conn.createStatement();

			
			sql = "update identify set card_num='" + card + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit card SQL 실행 에러");
		}
	}
	
	public void editReservationOn(String id) {
		try {
			stmt = conn.createStatement();
			
			sql = "update identify set isreservation='" + 1 + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit card SQL 실행 에러");
		}
	}
	
	public void editReservationOff(String id) {
		try {
			stmt = conn.createStatement();
			
			sql = "update identify set isreservation='" + 0 + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit card SQL 실행 에러");
		}
	}
}
