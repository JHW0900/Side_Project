package StudyButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class StudyButton1_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./study_picture/공부의신 독서실.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_study1);
	
	JLabel study_name = new JLabel("공부의신 독서실");
	JLabel study_review = new JLabel("평점 : 3.32");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton study_menu = new JButton("메뉴");
	JButton study_information = new JButton("정보");
	JButton study_picture = new JButton("사진");
	
	// 정보
	JLabel time = new JLabel("운영시간 : 매일 10:00 ~ 03:00");
	JLabel holiday = new JLabel("휴무일    : 연중무휴");
	JLabel phone = new JLabel("전화번호 :  055-326-1310");
	JLabel location = new JLabel("위치정보 : 경남 김해시 삼안로 309 가야청");
	JLabel introduce = new JLabel("<html>가게소개 : 인제대 공부의신 독서실입니다^^<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;남여구분 / 학생성인구분"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일인실 / 다인실(커튼) / 컴퓨터실 / 무선인터넷</html>");
	
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
		study_name.setBounds(420,200,400,50);
		study_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		study_menu.setBounds(50,290,200,50);
		study_information.setBounds(400,290,200,50);
		study_picture.setBounds(750,290,200,50);
		
		time.setBounds(50,400,500,50);
		holiday.setBounds(50,450,500,50);
		phone.setBounds(50,500,500,50);
		location.setBounds(50,550,500,50);
		introduce.setBounds(50,600,1000,100);
		
		screen.add(label);
		screen.add(study_name);
		screen.add(study_review);
		
		screen.add(line);
		screen.add(study_menu);
		screen.add(study_information);
		screen.add(study_picture);
		
		screen.add(time);
		screen.add(holiday);
		screen.add(phone);
		screen.add(location);
		screen.add(introduce);
	}
	
	public void StudyButton1Listener() {
		study_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_menu_Button");
			}
		});
		study_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_information_Button");
			}
		});
		study_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_picture_Button");
			}
		});
	}
	
	public StudyButton1_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		StudyButton1Listener();
		setVisible(true);
	}
}
