package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DataBase.*;

// event ó���Ϸ��� implements ActionListener �߰��ؾ���
public class MyPageButton extends JPanel {
	private MainPage win;
	
	dbConnect dbConn;

	String usrId;
	
	dbLogin dbl = new dbLogin();
	
	JPanel screen = new JPanel();

	JLabel label = new JLabel("��������");
	JLabel name = new JLabel("��                   �� : ");
	JLabel sex = new JLabel("��                   �� : ");
	JLabel mail = new JLabel("��        ��        �� : ");
	JLabel id = new JLabel("��        ��        �� : ");
	JLabel pwn = new JLabel("����    ��й�ȣ  : ");
	JLabel pwc = new JLabel("������ ��й�ȣ : ");
	JLabel phone = new JLabel("��   ȭ   ��   ȣ   : ");
	JLabel card = new JLabel("ī   ��   ��   ��   : ");

	JTextField tfName = new JTextField(10);
	JTextField tfSex = new JTextField(10);
	JTextField tfMail = new JTextField(10);
	JTextField tfId = new JTextField(10);
	JTextField tfPwn = new JTextField(10);
	JTextField tfPwc = new JTextField(10);
	JTextField tfPhone = new JTextField(10);
	JTextField tfCard = new JTextField(10);

	JButton change = new JButton("ȸ�� ���� ����");
	JButton	delete = new JButton("ȸ�� Ż��");
	
	String FontStyle;

	int FontSize;
	int F_ColorR;
	int F_ColorG;
	int F_ColorB;

	public void setFont() { /* ���� ��Ʈ �� �� ���� */
		FontStyle = "���";

		FontSize = 20;

		F_ColorR = 34;
		F_ColorG = 166;
		F_ColorB = 179;
	}

