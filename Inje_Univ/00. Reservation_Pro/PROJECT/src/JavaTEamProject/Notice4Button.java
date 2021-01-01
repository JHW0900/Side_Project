package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
	 
public class Notice4Button extends JPanel {
	private MainPage win;
	
	JLabel label = new JLabel("현재 공지사항");
	
	JLabel l_n = new JLabel("작성자");
	JLabel l_name = new JLabel("관리자");
	
	JLabel l_d = new JLabel("게시 날짜");
	JLabel l_days = new JLabel("2020.11.04");
	
	JLabel l_t = new JLabel("제목");
	JLabel l_title = new JLabel("[공지] 선결제 시스템 정기점검(11/05~11/06)");
	
	JLabel l_c = new JLabel("내용");
	JLabel l_contents = new JLabel("<html>안녕하세요. 선결제 예약 프로그램입니다."
									+ "<br><br>2020년 11월 정기점검이 진행될 예정으로 안내해 드립니다."
									+ "<br>점검 중에는 시스템의 결제 서비스가 제한될 예정이며,"
									+ "<br>이외의 서비스는 정상적으로 이용가능합니다."
									+ "<br><br>■ 11월 정기점검 안내"
									+ "<br>&nbsp - 점검일시 : <font color= red><strong>2020년 11월 5일(목) ~ 2020년 11월 6일(금)(약 2일)</strong></font>"
									+ "<br>&nbsp - 점검내용 : 시스템 정기 점검 및 결제 서비스 개선"
									+ "<br><br>더 나은 선결제 예약 프로그램이 "
									+ "<br>될 수 있도록 항상 노력하겠습니다.</html>");
	
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
	
	public Notice4Button(MainPage win)
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

