package StudyButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class StudyButton2_Picture extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./study_picture/다솔 독서실.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_study1);
	
	JLabel study_name = new JLabel("다솔 독서실");
	JLabel study_review = new JLabel("평점 : 3.89");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton study_menu = new JButton("메뉴");
	JButton study_information = new JButton("정보");
	JButton study_picture = new JButton("사진");
	
	// 사진
	ImageIcon image2 = new ImageIcon("./study_picture/다솔 독서실1.jpg");
	Image pre_image2=image2.getImage();
	Image pos_image2=pre_image2.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study2 = new ImageIcon(pos_image2);
	
	ImageIcon image3 = new ImageIcon("./study_picture/다솔 독서실2.jpg");
	Image pre_image3=image3.getImage();
	Image pos_image3=pre_image3.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study3 = new ImageIcon(pos_image3);
	
	ImageIcon image4 = new ImageIcon("./study_picture/다솔 독서실3.jpg");
	Image pre_image4=image4.getImage();
	Image pos_image4=pre_image4.getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study4 = new ImageIcon(pos_image4);
	
	JLabel study_picture1 = new JLabel(image2);
	JLabel study_picture2 = new JLabel(image3);
	JLabel study_picture3 = new JLabel(image4);
	
	public void setFont()
	{
		study_name.setFont(new Font("고딕", Font.BOLD, 20));
		study_review.setFont(new Font("고딕", Font.PLAIN, 15));
		study_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		study_menu.setFont(new Font("고딕", Font.PLAIN, 18));
		study_information.setFont(new Font("고딕", Font.PLAIN, 18));
		study_picture.setFont(new Font("고딕", Font.PLAIN, 18));
		
		study_menu.setBackground(Color.WHITE);
		study_information.setBackground(Color.WHITE);
		study_picture.setBackground(Color.WHITE);
	}
	public void setDisplay() 
	{
		screen.setLayout(null);
		screen.setSize(1020, 800);

		label.setBounds(0,0,1000,200);
		study_name.setBounds(450,200,400,50);
		study_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		study_menu.setBounds(50,290,200,50);
		study_information.setBounds(400,290,200,50);
		study_picture.setBounds(750,290,200,50);
		
		study_picture1.setBounds(40,400,300,300);
		study_picture2.setBounds(350,400,300,300);
		study_picture3.setBounds(660,400,300,300);
		
		screen.add(label);
		screen.add(study_name);
		screen.add(study_review);
		
		screen.add(line);
		screen.add(study_menu);
		screen.add(study_information);
		screen.add(study_picture);
		
		screen.add(study_picture1);
		screen.add(study_picture2);
		screen.add(study_picture3);
	}
	
	public void StudyButton2Listener() {
		study_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_menu_Button");
			}
		});
		study_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_information_Button");
			}
		});
		study_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_picture_Button");
			}
		});
	}
	
	public StudyButton2_Picture(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		StudyButton2Listener();
		setVisible(true);
	}
}
