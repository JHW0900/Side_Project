package JavaTEamProject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Vector;
	 
public class studyButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//변경할 아이콘 이미지 들고오기
	ImageIcon I_st1 = new ImageIcon("./store_logo/공부신.png");
	ImageIcon I_st2 = new ImageIcon("./store_logo/다솔로고.jpg");
	ImageIcon I_st3 = new ImageIcon("./store_logo/지니24.PNG");
	ImageIcon I_st4 = new ImageIcon("./store_logo/르하임.PNG");
		
	//ImageIcon으로 들고온 이미지 변환하기(변경할이미지)
	Image pre_st1 = I_st1.getImage();
	Image pre_st2 = I_st2.getImage();
	Image pre_st3 = I_st3.getImage();
	Image pre_st4 = I_st4.getImage();
		
	//이미지 사이즈 버튼에 맞춰서 변경하기(변경된이미지)
	Image pos_st1 = pre_st1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_st2 = pre_st2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_st3 = pre_st3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_st4 = pre_st4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//변경된이미지로 아이콘 변경하기(Image로 아이콘 생성)
	ImageIcon st1 = new ImageIcon(pos_st1);
	ImageIcon st2 = new ImageIcon(pos_st2);
	ImageIcon st3 = new ImageIcon(pos_st3);
	ImageIcon st4 = new ImageIcon(pos_st4);

	
	JButton b_st1 = new JButton("<html>&emsp&emsp&emsp&emsp공부의 신 독서실<br>&emsp&emsp&emsp&emsp평점 : 3.32<br>&emsp&emsp&emsp&emsp영업시간 : 09:00 ~ 01:00</html>", st1);
	JButton b_st2 = new JButton("<html>&emsp&emsp&emsp&emsp다솔 독서실<br>&emsp&emsp&emsp&emsp평점 : 3.89<br>&emsp&emsp&emsp&emsp영업시간 : 09:00 ~ 01:30</html>", st2);
	JButton b_st3 = new JButton("<html>&emsp&emsp&emsp&emsp지니 24 스터디카페<br>&emsp&emsp&emsp&emsp김해인제대점<br>&emsp&emsp&emsp&emsp평점 : 4.94<br>&emsp&emsp&emsp&emsp영업시간 : 00:00 ~ 24:00</html>", st3);
	JButton b_st4 = new JButton("<html>&emsp&emsp&emsp&emsp르하임 스터디카페<br>&emsp&emsp&emsp&emsp김해인제대점<br>&emsp&emsp&emsp&emsp평점 : 4.96<br>&emsp&emsp&emsp&emsp영업시간 : 00:00 ~ 24:00</html>", st4);
	
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_st1.setFont(new Font("고딕", Font.BOLD, 25));
		b_st2.setFont(new Font("고딕", Font.BOLD, 25));
		b_st3.setFont(new Font("고딕", Font.BOLD, 25));
		b_st4.setFont(new Font("고딕", Font.BOLD, 25));

		
		b_st1.setBackground(Color.white);
		b_st2.setBackground(Color.white);
		b_st3.setBackground(Color.white);
		b_st4.setBackground(Color.white);
		
		b_st1.setHorizontalAlignment(SwingConstants.CENTER);
		b_st2.setHorizontalAlignment(SwingConstants.CENTER);
		b_st3.setHorizontalAlignment(SwingConstants.CENTER);
		b_st4.setHorizontalAlignment(SwingConstants.CENTER);
		
		// screen 패널에 버튼 등록
		screen.add(b_st1);
		screen.add(b_st2);
		screen.add(b_st3);
		screen.add(b_st4);
	}
	
	public void studyButtonListener()
	{
		b_st1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_Button");
			}
		});
		b_st2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_Button");
			}
		});
		b_st3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study3_Button");
			}
		});
		b_st4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study4_Button");
			}
		});
	}
	
	public studyButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();
		
		add(b_st1);
		add(b_st2);
		add(b_st3);
		add(b_st4);
		studyButtonListener();
		setVisible(true);
	}
}