package SingButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class SingButton4 extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page�� ������ ���� 
	ImageIcon image1 = new ImageIcon("./sing_picture/���ڳ뷡Ÿ�� ������������.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_sing1 = new ImageIcon(pos_image1);
		
	// ���� ���� �� ����
	JLabel label = new JLabel(I_sing1);
	
	JLabel sing_name = new JLabel("���ڳ뷡Ÿ�� ������������");
	JLabel sing_review = new JLabel("���� : 4.19");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton sing_menu = new JButton("�޴�");
	JButton sing_information = new JButton("����");
	JButton sing_picture = new JButton("����");
	
	// �޴�
	ImageIcon example = new ImageIcon("./menu_image/���� �޴�.png");
	Image pre_ex1=example.getImage();
	Image pos_ex1=pre_ex1.getScaledInstance(900,280,java.awt.Image.SCALE_SMOOTH);
	ImageIcon exam = new ImageIcon(pos_ex1);
	
	JLabel ex = new JLabel(exam);
	
	// �����ϱ� ��ư
	JButton reservation = new JButton("�����ϱ�");
	
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
		
		reservation.setFont(new Font("���", Font.PLAIN, 18));
	}
	public void setDisplay() 
	{
		screen.setLayout(null);
		screen.setSize(1020, 800);

		label.setBounds(0,0,1000,200);
		sing_name.setBounds(380,200,300,50);
		sing_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		sing_menu.setBounds(50,290,200,50);
		sing_information.setBounds(400,290,200,50);
		sing_picture.setBounds(750,290,200,50);
		
		ex.setBounds(50,220,900,600);
		
		reservation.setBackground(new Color(34, 166, 179));
		reservation.setForeground(Color.WHITE);
		reservation.setFont(new Font("���", Font.BOLD, 20));
		
		reservation.setBounds(50,680,900,50);
		
		screen.add(label);
		screen.add(sing_name);
		screen.add(sing_review);
		
		screen.add(line);
		screen.add(sing_menu);
		screen.add(sing_information);
		screen.add(sing_picture);
		
		screen.add(ex);
		screen.add(reservation);
	}
	
	public void SingButton4Listener() {
		sing_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing4_menu_Button");
			}
		});
		sing_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing4_information_Button");
			}
		});
		sing_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing4_picture_Button");
			}
		});
		reservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.setService(1010, 10);
			}
		});
	}
	
	public SingButton4(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		SingButton4Listener();
		setVisible(true);
	}
}