	public void setDisplay() { /* ������ ��ġ �� ��ġ ���� */
		setSize(1020, 800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		screen.setBackground(new Color(223, 249, 251));
		
		//centerPanel.setLayout(new GridLayout(9, 4, 0, 20));
		//southPanel.setLayout(new GridLayout(1, 3, 0, 20));

		//centerPanel.setBackground(new Color(223, 249, 251));
		//southPanel.setBackground(new Color(223, 249, 251));

		// centerPanel �гο� �� �� �ؽ�Ʈ �ڽ� ���
		//centerPanel.add(new JLabel());
		
		
		label.setBounds(50,50,400,40);
		
		name.setHorizontalAlignment(JLabel.RIGHT);
		sex.setHorizontalAlignment(JLabel.RIGHT);
		mail.setHorizontalAlignment(JLabel.RIGHT);
		id.setHorizontalAlignment(JLabel.RIGHT);
		pwn.setHorizontalAlignment(JLabel.RIGHT);
		pwc.setHorizontalAlignment(JLabel.RIGHT);
		phone.setHorizontalAlignment(JLabel.RIGHT);
		card.setHorizontalAlignment(JLabel.RIGHT);
		
		name.setBounds(100,120,200,40);
		sex.setBounds(100,190,200,40);
		mail.setBounds(100,260,200,40);
		id.setBounds(100,330,200,40);
		pwn.setBounds(100,400,200,40);
		pwc.setBounds(100,470,200,40);
		phone.setBounds(100,540,200,40);
		card.setBounds(97,610,300,40);
		
		
		
		tfName.setBounds(400,120,300,40);
		tfSex.setBounds(400,190,300,40);
		tfMail.setBounds(400,260,300,40);
		tfId.setBounds(400,330,300,40);
		tfPwn.setBounds(400,400,300,40);
		tfPwc.setBounds(400,470,300,40);
		tfPhone.setBounds(400,540,300,40);
		tfCard.setBounds(400,610,300,40);

		tfName.setEditable(false);
		tfSex.setEditable(false);
		tfMail.setEditable(false);
		tfId.setEditable(false);
		
		change.setBounds(150,680,250,50);
		delete.setBounds(450,680,250,50);
		
		screen.add(label);
		
		screen.add(name);
		screen.add(tfName);
		
		screen.add(sex);
		screen.add(tfSex);
		
		screen.add(mail);
		screen.add(tfMail);
		
		screen.add(id);
		screen.add(tfId);
		
		screen.add(pwn);
		screen.add(tfPwn);
		
		screen.add(pwc);
		screen.add(tfPwc);
		
		screen.add(phone);
		screen.add(tfPhone);
		
		screen.add(card);
		screen.add(tfCard);
		
		screen.add(change);
		screen.add(delete);
	}

	public void setDesign() { /* �ش� ������ ������ */
		setBackground(new Color(223, 249, 251));

		// screen ��,��Ʈ ��Ʈ
		label.setFont(new Font(FontStyle, Font.BOLD, 25));
		name.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		sex.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		mail.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		id.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		pwn.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		pwc.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		phone.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		card.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		
		change.setFont(new Font(FontStyle, Font.BOLD, 26));
		delete.setFont(new Font(FontStyle, Font.BOLD, 26));

		change.setBackground(new Color(F_ColorR, F_ColorG, F_ColorB));
		delete.setBackground(new Color(F_ColorR, F_ColorG, F_ColorB));
		
		change.setForeground(Color.WHITE);
		delete.setForeground(Color.WHITE);

		name.setHorizontalAlignment(JLabel.CENTER);
		sex.setHorizontalAlignment(JLabel.CENTER);
		mail.setHorizontalAlignment(JLabel.CENTER);
		id.setHorizontalAlignment(JLabel.CENTER);
		pwn.setHorizontalAlignment(JLabel.CENTER);
		pwc.setHorizontalAlignment(JLabel.CENTER);
		phone.setHorizontalAlignment(JLabel.CENTER);
		card.setHorizontalAlignment(JLabel.CENTER);
	}

	public void readInfo() {
		usrId = win.getUserId();
		
		label.setText(dbl.getUserName(usrId) + "���� ��������");
		
		tfName.setText(dbl.getUserName(usrId));
		
		if (dbl.getUserSex(usrId).equals("1"))
			tfSex.setText("Male");
		else if (dbl.getUserSex(usrId).equals("0"))
			tfSex.setText("Female");
		
		tfMail.setText(dbl.getUserMail(usrId));
		
		tfId.setText(dbl.getUserId(usrId));
		
		tfPhone.setText(dbl.getUserTel(usrId));
		card.setText("ī   ��   ��   ��   :   " + dbl.getUserCcom(usrId) + "����");
		tfCard.setText(dbl.getUserCard(usrId));
	}
	
	public void setListener() {
		change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfPwn.getText().equals(dbl.getUserPw(usrId))) {
					if (tfPwc.getText().length() != 0) {
						dbl.editPassword(usrId, tfPwc.getText());
					}
					dbl.editPhone(usrId, tfPhone.getText());
					dbl.editCard(usrId, tfCard.getText());
					
					String messageOption = "���������� ����Ǿ����ϴ�!";
					JOptionPane.showMessageDialog(null, messageOption);
					
					tfPwn.setText("");
					tfPwc.setText("");
					
					win.panelChange("HomeButton");
				}
				else if(tfPwn.getText().length() == 0) {
					String messageOption = "���� ��й�ȣ�� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else {
					String messageOption = "�߸��� ��й�ȣ�Դϴ�.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfPwn.getText().equals(dbl.getUserPw(usrId))) {
					if (tfId.getText().equals(dbl.getUserId(usrId))) {

						dbl.delete(win.getUserId());
						System.out.println("���� ���õ�");
						String messageOption = "ȸ��Ż�� �Ϸ�Ǿ����ϴ�!";
						JOptionPane.showMessageDialog(null, messageOption);
						win.panelChange("HomeButton");
						win.HB_Logout();
					} else {
						String messageOption = "ȸ��Ż�� �Ұ����� �����Դϴ�";
						JOptionPane.showMessageDialog(null, messageOption);
					}
				}
				else if(tfPwn.getText().length() == 0) {
					String messageOption = "���� ��й�ȣ�� �Է����ּ���.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
				else {
					String messageOption = "�߸��� ��й�ȣ�Դϴ�.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
			}
		});
		
	}

	public MyPageButton(MainPage win) {
		this.win = win;
		setLayout(null);
		
		setDisplay();
		setListener();
		setFont();
		setDesign();
		add(screen);

		validate();
	}
}