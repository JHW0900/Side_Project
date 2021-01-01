package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DataBase.*;
/*
 * 
 * Name
 * ����
 * �޴��� ��ȣ
 * E-mail
 * 
 * ID
 * PW
 * PW confirm
 * 
 * ī���
 * ī���ȣ
 * 
 * */

public class Register extends JPanel{
	MainPage win;
	dbConnect dbConn;
	
	JPanel 		pSign =				new JPanel();
	JPanel		pGender =			new JPanel();
	JPanel		pCard =				new JPanel();
	
	/******************************
	 * 
	 * ******* Temp Value ******* *
	 * 
	 *   �����ͺ��̽� ���� Ȯ��������,
	 *  ���� ��.
	 *  
	 ******************************/
	
	String		Name;				//�̸�
	int			Gender;				//����
	String 		Tel_num;			//�޴��� ��ȣ
	String		Email_add;			//�̸��� �ּ�
	
	String		Id;					//����
	String		Pw;					//��й�ȣ
	String		con_pw;				//��й�ȣ ��ġ üũ
	
	int			cardCompany;		//ī���
	String		cardNum;			//ī�� ��ȣ
	
	JButton bRegister = new JButton("ȸ������");
	/******************************
	 * 
	 * ******* Temp Label ******* *
	 * 
	 *   �����ͺ��̽� ���� Ȯ��������,
	 *  ���� ��.
	 * 
	 ******************************/
	
	JLabel		lInfo =			new JLabel("�ʼ����� �Է�");
	JLabel 		lName = 		new JLabel("�̸�");
	JLabel 		lGender = 		new JLabel("����");
	JLabel 		lTel_num = 		new JLabel("�޴�����ȣ");
	JLabel 		lEmail_add = 	new JLabel("E-mail");
	JLabel 		lId = 			new JLabel("���̵�");
	JLabel 		lPw = 			new JLabel("��й�ȣ");
	JLabel 		lCon_pw = 		new JLabel("��й�ȣ Ȯ��");
	JLabel		lCardInfo = 	new JLabel("ī������ �Է�");
	JLabel 		lCardnum = 		new JLabel("ī���ȣ");
	
	/******************** Valid ********************/
	
	JLabel		lName_valid = 		new JLabel("");
	JLabel		lTel_valid = 		new JLabel("");
	JLabel		lEmail_valid = 		new JLabel("");
	JLabel		lId_valid = 		new JLabel("");
	JLabel		lPw_valid = 		new JLabel("");
	JLabel		lConPw_valid = 		new JLabel("");
	
	/******************************
	 * 
	 * ******** TextField ******* *
	 * 
	 ******************************/
	
	JTextField		tName =			new JTextField("");
	JTextField		tTel_Num =		new JTextField("");
	JTextField		tEmail =		new JTextField("");
	JTextField		tId =			new JTextField("");
	JTextField		tPw =			new JTextField("");
	JTextField		tCon_pw =		new JTextField("");
	JTextField		tCardnum =		new JTextField("");
	
	/********************************
	 * 
	 * ******** RadioButton ******* *
	 * 
	 ********************************/
	
	ButtonGroup genderGroup =		new ButtonGroup();
	ButtonGroup companyGroup =		new ButtonGroup();
	
	JRadioButton maleButton =		new JRadioButton("Male");
	JRadioButton femaleButton =		new JRadioButton("Female");
	
	JRadioButton comNH =			new JRadioButton("����");
	JRadioButton comURI =			new JRadioButton("�츮");
	JRadioButton comIBK =			new JRadioButton("IBK���");
	JRadioButton comKAKAO =			new JRadioButton("īī����ũ");
	JRadioButton comSH =			new JRadioButton("����");
	JRadioButton comKFCC =			new JRadioButton("������");
	JRadioButton comKB =			new JRadioButton("KB����");
	JRadioButton comBS =			new JRadioButton("�λ�");
	JRadioButton Cr1 =				new JRadioButton("");
	JRadioButton Sr1 =				new JRadioButton("");
	
