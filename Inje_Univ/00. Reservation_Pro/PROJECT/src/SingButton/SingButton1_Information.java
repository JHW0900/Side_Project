package SingButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class SingButton1_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page�� ������ ���� 
	ImageIcon image1 = new ImageIcon("./sing_picture/���� ���γ뷡������ ���� ��������.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_sing1 = new ImageIcon(pos_image1);
		
	// ���� ���� �� ����
	JLabel label = new JLabel(I_sing1);
	
	JLabel sing_name = new JLabel("���� ���γ뷡������ ���� ��������");
	JLabel sing_review = new JLabel("���� : 3.99");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton sing_menu = new JButton("�޴�");
	JButton sing_information = new JButton("����");
	JButton sing_picture = new JButton("����");
	
	// ����
	JLabel time = new JLabel("��ð� : ���� 10:00 ~ 03:00");
	JLabel holiday = new JLabel("�޹���    : ���߹���");
	JLabel phone = new JLabel("��ȭ��ȣ :  055-339-5009");
	JLabel location = new JLabel("��ġ���� : �泲 ���ؽ� ������188���� 12 2��");
	JLabel introduce = new JLabel("<html>���ԼҰ� : ������ �ֺ� �Ҿ׵� ī�� ���� ����!<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����̶� ��Ʈ���� Ǯ�� ����~"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ְ��� �ü�, �ְ��� ���񽺷� ��ðڽ��ϴ�.</html>");
	
	public void setFont()
	{
		sing_name.setFont(new Font("���", Font.BOLD, 20));
		sing_review.setFont(new Font("���", Font.PLAIN, 15));
		sing_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		sing_menu.setFont(new Font("���", Font.PLAIN, 18));
		sing_information.setFont(new Font("���", Font.PLAIN, 18));
		sing_picture.setFont(new Font("���", Font.PLAIN, 18));
		
		sing_menu.setBackground(Color.WHITE);
		sing_information.setBackground(Color.WHITE);
		sing_picture.setBackground(Color.WHITE);
		
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
		sing_name.setBounds(350,200,400,50);
		sing_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		sing_menu.setBounds(50,290,200,50);
		sing_information.setBounds(400,290,200,50);
		sing_picture.setBounds(750,290,200,50);
		
		time.setBounds(50,400,500,50);
		holiday.setBounds(50,450,500,50);
		phone.setBounds(50,500,500,50);
		location.setBounds(50,550,500,50);
		introduce.setBounds(50,600,1000,100);
		
		screen.add(label);
		screen.add(sing_name);
		screen.add(sing_review);
		
		screen.add(line);
		screen.add(sing_menu);
		screen.add(sing_information);
		screen.add(sing_picture);
		
		screen.add(time);
		screen.add(holiday);
		screen.add(phone);
		screen.add(location);
		screen.add(introduce);
	}
	
	public void SingButton1Listener() {
		sing_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing1_menu_Button");
			}
		});
		sing_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing1_information_Button");
			}
		});
		sing_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing1_picture_Button");
			}
		});
	}
	
	public SingButton1_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		SingButton1Listener();
		setVisible(true);
	}
}