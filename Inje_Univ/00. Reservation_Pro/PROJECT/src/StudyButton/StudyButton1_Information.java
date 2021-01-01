package StudyButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class StudyButton1_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page�� ������ ���� 
	ImageIcon image1 = new ImageIcon("./study_picture/�����ǽ� ������.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study1 = new ImageIcon(pos_image1);
		
	// ���� ���� �� ����
	JLabel label = new JLabel(I_study1);
	
	JLabel study_name = new JLabel("�����ǽ� ������");
	JLabel study_review = new JLabel("���� : 3.32");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton study_menu = new JButton("�޴�");
	JButton study_information = new JButton("����");
	JButton study_picture = new JButton("����");
	
	// ����
	JLabel time = new JLabel("��ð� : ���� 10:00 ~ 03:00");
	JLabel holiday = new JLabel("�޹���    : ���߹���");
	JLabel phone = new JLabel("��ȭ��ȣ :  055-326-1310");
	JLabel location = new JLabel("��ġ���� : �泲 ���ؽ� ��ȷ� 309 ����û");
	JLabel introduce = new JLabel("<html>���ԼҰ� : ������ �����ǽ� �������Դϴ�^^<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�������� / �л����α���"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ν� / ���ν�(Ŀư) / ��ǻ�ͽ� / �������ͳ�</html>");
	
	public void setFont()
	{
		study_name.setFont(new Font("���", Font.BOLD, 20));
		study_review.setFont(new Font("���", Font.PLAIN, 15));
		study_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		study_menu.setFont(new Font("���", Font.PLAIN, 18));
		study_information.setFont(new Font("���", Font.PLAIN, 18));
		study_picture.setFont(new Font("���", Font.PLAIN, 18));
		
		study_menu.setBackground(Color.WHITE);
		study_information.setBackground(Color.WHITE);
		study_picture.setBackground(Color.WHITE);
		
		time.setFont(new Font("���", Font.PLAIN, 18));
		holiday.setFont(new Font("���", Font.PLAIN, 18));
		phone.setFont(new Font("���", Font.PLAIN, 18));
		location.setFont(new Font("���", Font.PLAIN, 18));
		introduce.setFont(new Font("���", Font.PLAIN, 18));
	}
	public void setDisplay() 
	{
		screen.setLayout(null);
		screen.setSize(1020, 800);

		label.setBounds(0,0,1000,200);
		study_name.setBounds(420,200,400,50);
		study_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		study_menu.setBounds(50,290,200,50);
		study_information.setBounds(400,290,200,50);
		study_picture.setBounds(750,290,200,50);
		
		time.setBounds(50,400,500,50);
		holiday.setBounds(50,450,500,50);
		phone.setBounds(50,500,500,50);
		location.setBounds(50,550,500,50);
		introduce.setBounds(50,600,1000,100);
		
		screen.add(label);
		screen.add(study_name);
		screen.add(study_review);
		
		screen.add(line);
		screen.add(study_menu);
		screen.add(study_information);
		screen.add(study_picture);
		
		screen.add(time);
		screen.add(holiday);
		screen.add(phone);
		screen.add(location);
		screen.add(introduce);
	}
	
	public void StudyButton1Listener() {
		study_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_menu_Button");
			}
		});
		study_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_information_Button");
			}
		});
		study_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_picture_Button");
			}
		});
	}
	
	public StudyButton1_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		StudyButton1Listener();
		setVisible(true);
	}
}
