package SingButton;

import JavaTEamProject.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class SingButton1_Picture extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./sing_picture/락휴 코인노래연습장 김해 인제대점.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_sing1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_sing1);
	
	JLabel sing_name = new JLabel("락휴 코인노래연습장 김해 인제대점");
	JLabel sing_review = new JLabel("평점 : 3.99");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton sing_menu = new JButton("메뉴");
	JButton sing_information = new JButton("정보");
	JButton sing_picture = new JButton("사진");
	
	// 사진
	ImageIcon image2 = new ImageIcon("./sing_picture/락휴 코인노래연습장 김해 인제대점1.jpg");
	Image pre_image2=image2.getImage();
	Image pos_image2=pre_image2.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_sing2 = new ImageIcon(pos_image2);
	
	ImageIcon image3 = new ImageIcon("./sing_picture/락휴 코인노래연습장 김해 인제대점2.jpg");
	Image pre_image3=image3.getImage();
	Image pos_image3=pre_image3.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_sing3 = new ImageIcon(pos_image3);
	
	ImageIcon image4 = new ImageIcon("./sing_picture/락휴 코인노래연습장 김해 인제대점3.jpg");
	Image pre_image4=image4.getImage();
	Image pos_image4=pre_image4.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_sing4 = new ImageIcon(pos_image4);
	
	JLabel sing_picture1 = new JLabel(image2);
	JLabel sing_picture2 = new JLabel(image3);
	JLabel sing_picture3 = new JLabel(image4);
	
	public void setFont()
	{
		sing_name.setFont(new Font("고딕", Font.BOLD, 20));
		sing_review.setFont(new Font("고딕", Font.PLAIN, 15));
		sing_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		sing_menu.setFont(new Font("고딕", Font.PLAIN, 18));
		sing_information.setFont(new Font("고딕", Font.PLAIN, 18));
		sing_picture.setFont(new Font("고딕", Font.PLAIN, 18));
		
		sing_menu.setBackground(Color.WHITE);
		sing_information.setBackground(Color.WHITE);
		sing_picture.setBackground(Color.WHITE);
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
		
		sing_picture1.setBounds(40,400,300,300);
		sing_picture2.setBounds(350,400,300,300);
		sing_picture3.setBounds(660,400,300,300);
		
		screen.add(label);
		screen.add(sing_name);
		screen.add(sing_review);
		
		screen.add(line);
		screen.add(sing_menu);
		screen.add(sing_information);
		screen.add(sing_picture);
		
		screen.add(sing_picture1);
		screen.add(sing_picture2);
		screen.add(sing_picture3);
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
	
	public SingButton1_Picture(MainPage win)
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

