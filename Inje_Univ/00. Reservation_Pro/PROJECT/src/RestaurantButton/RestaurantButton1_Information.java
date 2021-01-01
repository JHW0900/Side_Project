package RestaurantButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class RestaurantButton1_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./restaurant_picture/코이코이 인제대점.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_res1);
	
	JLabel res_name = new JLabel("코이코이 인제대점");
	JLabel res_review = new JLabel("평점 : 4.6");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton res_menu = new JButton("메뉴");
	JButton res_information = new JButton("정보");
	JButton res_picture = new JButton("사진");
	
	// 정보
	JLabel time = new JLabel("운영시간          : 평일 11:30 ~ 21:00     주말 11:30~20:00");
	JLabel holiday = new JLabel("브레이크 타임 : 15:00 ~ 16:30");
	JLabel phone = new JLabel("전화번호         : 0507-1404-5960");
	JLabel location = new JLabel("위치정보         : 경남 김해시 인제로210번길 5-3");
	JLabel introduce = new JLabel("<html>가게소개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : 인제대 근처 일본식라면!<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주말에는 브레이크 타임 없습니다!"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;라스트 오더는 20:30 입니당~</html>");
	
	public void setFont()
	{
		res_name.setFont(new Font("고딕", Font.BOLD, 20));
		res_review.setFont(new Font("고딕", Font.PLAIN, 15));
		res_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		res_menu.setFont(new Font("고딕", Font.PLAIN, 18));
		res_information.setFont(new Font("고딕", Font.PLAIN, 18));
		res_picture.setFont(new Font("고딕", Font.PLAIN, 18));
		
		res_menu.setBackground(Color.WHITE);
		res_information.setBackground(Color.WHITE);
		res_picture.setBackground(Color.WHITE);
		
		time.setFont(new Font("고딕", Font.PLAIN, 18));
		holiday.setFont(new Font("고딕", Font.PLAIN, 18));
		phone.setFont(new Font("고딕", Font.PLAIN, 18));
		location.setFont(new Font("고딕", Font.PLAIN, 18));
		introduce.setFont(new Font("고딕", Font.PLAIN, 18));
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
	
	public void RestaurantButton1Listener() {
		res_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant1_menu_Button");
			}
		});
		res_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant1_information_Button");
			}
		});
		res_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant1_picture_Button");
			}
		});
	}
	
	public RestaurantButton1_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		RestaurantButton1Listener();
		setVisible(true);
	}
}