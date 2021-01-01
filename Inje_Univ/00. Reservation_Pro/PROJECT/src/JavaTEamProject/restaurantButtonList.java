package JavaTEamProject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Vector;
	 
public class restaurantButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//변경할 아이콘 이미지 들고오기
	ImageIcon I_re1 = new ImageIcon("./store_logo/코이코이.jpg");
	ImageIcon I_re2 = new ImageIcon("./store_logo/유키.jpg");
	ImageIcon I_re3 = new ImageIcon("./store_logo/청년다방.jpg");
	ImageIcon I_re4 = new ImageIcon("./store_logo/롯데리아.png");
		
	//ImageIcon으로 들고온 이미지 변환하기(변경할이미지)
	Image pre_re1 = I_re1.getImage();
	Image pre_re2 = I_re2.getImage();
	Image pre_re3 = I_re3.getImage();
	Image pre_re4 = I_re4.getImage();
		
	//이미지 사이즈 버튼에 맞춰서 변경하기(변경된이미지)
	Image pos_re1 = pre_re1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_re2 = pre_re2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_re3 = pre_re3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_re4 = pre_re4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//변경된이미지로 아이콘 변경하기(Image로 아이콘 생성)
	ImageIcon re1 = new ImageIcon(pos_re1);
	ImageIcon re2 = new ImageIcon(pos_re2);
	ImageIcon re3 = new ImageIcon(pos_re3);
	ImageIcon re4 = new ImageIcon(pos_re4);
		
	//JLabel l_pc = new JLabel(pc);
	//JLabel l_sing = new JLabel(sing);
	//JLabel l_study = new JLabel(study);
	//JLabel l_restaurant = new JLabel(restaurant);
	
	JButton b_re1 = new JButton("<html>&emsp&emsp&emsp&emsp코이코이 인제대점<br>&emsp&emsp&emsp&emsp평점 : 4.6<br>&emsp&emsp&emsp&emsp영업시간 : 11:30 ~ 21:00</html>", re1);
	JButton b_re2 = new JButton("<html>&emsp&emsp&emsp&emsp유키 돈까스 인제대점<br>&emsp&emsp&emsp&emsp평점 : 4.53<br>&emsp&emsp&emsp&emsp영업시간 : 11:00 ~ 21:00</html>", re2);
	JButton b_re3 = new JButton("<html>&emsp&emsp&emsp&emsp청년다방 인제대점<br>&emsp&emsp&emsp&emsp평점 : 4.44<br>&emsp&emsp&emsp&emsp영업시간 : 11:00 ~ 24:00</html>", re3);
	JButton b_re4 = new JButton("<html>&emsp&emsp&emsp&emsp롯데리아 김해어방점<br>&emsp&emsp&emsp&emsp평점 : 4.35<br>&emsp&emsp&emsp&emsp영업시간 : 10:00 ~ 22:00</html>", re4);
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_re1.setFont(new Font("고딕", Font.BOLD, 25));
		b_re2.setFont(new Font("고딕", Font.BOLD, 25));
		b_re3.setFont(new Font("고딕", Font.BOLD, 25));
		b_re4.setFont(new Font("고딕", Font.BOLD, 25));
		
		//l_pc.setBackground(Color.white);
		//l_sing.setBackground(Color.white);
		//l_study.setBackground(Color.white);
		//l_restaurant.setBackground(Color.white);
		
		//l_pc.setOpaque(true);
		//l_sing.setOpaque(true);
		//l_study.setOpaque(true);
		//l_restaurant.setOpaque(true);
		
		b_re1.setBackground(Color.white);
		b_re2.setBackground(Color.white);
		b_re3.setBackground(Color.white);
		b_re4.setBackground(Color.white);
		
		// screen 패널에 버튼 등록
		screen.add(b_re1);
		screen.add(b_re2);
		screen.add(b_re3);
		screen.add(b_re4);
	}
	
	public void restaurantButtonListener()
	{
		b_re1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant1_Button");
			}
		});
		b_re2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant2_Button");
			}
		});
		b_re3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant3_Button");
			}
		});
		b_re4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant4_Button");
			}
		});
	}
	
	public restaurantButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();

		add(b_re1);
		add(b_re2);
		add(b_re3);
		add(b_re4);
		
		restaurantButtonListener();
		
		setVisible(true);
	}
}