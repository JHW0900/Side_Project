package RestaurantButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class RestaurantButton2_Menu extends JPanel{
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
	
	// 메뉴
	ImageIcon example = new ImageIcon("./menu_image/유키 메뉴.png");
	Image pre_ex1=example.getImage();
	Image pos_ex1=pre_ex1.getScaledInstance(900,280,java.awt.Image.SCALE_SMOOTH);
	ImageIcon exam = new ImageIcon(pos_ex1);
	
	JLabel ex = new JLabel(exam);
	
	// 예약하기 버튼
	JButton reservation = new JButton("예약하기");
	
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
		
		reservation.setFont(new Font("고딕", Font.PLAIN, 18));
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
		
		ex.setBounds(50,220,900,600);
		
		reservation.setBackground(new Color(34, 166, 179));
		reservation.setForeground(Color.WHITE);
		reservation.setFont(new Font("고딕", Font.BOLD, 20));
		
		reservation.setBounds(50,680,900,50);
		
		screen.add(label);
		screen.add(res_name);
		screen.add(res_review);
		
		screen.add(line);
		screen.add(res_menu);
		screen.add(res_information);
		screen.add(res_picture);
		
		screen.add(ex);
		screen.add(reservation);
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
		reservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.setService(1002, 18);
			}
		});
	}
	
	public RestaurantButton2_Menu(MainPage win)
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