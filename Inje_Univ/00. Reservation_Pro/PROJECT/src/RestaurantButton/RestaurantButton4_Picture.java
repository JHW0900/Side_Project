package RestaurantButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class RestaurantButton4_Picture extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./restaurant_picture/롯데리아 김해어방점.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_res1);
	
	JLabel res_name = new JLabel("롯데리아 김해어방점");
	JLabel res_review = new JLabel("평점 : 4.35");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton res_menu = new JButton("메뉴");
	JButton res_information = new JButton("정보");
	JButton res_picture = new JButton("사진");
	
	// 사진
	ImageIcon image2 = new ImageIcon("./restaurant_picture/롯데리아 김해어방점1.jpg");
	Image pre_image2=image2.getImage();
	Image pos_image2=pre_image2.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res2 = new ImageIcon(pos_image2);
	
	ImageIcon image3 = new ImageIcon("./restaurant_picture/롯데리아 김해어방점2.jpg");
	Image pre_image3=image3.getImage();
	Image pos_image3=pre_image3.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res3 = new ImageIcon(pos_image3);
	
	ImageIcon image4 = new ImageIcon("./restaurant_picture/롯데리아 김해어방점3.jpg");
	Image pre_image4=image4.getImage();
	Image pos_image4=pre_image4.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_res4 = new ImageIcon(pos_image4);
	
	JLabel res_picture1 = new JLabel(image2);
	JLabel res_picture2 = new JLabel(image3);
	JLabel res_picture3 = new JLabel(image4);
	
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
		
		res_picture1.setBounds(40,400,300,300);
		res_picture2.setBounds(350,400,300,300);
		res_picture3.setBounds(660,400,300,300);
		
		screen.add(label);
		screen.add(res_name);
		screen.add(res_review);
		
		screen.add(line);
		screen.add(res_menu);
		screen.add(res_information);
		screen.add(res_picture);
		
		screen.add(res_picture1);
		screen.add(res_picture2);
		screen.add(res_picture3);
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
	
	public RestaurantButton4_Picture(MainPage win)
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

