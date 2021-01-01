package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
	 
public class pcButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//변경할 아이콘 이미지 들고오기
	ImageIcon I_pc1 = new ImageIcon("./store_logo/라이킷로고.jpg");
	ImageIcon I_pc2 = new ImageIcon("./store_logo/인스타pc.jpg");
	ImageIcon I_pc3 = new ImageIcon("./store_logo/인싸이더.jpg");
	ImageIcon I_pc4 = new ImageIcon("./store_logo/인싸이더.jpg");
		
	//ImageIcon으로 들고온 이미지 변환하기(변경할이미지)
	Image pre_pc1 = I_pc1.getImage();
	Image pre_pc2 = I_pc2.getImage();
	Image pre_pc3 = I_pc3.getImage();
	Image pre_pc4 = I_pc4.getImage();
		
	//이미지 사이즈 버튼에 맞춰서 변경하기(변경된이미지)
	Image pos_pc1 = pre_pc1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_pc2 = pre_pc2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_pc3 = pre_pc3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_pc4 = pre_pc4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//변경된이미지로 아이콘 변경하기(Image로 아이콘 생성)
	ImageIcon pc1 = new ImageIcon(pos_pc1);
	ImageIcon pc2 = new ImageIcon(pos_pc2);
	ImageIcon pc3 = new ImageIcon(pos_pc3);
	ImageIcon pc4 = new ImageIcon(pos_pc4);
		
	
	JButton b_pc1 = new JButton("<html>&emsp&emsp&emsp&emsp라이킷 PC 김해 삼방점<br>&emsp&emsp&emsp&emsp평점 : 4.35<br>&emsp&emsp&emsp&emsp영업시간 : 00:00 ~ 24:00</html>", pc1);
	JButton b_pc2 = new JButton("<html>&emsp&emsp&emsp&emsp인스타 PC카페 인제대점<br>&emsp&emsp&emsp&emsp평점 : 4.28<br>&emsp&emsp&emsp&emsp영업시간 : 00:00 ~ 24:00</html>", pc2);
	JButton b_pc3 = new JButton("<html>&emsp&emsp&emsp&emsp인싸이더 PC카페 1호점<br>&emsp&emsp&emsp&emsp평점 : 4.58<br>&emsp&emsp&emsp&emsp영업시간 : 00:00 ~ 24:00</html>", pc3);
	JButton b_pc4 = new JButton("<html>&emsp&emsp&emsp&emsp인싸이더 PC카페 2호점<br>&emsp&emsp&emsp&emsp평점 : 4.55<br>&emsp&emsp&emsp&emsp영업시간 : 00:00 ~ 24:00</html>", pc4);
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_pc1.setFont(new Font("고딕", Font.BOLD, 25));
		b_pc2.setFont(new Font("고딕", Font.BOLD, 25));
		b_pc3.setFont(new Font("고딕", Font.BOLD, 25));
		b_pc4.setFont(new Font("고딕", Font.BOLD, 25));
		
		
		b_pc1.setBackground(Color.white);
		b_pc2.setBackground(Color.white);
		b_pc3.setBackground(Color.white);
		b_pc4.setBackground(Color.white);
		
		// screen 패널에 버튼 등록
		screen.add(b_pc1);
		screen.add(b_pc2);
		screen.add(b_pc3);
		screen.add(b_pc4);
	}
	
	public void pcButtonListener()
	{
		b_pc1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc1_Button");
			}
		});
		b_pc2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc2_Button");
			}
		});
		b_pc3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc3_Button");
			}
		});
		b_pc4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc4_Button");
			}
		});
	}
	
	
	public pcButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();
		
		add(b_pc1);
		add(b_pc2);
		add(b_pc3);
		add(b_pc4);
		pcButtonListener();
		setVisible(true);
	}
}