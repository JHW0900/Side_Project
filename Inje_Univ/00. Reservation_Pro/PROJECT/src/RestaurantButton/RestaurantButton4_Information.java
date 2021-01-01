package RestaurantButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class RestaurantButton4_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page�� ������ ���� 
	ImageIcon image1 = new ImageIcon("./restaurant_picture/�Ե����� ���ؾ����.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res1 = new ImageIcon(pos_image1);
		
	// ���� ���� �� ����
	JLabel label = new JLabel(I_res1);
	
	JLabel res_name = new JLabel("�Ե����� ���ؾ����");
	JLabel res_review = new JLabel("���� : 4.35");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton res_menu = new JButton("�޴�");
	JButton res_information = new JButton("����");
	JButton res_picture = new JButton("����");
	
	// ����
	JLabel time = new JLabel("��ð� : ���� 10:00 ~ 22:00");
	JLabel holiday = new JLabel("�޹���    : ���߹���");
	JLabel phone = new JLabel("��ȭ��ȣ :   055-321-3415");
	JLabel location = new JLabel("��ġ���� : �泲 ���ؽ� ������ 190 �������� ");
	JLabel introduce = new JLabel("<html>���ԼҰ� : ����, ��� ����<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ȩ���񽺴� 11:00~22:00"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���븮�� �и��͸����� �Ծ����~</html>");
	
	public void setFont()
	{
		res_name.setFont(new Font("���", Font.BOLD, 20));
		res_review.setFont(new Font("���", Font.PLAIN, 15));
		res_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		res_menu.setFont(new Font("���", Font.PLAIN, 18));
		res_information.setFont(new Font("���", Font.PLAIN, 18));
		res_picture.setFont(new Font("���", Font.PLAIN, 18));
		
		res_menu.setBackground(Color.WHITE);
		res_information.setBackground(Color.WHITE);
		res_picture.setBackground(Color.WHITE);
		
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
		res_name.setBounds(420,200,400,50);
		res_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		res_menu.setBounds(50,290,200,50);
		res_information.setBounds(400,290,200,50);
		res_picture.setBounds(750,290,200,50);
		
		time.setBounds(50,400,500,50);
		holiday.setBounds(50,450,500,50);
		phone.setBounds(50,500,500,50);
		location.setBounds(50,550,500,50);
		introduce.setBounds(50,600,1000,100);
		
		screen.add(label);
		screen.add(res_name);
		screen.add(res_review);
		
		screen.add(line);
		screen.add(res_menu);
		screen.add(res_information);
		screen.add(res_picture);
		
		screen.add(time);
		screen.add(holiday);
		screen.add(phone);
		screen.add(location);
		screen.add(introduce);
	}
	
	public void RestaurantButton4Listener() {
		res_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant4_menu_Button");
			}
		});
		res_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant4_information_Button");
			}
		});
		res_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant4_picture_Button");
			}
		});
	}
	
	public RestaurantButton4_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		RestaurantButton4Listener();
		setVisible(true);
	}
}