	/********************************
	 * 
	 * ********  Info_Value  ****** *
	 * 
	 ********************************/
	
	String Iname;
	int Isex;
	String Iphone_num;
	String Iemail;
	String Iid;
	String Ipassword;
	String Icard_num;
	String Icard_com;
	
	public Register(MainPage win) {
		this.win = win;
		dbConn = new dbConnect();
		
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);
		genderGroup.add(Sr1);
		
		companyGroup.add(comNH);
		companyGroup.add(comURI);
		companyGroup.add(comIBK);
		companyGroup.add(comKAKAO);
		companyGroup.add(comSH);
		companyGroup.add(comKFCC);
		companyGroup.add(comKB);
		companyGroup.add(comBS);
		companyGroup.add(Cr1);
		
		setListener();
		setSignSheet();
		setFont();
		setDisplay();
	}
	
	public void setDisplay() {
		setLayout(new BorderLayout(110,100));
		setBackground(new Color(223, 249, 251));
		
		add(new JLabel(""),BorderLayout.WEST);
		add(pSign,BorderLayout.CENTER);
		add(new JLabel(""),BorderLayout.EAST);
		
		maleButton.setBackground(new Color(223, 249, 251));
		femaleButton.setBackground(new Color(223, 249, 251));
		Sr1.setBackground(new Color(223, 249, 251));
		
		// NH, URI, IBK, KAKAO, SH, KFCC, KB, BS
		comNH.setBackground(new Color(223, 249, 251));
		comURI.setBackground(new Color(223, 249, 251));
		comIBK.setBackground(new Color(223, 249, 251));
		comKAKAO.setBackground(new Color(223, 249, 251));
		comSH.setBackground(new Color(223, 249, 251));
		comKFCC.setBackground(new Color(223, 249, 251));
		comKB.setBackground(new Color(223, 249, 251));
		comBS.setBackground(new Color(223, 249, 251));
		Cr1.setBackground(new Color(223, 249, 251));
		
		Cr1.setSelected(true);
		Sr1.setSelected(true);
	}
	
	public void setListener() {
		//ȸ������ ��ư�� ������ ��
		bRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cnt = 0;
				Iname = tName.getText();
				if(maleButton.isSelected())
					Isex = 1;
				else if (femaleButton.isSelected())
					Isex = 0;
				Iphone_num = tTel_Num.getText();
				Iemail = tEmail.getText();
				Iid = tId.getText();
				Ipassword = tPw.getText();
				Icard_num = tCardnum.getText();
				// NH, URI, IBK, KAKAO, SH, KFCC, KB, BS
				if(comNH.isSelected())
					Icard_com = comNH.getText();
				else if(comURI.isSelected())
					Icard_com = comURI.getText();
				else if(comIBK.isSelected())
					Icard_com = comIBK.getText();
				else if(comKAKAO.isSelected())
					Icard_com = comKAKAO.getText();
				else if(comSH.isSelected())
					Icard_com = comSH.getText();
				else if(comKFCC.isSelected())
					Icard_com = comKFCC.getText();
				else if(comKB.isSelected())
					Icard_com = comKB.getText();
				else if(comBS.isSelected())
					Icard_com = comBS.getText();
				
				// ���� ó��
				if (tName.getText().equals("")) {
					cnt++;
					String messageOption = "�̸��� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if(Sr1.isSelected() == true) {
					cnt++;
					String messageOption = "������ �������ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if (tTel_Num.getText().equals("")) {
					cnt++;
					String messageOption = "�޴�����ȣ�� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if (tEmail.getText().equals("")) {
					cnt++;
					String messageOption = "�̸����� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if (tId.getText().equals("")) {
					cnt++;
					String messageOption = "ID�� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if (tPw.getText().equals("")) {
					cnt++;
					String messageOption = "��й�ȣ�� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if(Ipassword.equals(tCon_pw.getText()) == false) {
					cnt++;
					String messageOption = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if (Cr1.isSelected() == true) {
					cnt++;
					String messageOption = "ī��縦 �������ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else if (tCardnum.getText().equals("")) {
					cnt++;
					String messageOption = "ī���ȣ�� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				if (cnt <= 0) {
					if (Ipassword.equals(tCon_pw.getText())) {
						dbConn.insertData(Iname, Isex, Iphone_num, Iemail, Iid, 
								Ipassword, Icard_num, Icard_com);
						win.panelChange("HomeButton");
					}
				}
				
				/********* Debugging ********/
//				dbConn.insertData("ȫ�浿",0,"010-1111-0000","kdHong@naver.com",
//						"kdHong","123456","1111-2222-3333-4444","īī����ũ");
				if (cnt <= 0) {
					tName.setText("");
					tTel_Num.setText("");
					tEmail.setText("");
					tId.setText("");
					tPw.setText("");
					tCon_pw.setText("");
					tCardnum.setText("");

					Cr1.setSelected(true);
					Sr1.setSelected(true);
					cnt = 0;
				}
			}
		});
	}
	
	public void setFont() {
		String fontStyle = "SansSerif";
		int fontSize = 15;
		
		lInfo.setFont(new Font(fontStyle, Font.BOLD, 25));
		lName.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lGender.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lTel_num.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lEmail_add.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lId.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lPw.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lCon_pw.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		lCardInfo.setFont(new Font(fontStyle, Font.BOLD, 25));
		lCardnum.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		
		bRegister.setBackground(new Color(34, 166, 179));
		bRegister.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	}
	
	public void setSignSheet() {
		pSign.setLayout(new GridLayout(15,3,0,5));
		pSign.setBackground(new Color(223, 249, 251));
		// col : 0
		pSign.add(lInfo);
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
	
		// col : 1
		pSign.add(lName);
		pSign.add(tName);
		pSign.add(lName_valid);
		
		// col : 2
		pGender.setLayout(new GridLayout(1,2));
		pGender.add(maleButton);
		pGender.add(femaleButton);
		
		pSign.add(lGender);
		pSign.add(pGender);
		pSign.add(new JLabel(""));
		
		// col : 3
		pSign.add(lTel_num);
		pSign.add(tTel_Num);
		pSign.add(lTel_valid);
		
		// col : 4
		pSign.add(lEmail_add);
		pSign.add(tEmail);
		pSign.add(lEmail_valid);
		
		// col : 5
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
		
		// col : 6
		pSign.add(lId);
		pSign.add(tId);
		pSign.add(lId_valid);
		
		// col : 7
		pSign.add(lPw);
		pSign.add(tPw);
		pSign.add(lPw_valid);
		
		// col : 8
		pSign.add(lCon_pw);
		pSign.add(tCon_pw);
		pSign.add(lConPw_valid);
		
		// col : 9
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
		
		// col : 10
		pSign.add(lCardInfo);
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
		
		// col : 11
		// NH, URI, IBK, KAKAO, SH, KFCC, KB, BS
		pCard.setLayout(new GridLayout(3,3));
		pCard.setBackground(new Color(223, 249, 251));
		pCard.add(comNH);
		pCard.add(comURI);
		pCard.add(comIBK);
		pCard.add(comKAKAO);
		pCard.add(comSH);
		pCard.add(comKFCC);
		pCard.add(comKB);
		pCard.add(comBS);
		
		pSign.add(new JLabel(""));
		pSign.add(pCard);
		pSign.add(new JLabel(""));
		
		// col : 12
		pSign.add(lCardnum);
		pSign.add(tCardnum);
		pSign.add(new JLabel(""));
		
		// col : 13
		pSign.add(new JLabel(""));
		pSign.add(bRegister);
		pSign.add(new JLabel(""));
		
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
		pSign.add(new JLabel(""));
	}
}
