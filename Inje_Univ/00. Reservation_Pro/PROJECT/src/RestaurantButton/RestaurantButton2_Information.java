package RestaurantButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class RestaurantButton2_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./restaurant_picture/유키돈까스 인제대점.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_res1);
	
	JLabel res_name = new JLabel("유키돈까스 인제대점");
	JLabel res_review = new JLabel("평점 : 4.53");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton res_menu = new JButton("메뉴");
	JButton res_information = new JButton("정보");
	JButton res_picture = new JButton("사진");
	
	// 정보
	JLabel time = new JLabel("운영시간 : 매일 11:00 ~ 21:00");
	JLabel holiday = new JLabel("휴무일    : 일요일");
	JLabel phone = new JLabel("전화번호 :   055-323-0781");
	JLabel location = new JLabel("위치정보 : 경남 김해시 인제로200번길 6 대우빌딩 ");
	JLabel introduce = new JLabel("<html>가게소개 : 모든 메뉴위 샐러드 밥,장국 추가 리필 가능<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;각 테이블에 돈까스 소스와 작은 절구 비치"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;샐러드, 장국, 밥, 단무지, 김치는 기본 구성!</html>");
	
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
	
	public void RestaurantButton2Listener() {
		res_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant2_menu_Button");
			}
		});
		res_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant2_information_Button");
			}
		});
		res_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant2_picture_Button");
			}
		});
	}
	
	public RestaurantButton2_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		RestaurantButton2Listener();
		setVisible(true);
	}
}