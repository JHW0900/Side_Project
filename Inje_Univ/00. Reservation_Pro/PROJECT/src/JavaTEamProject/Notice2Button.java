package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
	 
public class Notice2Button extends JPanel {
	private MainPage win;
	
	JLabel label = new JLabel("현재 공지사항");
	
	JLabel l_n = new JLabel("작성자");
	JLabel l_name = new JLabel("관리자");
	
	JLabel l_d = new JLabel("게시 날짜");
	JLabel l_days = new JLabel("2020.10.28");
	
	JLabel l_t = new JLabel("제목");
	JLabel l_title = new JLabel("[공지] 선결제 시스템 업데이트 안내");
	
	JLabel l_c = new JLabel("내용");
	JLabel l_contents = new JLabel("<html>안녕하세요. 선결제 예약 프로그램입니다."
									+ "<br>지난 10월 27일, 보다 안정적인 서비스 환경을 제공하기"
									+ "<br>위한 업데이트된 웹 버전이 출시 되었습니다."
									+ "<br>개선된 선결제 예약 프로그램을 이용하실 수 있도록 업데이트를"
									+ "<br>안내드리오니 많으 관심 부탁드립니다."
									+ "<br><br>앞으로도 더 나은 서비스를 위해 노력하는 선결제 시스템이 "
									+ "<br>될 수 있도록 항상 노력하겠습니다. "
									+ "<br><br>감사합니다.</html>");
	
	void setDisplay() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		label.setFont(new Font("고딕", Font.BOLD, 25));
		l_n.setFont(new Font("고딕", Font.BOLD, 25));
		l_name.setFont(new Font("고딕", Font.PLAIN, 25));
		l_d.setFont(new Font("고딕", Font.BOLD, 25));
		l_days.setFont(new Font("고딕", Font.PLAIN, 25));
		l_t.setFont(new Font("고딕", Font.BOLD, 25));
		l_title.setFont(new Font("고딕", Font.PLAIN, 25));
		l_c.setFont(new Font("고딕", Font.BOLD, 25));
		l_contents.setFont(new Font("고딕", Font.PLAIN, 22));
		
		l_n.setBackground(Color.LIGHT_GRAY);
		l_d.setBackground(Color.LIGHT_GRAY);
		l_t.setBackground(Color.LIGHT_GRAY);
		l_c.setBackground(Color.LIGHT_GRAY);
		
		l_n.setOpaque(true);
		l_d.setOpaque(true);
		l_t.setOpaque(true);
		l_c.setOpaque(true);
		
		
		l_n.setHorizontalAlignment(JLabel.CENTER);
		l_d.setHorizontalAlignment(JLabel.CENTER);
		l_t.setHorizontalAlignment(JLabel.CENTER);
		l_c.setHorizontalAlignment(JLabel.CENTER);
		
		label.setBounds(50,50,200,40);
		
		
		l_n.setBounds(50,150,200,40);
		l_name.setBounds(310,150,200,40);
		l_d.setBounds(450,150,200,40);
		l_days.setBounds(700,150,200,40);
		
		l_t.setBounds(50,200,200,40);
		l_title.setBounds(310,200,500,40);
		
		l_c.setBounds(50,250,200,450);
		l_contents.setBounds(310,200,800,550);
	}
	
	public Notice2Button(MainPage win) 
	{
		this.win = win;
		setLayout(null);
		add(label);
		add(l_n);
		add(l_name);
		add(l_d);
		add(l_days);
		add(l_t);
		add(l_title);
		add(l_c);
		add(l_contents);
		
		setDisplay();
	}

}

