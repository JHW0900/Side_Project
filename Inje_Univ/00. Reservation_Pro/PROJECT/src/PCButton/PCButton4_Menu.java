package PCButton;

import JavaTEamProject.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class PCButton4_Menu extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./pc_picture/인싸이더pc카페 2호점.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_pc1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_pc1);
	
	JLabel pc_name = new JLabel("인싸이더pc카페 2호점");
	JLabel pc_review = new JLabel("평점 : 4.55");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton pc_menu = new JButton("메뉴");
	JButton pc_information = new JButton("정보");
	JButton pc_picture = new JButton("사진");
	
	// 메뉴
	ImageIcon example = new ImageIcon("./menu_image/인싸이더pc메뉴.png");
	Image pre_ex1=example.getImage();
	Image pos_ex1=pre_ex1.getScaledInstance(900,280,java.awt.Image.SCALE_SMOOTH);
	ImageIcon exam = new ImageIcon(pos_ex1);
	
	JLabel ex = new JLabel(exam);
	
	// 예약하기 버튼
	JButton reservation = new JButton("예약하기");
	
	public void setFont()
	{
		pc_name.setFont(new Font("고딕", Font.BOLD, 20));
		pc_review.setFont(new Font("고딕", Font.PLAIN, 15));
		pc_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		pc_menu.setFont(new Font("고딕", Font.PLAIN, 18));
		pc_information.setFont(new Font("고딕", Font.PLAIN, 18));
		pc_picture.setFont(new Font("고딕", Font.PLAIN, 18));
		
		pc_menu.setBackground(Color.WHITE);
		pc_information.setBackground(Color.WHITE);
		pc_picture.setBackground(Color.WHITE);
		
		reservation.setFont(new Font("고딕", Font.PLAIN, 18));
	}
	public void setDisplay() 
	{
		screen.setLayout(null);
		screen.setSize(1020, 800);

		label.setBounds(0,0,1000,200);
		pc_name.setBounds(410,200,300,50);
		pc_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		pc_menu.setBounds(50,290,200,50);
		pc_information.setBounds(400,290,200,50);
		pc_picture.setBounds(750,290,200,50);
		
		ex.setBounds(50,220,900,600);
		reservation.setBackground(new Color(34, 166, 179));
		reservation.setForeground(Color.WHITE);
		reservation.setFont(new Font("고딕", Font.BOLD, 20));
		
		
		reservation.setBounds(50,680,900,50);
		
		screen.add(label);
		screen.add(pc_name);
		screen.add(pc_review);
		
		screen.add(line);
		screen.add(pc_menu);
		screen.add(pc_information);
		screen.add(pc_picture);
		
		screen.add(ex);
		screen.add(reservation);
	}
	
	public void PCButton4ButtonListener() {
		pc_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pc4_menu_Button");
			}
		});
		pc_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pc4_information_Button");
			}
		});
		pc_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pc4_picture_Button");
			}
		});
		reservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.setService(1016, 15);
			}
		});
	}
	
	public PCButton4_Menu(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		PCButton4ButtonListener();
		setVisible(true);
	}
}