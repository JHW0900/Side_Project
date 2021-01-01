package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
	 
public class Notice3Button extends JPanel {
	private MainPage win;
	
	JLabel label = new JLabel("현재 공지사항");
	
	JLabel l_n = new JLabel("작성자");
	JLabel l_name = new JLabel("관리자");
	
	JLabel l_d = new JLabel("게시 날짜");
	JLabel l_days = new JLabel("2020.11.01");
	
	JLabel l_t = new JLabel("제목");
	JLabel l_title = new JLabel("[공지] 선결제 서비스 정상화 안내");
	
	JLabel l_c = new JLabel("내용");
	JLabel l_contents = new JLabel("<html>고객님, 선결제 예약 프로그램입니다."
									+ "<br>금일 오후부터 선결제 서비스에서 이용하는 웹 설정 문제로"
									+ "<br>인해 서비스 이용이 원할하지 않았습니다."
									+ "<br><br>현재는 수정이 완료되었으며 모든 서비스를 정상적으로 이용하실"
									+ "<br>수 있습니다. 이용에 불편을 드려 죄송합니다."
									+ "<br>안정적인 서비스를 제공하기 위해 계속 노력하는 선결제 "
									+ "<br>예약 프로그램이 될 수 있도록 항상 노력하겠습니다.</html>");
	
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
		l_title.setBounds(310,200,400,40);
		
		l_c.setBounds(50,250,200,450);
		l_contents.setBounds(310,200,800,550);
	}
	
	public Notice3Button(MainPage win)
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

