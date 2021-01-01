package JavaTEamProject;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class EventButton extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	JLabel label = new JLabel("이벤트 진행중");
	
	//이벤트버튼 이미지 아이콘 이미지 받아오기

	ImageIcon image1 = new ImageIcon("./image/event1.png"); /// 여기 붙이면 됩ㄴ디ㅏ!!!
	ImageIcon image2 = new ImageIcon("./image/f1.png");
	ImageIcon image3 = new ImageIcon("./image/Sale_Event.png");
	
	//버튼에 넣을 이미지 받기
	Image pre_image1=image1.getImage();
	Image pre_image2=image2.getImage();
	Image pre_image3=image3.getImage();
	
	//이미지 사이즈 버튼사이즈로 맞추기
	Image pos_image1=pre_image1.getScaledInstance(600,200,java.awt.Image.SCALE_SMOOTH);
	Image pos_image2=pre_image2.getScaledInstance(600,200,java.awt.Image.SCALE_SMOOTH);
	Image pos_image3=pre_image3.getScaledInstance(600,200,java.awt.Image.SCALE_SMOOTH);
	
	//사이즈 맞춘 이미지 이미지 아이콘에 넣기
	ImageIcon event1 = new ImageIcon(pos_image1);
	ImageIcon event2 = new ImageIcon(pos_image2);
	ImageIcon event3 = new ImageIcon(pos_image3);
	
	//버튼에 이미지 넣기
	JButton button1 = new JButton(event1);
	JButton button2 = new JButton(event2);
	JButton button3 = new JButton(event3);
	
	public void setDisplay() 
	{
		String FontStyle = "고딕";
		int FontSize = 20;
		
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		// screen 라벨,버튼 폰트
		label.setFont(new Font(FontStyle, Font.BOLD, 25));
		button1.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		button2.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		button3.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		
		screen.add(button1);
		screen.add(button2);
		screen.add(button3);
		
		//버튼 테두리 없애기
		button1.setBorder(null);
		button2.setBorder(null);
		button3.setBorder(null);
		
		// screen 라벨,버튼 위치 조정
		label.setBounds(425,10,600,100);
		button1.setBounds(180,100,610,200);
		button2.setBounds(190,310,600,200);
		button3.setBounds(190,520,600,200);
		
		// 버튼 채우기 제거
		button1.setContentAreaFilled(false);
		button2.setContentAreaFilled(false); 
		button3.setContentAreaFilled(false); 
		//button4.setContentAreaFilled(false); 
		
		// screen 패널에 버튼 등록
		screen.add(label);
		screen.add(button1);
		screen.add(button2);
		screen.add(button3);
	}
	
	public EventButton(MainPage win)
	{
		this.win = win;
		setLayout(null);
		setBackground(new Color(223, 249, 251));
		setDisplay();
		add(label);
		add(button1);
		add(button2);
		add(button3);
		setVisible(true);
	}
}

