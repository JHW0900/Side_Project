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
			System.out.println("ȸ�� ���� ����̹� ���� ����!");

			conn = DriverManager.getConnection(url);
			System.out.println("ȸ�� ���� �����ͺ��̽� ���� ����!");

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from identify");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}
	
	//ȸ��Ż�� , ����
	////////////////////�˻��Ҷ� ���̺� �о�;���...
	public void delete(String id) {
		
//		StringBuilder sb=new StringBuilder();
		 sql = "delete from identify where id='" + id + "'";
		 System.out.println("���� �޼ҵ� ����");
		 try {
			 
			 stmt.executeLargeUpdate(sql);
			 System.out.println("���������");
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println("�����߻�");
		 }
	}

	public boolean abledAccount(String id, String pw) { // �ش� ���� ��/�� Ȯ�� �� �α��� ����
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
			System.out.println("�α��� SQL ���� ����");
		}

		return isLogined;
	}

	public String getUserName(String id) { // �α��� ���� ȸ���� �̸��� ��ȯ
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
			System.out.println("ret name SQL ���� ����");
		}

		return name;
	}

	public String getUserSex(String id) { // �α��� ���� ȸ���� ������ ��ȯ
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
			System.out.println("ret sex SQL ���� ����");
		}

		return sex;
	}

	public String getUserTel(String id) { // �α��� ���� ȸ���� ��ȣ�� ��ȯ
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
			System.out.println("ret tel SQL ���� ����");
		}

		return tel;
	}

	public String getUserMail(String id) { // �α��� ���� ȸ���� e-mail�� ��ȯ
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
			System.out.println("ret mail SQL ���� ����");
		}

		return mail;
	}

	public String getUserId(String id) { // �α��� ���� ȸ���� ������ ��ȯ
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
			System.out.println("ret id SQL ���� ����");
		}

		return idf;
	}
	
	public String getUserPw(String id) { // �α��� ���� ȸ���� ������ ��ȯ
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
			System.out.println("ret pw SQL ���� ����");
		}

		return pw;
	}

	public String getUserCard(String id) { // �α��� ���� ȸ���� ī���ȣ�� ��ȯ
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
			System.out.println("ret card SQL ���� ����");
		}

		return card;
	}

	public String getUserCcom(String id) { // �α��� ���� ȸ���� ī��縦 ��ȯ
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
			System.out.println("ret com SQL ���� ����");
		}

		return com;
	}
	
	public int getIsreservation(String id) { // �α��� ���� ȸ���� ī��縦 ��ȯ
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
			System.out.println("ret com SQL ���� ����");
		}

		return resv;
	}
	
	// ��� �¼� ��¥
	
	// �̸���, ��й�ȣ, �޴���, ī��
	public void editPassword(String id, String pw) {
		try {
			stmt = conn.createStatement();

			
			sql = "update identify set password='" + pw + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit pw SQL ���� ����");
		}
	}
	
	public void editPhone(String id, String tel) {
		try {
			stmt = conn.createStatement();

			
			sql = "update identify set phone_num='" + tel + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit tel SQL ���� ����");
		}
	}
	
	public void editCard(String id, String card) {
		try {
			stmt = conn.createStatement();

			
			sql = "update identify set card_num='" + card + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit card SQL ���� ����");
		}
	}
	
	public void editReservationOn(String id) {
		try {
			stmt = conn.createStatement();
			
			sql = "update identify set isreservation='" + 1 + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit card SQL ���� ����");
		}
	}
	
	public void editReservationOff(String id) {
		try {
			stmt = conn.createStatement();
			
			sql = "update identify set isreservation='" + 0 + "' where id = '" + id + "'";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Edit card SQL ���� ����");
		}
	}
}
