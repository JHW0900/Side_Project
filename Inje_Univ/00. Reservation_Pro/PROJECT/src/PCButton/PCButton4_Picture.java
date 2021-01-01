package PCButton;

import JavaTEamProject.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class PCButton4_Picture extends JPanel{
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
	
	// 사진
	ImageIcon image2 = new ImageIcon("./pc_picture/인싸이더pc카페 2호점1.jpg");
	Image pre_image2=image2.getImage();
	Image pos_image2=pre_image2.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_pc2 = new ImageIcon(pos_image2);
	
	ImageIcon image3 = new ImageIcon("./pc_picture/인싸이더pc카페 2호점2.jpg");
	Image pre_image3=image3.getImage();
	Image pos_image3=pre_image3.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_pc3 = new ImageIcon(pos_image3);
	
	ImageIcon image4 = new ImageIcon("./pc_picture/인싸이더pc카페 2호점3.jpg");
	Image pre_image4=image4.getImage();
	Image pos_image4=pre_image4.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_pc4 = new ImageIcon(pos_image4);
	
	JLabel pc_picture1 = new JLabel(image2);
	JLabel pc_picture2 = new JLabel(image3);
	JLabel pc_picture3 = new JLabel(image4);
	
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
		
		pc_picture1.setBounds(40,400,300,300);
		pc_picture2.setBounds(350,400,300,300);
		pc_picture3.setBounds(660,400,300,300);
		
		screen.add(label);
		screen.add(pc_name);
		screen.add(pc_review);
		
		screen.add(line);
		screen.add(pc_menu);
		screen.add(pc_information);
		screen.add(pc_picture);
		
		screen.add(pc_picture1);
		screen.add(pc_picture2);
		screen.add(pc_picture3);
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
	}
	
	public PCButton4_Picture(MainPage win)
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

