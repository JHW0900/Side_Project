package PCButton;

import JavaTEamProject.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class PCButton2_Information extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page에 나오는 사진 
	ImageIcon image1 = new ImageIcon("./pc_picture/인스타pc카페 인제대점.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_pc1 = new ImageIcon(pos_image1);
		
	// 사진 담을 라벨 생성
	JLabel label = new JLabel(I_pc1);
	
	JLabel pc_name = new JLabel("인스타pc카페 인제대점");
	JLabel pc_review = new JLabel("평점 : 4.28");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton pc_menu = new JButton("메뉴");
	JButton pc_information = new JButton("정보");
	JButton pc_picture = new JButton("사진");
	
	// 정보
	JLabel time = new JLabel("운영시간 : 매일 00:00 ~ 24:00");
	JLabel holiday = new JLabel("휴무일    : 연중무휴");
	JLabel phone = new JLabel("전화번호 : x");
	JLabel location = new JLabel("위치정보 : 경남 김해시 인제로169번길 27");
	JLabel introduce = new JLabel("<html>가게소개 : 넓은 좌석 깨끄한 환경 그리고 맛있는 음식까지!<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;인제대주변 인스타pc카페!	"
								+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게임을 좋아하시는 분들은 최적의 환경의 PC방입니다~</html>");
	
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
		pc_name.setBounds(410,200,300,50);
		pc_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		pc_menu.setBounds(50,290,200,50);
		pc_information.setBounds(400,290,200,50);
		pc_picture.setBounds(750,290,200,50);
		
		time.setBounds(50,400,500,50);
		holiday.setBounds(50,450,500,50);
		phone.setBounds(50,500,500,50);
		location.setBounds(50,550,500,50);
		introduce.setBounds(50,600,1000,100);
		
		screen.add(label);
		screen.add(pc_name);
		screen.add(pc_review);
		
		screen.add(line);
		screen.add(pc_menu);
		screen.add(pc_information);
		screen.add(pc_picture);
		
		screen.add(time);
		screen.add(holiday);
		screen.add(phone);
		screen.add(location);
		screen.add(introduce);
	}
	
	public void PCButton2ButtonListener() {
		pc_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pc2_menu_Button");
			}
		});
		pc_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pc2_information_Button");
			}
		});
		pc_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pc2_picture_Button");
			}
		});
	}
	
	public PCButton2_Information(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		PCButton2ButtonListener();
		setVisible(true);
	}
}

