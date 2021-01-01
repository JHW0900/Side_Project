package JavaTEamProject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.*;

import DataBase.*;
public class OrderListButton extends JPanel{
	private MainPage win;
	dbReservation DBReservation = new dbReservation();
	dbService DBService = new dbService();
	
	SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd");
	Date time = new Date();
	
	String time0 = format.format(time);
	
	JPanel screen = new JPanel();
	
	JLabel label = new JLabel("���� ���� ����");
	
	JLabel line1 = new JLabel("-----------------------------------------------------------------------------------------------------------");
	JLabel rv_day = new JLabel(time0);  // DB���� ��¥ �޾ƿ���
	JLabel line2 = new JLabel("----------------------------------------------------------------------------------------------------------------");
	
	ImageIcon image = new ImageIcon("./image/reserved.png");
	Image pre_image=image.getImage();
	Image pos_image=pre_image.getScaledInstance(200,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_image = new ImageIcon(pos_image);
	JLabel rv_image = new JLabel(I_image);
	
	JLabel rv_p = new JLabel("���� ���     :");
	JLabel rv_place = new JLabel("�������� ��������"); // DB���� ��� �޾ƿ���
	JLabel rv_s = new JLabel("�¼� ��ȣ     :");
	JLabel rv_seat = new JLabel("6"); // DB���� �¼� ��ȣ �޾ƿ���
	
	JLabel rv_m = new JLabel("�� �ݾ�        :");
	JLabel rv_money = new JLabel("5000��");
	
	JLabel rv_notice = new JLabel("<html>������ �Ϸ�Ǿ����ϴ�. �̿����ּż� �����մϴ�."
								+ "<br>�� ����ϴ� ������ ���� ���α׷��� �ǰڽ��ϴ�.</html>");
	
	public void setDisplay() {	
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		line1.setForeground(new Color(126,214,223));
		line2.setForeground(new Color(126,214,223));
		
		// screen �� ��ġ ����
		label.setBounds(50,50,200,40);	

		line1.setBounds(0,150,480,20);
		rv_day.setBorder(BorderFactory.createLineBorder(new Color(126,214,223), 1, true));
		rv_day.setBounds(430,140,140,40);
		line2.setBounds(568,150,500,20);
		
		rv_image.setBounds(100,270,200,200);
		
		rv_p.setBounds(400,280,200,20);
		rv_place.setBounds(550,280,300,20);
		rv_s.setBounds(400,360,200,20);
		rv_seat.setBounds(550,360,300,20);
		rv_m.setBounds(400,440,200,20);
		rv_money.setBounds(550,440,300,20);
		
		rv_notice.setBounds(250,530,800,60);
		
		// screen �гο� ��ư ���
		screen.add(label);

		screen.add(rv_seat);
		screen.add(line1);
		screen.add(rv_day);
		screen.add(line2);
		screen.add(rv_image);
		
		screen.add(rv_p);
		screen.add(rv_place);
		screen.add(rv_s);
		screen.add(rv_seat);
		screen.add(rv_m);
		screen.add(rv_money);
		
		screen.add(rv_notice);
		
	}
	
	public void setDesign() { /* �ش� ������ ������ */
		screen.setBackground(new Color(223, 249, 251));
		
		// screen ��,��Ʈ ��Ʈ
		label.setFont(new Font("���", Font.BOLD, 25));
		
		rv_day.setFont(new Font("���", Font.BOLD, 23));
		rv_seat.setFont(new Font("���", Font.BOLD, 20));
		rv_place.setFont(new Font("���", Font.BOLD, 20));
		rv_money.setFont(new Font("���", Font.BOLD, 20));
		rv_s.setFont(new Font("���", Font.BOLD, 20));
		rv_p.setFont(new Font("���", Font.BOLD, 20));
		rv_m.setFont(new Font("���", Font.BOLD, 20));
		rv_notice.setFont(new Font("���", Font.BOLD, 20));
		
		screen.setBackground(new Color(223, 249, 251));
	}

	public OrderListButton(MainPage win)
	{
		this.win = win;
		setLayout(null);
		
		setDisplay();
		setDesign();
		validate();

		add(screen);
	}
	
	public void setLabel() {
		String name = DBService.getServiceName(DBReservation.getService(win.getUserId()));
		String seat = Integer.toString(DBReservation.getSeatNum(win.getUserId()));
		
		rv_place.setText(name);
		rv_seat.setText(seat);
	}
}