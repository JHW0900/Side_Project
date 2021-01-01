package JavaTEamProject;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import DataBase.*;


public class HomeButton extends JPanel{

	private MainPage win;
//	public restaurantButtonList res_Panel=null;
	boolean isLogined;

	
	HomeButton hm;
	
	dbService s = new dbService();
	
	dbLogin DBlogin = new dbLogin();
	String userName = "";
	
	JPanel p_category = new JPanel();
	JPanel p_search_login = new JPanel();
	JPanel baseLoginPanel = new JPanel();
	JPanel p_login = new JPanel();
	JPanel loginedPanel = new JPanel();
	Project p_ad = new Project(win);
	
	//ImageIcon I_pc = new ImageIcon("C:\\Users\\rkdtn\\OneDrive\\바탕 화면\\아이콘\\1\\computer1.png");
	//Image computer1 = I_pc.getImage();  //ImageIcon을 Image로 변환.
	//Image comi = computer1.getScaledInstance(240, 160, java.awt.Image.SCALE_SMOOTH);
	//ImageIcon pc = new ImageIcon(comi); //Image로 ImageIcon 생성
	
	
	// p_category 
	//변경할 아이콘 이미지 들고오기
	ImageIcon I_pc = new ImageIcon("./image/personal-computer.png");
	ImageIcon I_sing = new ImageIcon("./image/singing.png");
	ImageIcon I_study = new ImageIcon("./image/study.png");
	ImageIcon I_restaurant = new ImageIcon("./image/food-store.png");
	
	//ImageIcon으로 들고온 이미지 변환하기(변경할이미지)
	Image pre_pc = I_pc.getImage();
	Image pre_sing = I_sing.getImage();
	Image pre_study = I_study.getImage();
	Image pre_restaurant = I_restaurant.getImage();
	
	//이미지 사이즈 버튼에 맞춰서 변경하기(변경된이미지)
	Image pos_pc = pre_pc.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
	Image pos_sing = pre_sing.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
	Image pos_study = pre_study.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
	Image pos_restaurant = pre_restaurant.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
	
	//변경된이미지로 아이콘 변경하기(Image로 아이콘 생성)
	ImageIcon pc = new ImageIcon(pos_pc);
	ImageIcon sing = new ImageIcon(pos_sing);
	ImageIcon study = new ImageIcon(pos_study);
	ImageIcon restaurant = new ImageIcon(pos_restaurant);
	
	JButton b_pc = new JButton(pc);
	JButton b_sing = new JButton( sing);
	JButton b_study = new JButton(study);
	JButton b_restaurant = new JButton(restaurant);
	
	// p_search_login
	JTextField tf_search = new JTextField(40);
	//////////////////////// 여기에 넣으면 됩니당
	ImageIcon I_search = new ImageIcon("./image/search1.png");
	Image pre_search = I_search.getImage();  //ImageIcon을 Image로 변환.
	Image pos_search = pre_search.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon search = new ImageIcon(pos_search); //Image로 ImageIcon 생성
	JButton b_search = new JButton(search);
	
	// p_login
	JLabel L_id = new JLabel("ID");
	JLabel L_pw = new JLabel("PW");
	JLabel L_name = new JLabel("");
	
	JTextField tf_id = new JTextField(40);
	JTextField tf_pw = new JTextField(40);
	
	JButton b_sign = new JButton("회원가입");
	JButton b_login = new JButton("로그인");
	JButton b_logout = new JButton("로그아웃");
	
	// p_ad
//	ImageIcon I_ad = new ImageIcon("D:\\OneDrive\\Desktop\\동원참치.jpg");
//	JLabel L_ad = new JLabel(I_ad);
	
	public void setDisplay() {
		// panel 테두리 지정
		p_category.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		p_login.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		//p_ad.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));

		// panel 배치관리자
		// p_category.setLayout(new GridLayout(2,2,5,5));
		p_category.setLayout(null);
		p_search_login.setLayout(null);
		p_login.setLayout(null);
		baseLoginPanel.setLayout(new BorderLayout());
		loginedPanel.setLayout(new BorderLayout());
//		p_ad.setLayout(null);

		// panel 크기
		p_category.setPreferredSize(new Dimension(520, 400));
		p_search_login.setPreferredSize(new Dimension(480, 400));
//		p_ad.setPreferredSize(new Dimension(800, 400));

		// panel 배경색
		p_category.setBackground(new Color(126, 214, 223));
		p_search_login.setBackground(Color.WHITE);
		p_login.setBackground(new Color(129, 236, 236));
		loginedPanel.setBackground(new Color(129, 236, 236));
//		p_ad.setBackground(Color.WHITE);

		// category panel 위치, 추가
		
		b_pc.setBounds(14, 14, 240, 160);
		b_sing.setBounds(265, 14, 240, 160);
		b_study.setBounds(14, 184, 240, 160);
		b_restaurant.setBounds(265, 184, 240, 160);

		p_category.add(b_pc);
		p_category.add(b_sing);
		p_category.add(b_study);
		p_category.add(b_restaurant);
		
		//Button background 색깔
		b_pc.setBackground(Color.WHITE);
		b_sing.setBackground(Color.WHITE);
		b_study.setBackground(Color.WHITE);
		b_restaurant.setBackground(Color.WHITE);
		
		// search_login panel 위치, 추가
		tf_search.setBounds(15, 20, 395, 50);
		b_search.setBounds(410,20,50,50);
		b_search.setBackground(Color.WHITE);
		b_search.setBorder(null);

		p_search_login.add(tf_search);
		p_search_login.add(b_search);

		// login panel 위치 추가
		baseLoginPanel.setBounds(15, 90, 445, 270);
		//p_login.setBounds(15, 90, 445, 270);

		L_id.setBounds(35, 40, 50, 50);
		L_pw.setBounds(35, 115, 50, 50);

		L_id.setFont(new Font("SansSerif", Font.PLAIN, 26));
		L_pw.setFont(new Font("SansSerif", Font.PLAIN, 26));
		L_name.setFont(new Font("SansSerif", Font.BOLD, 35));
		L_name.setHorizontalAlignment(JLabel.CENTER);

		L_name.setForeground(Color.WHITE);
		
		tf_id.setBounds(105, 38, 310, 45);
		tf_pw.setBounds(105, 115, 310, 45);

		b_sign.setBounds(30, 200, 180, 50);
		b_login.setBounds(235, 200, 180, 50);

		b_sign.setBackground(new Color(34, 166, 179));
		b_login.setBackground(new Color(34, 166, 179));
		b_logout.setBackground(new Color(34, 166, 179));
		
		b_sign.setForeground(Color.WHITE);
		b_login.setForeground(Color.WHITE);
		b_logout.setForeground(Color.WHITE);
		
		b_sign.setFont(new Font("SansSerif", Font.BOLD, 26));
		b_login.setFont(new Font("SansSerif", Font.BOLD, 26));
		b_logout.setFont(new Font("SansSerif", Font.BOLD, 26));
		
		p_login.add(L_id);
		p_login.add(L_pw);
		p_login.add(tf_id);
		p_login.add(tf_pw);
		p_login.add(b_sign);
		p_login.add(b_login);
		
		loginedPanel.add(L_name, BorderLayout.CENTER);
		loginedPanel.add(b_logout, BorderLayout.SOUTH);
		
		baseLoginPanel.add(p_login, BorderLayout.CENTER);
		
		p_search_login.add(baseLoginPanel);
		
//		// ad panel 위치 추가
//		L_ad.setBounds(10, 10, 970, 380);

//		p_ad.add(L_ad);

		this.add(p_category, BorderLayout.WEST);
		this.add(p_search_login, BorderLayout.CENTER);
		this.add(p_ad, BorderLayout.SOUTH);
	}

	
	public void HomeButtonListener() {
		b_pc.addActionListener(new ActionListener() {

			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("pcButton");
			}
		});
		b_sing.addActionListener(new ActionListener() {

			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("singButton");
			}
		});
		b_study.addActionListener(new ActionListener() {

			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("studyButton");
			}
		});
		b_restaurant.addActionListener(new ActionListener() {

			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurantButton");
			}

		});
		b_sign.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.panelChange("Register");
			}
		});
		
		b_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tf_search.getText();
                // 클릭 시 같은 매장 이름 있을 시 그 페이지로 이동
				
				//<PC방>
				if(name.length() == 0)
                {
                	String messageOption = "검색어를 입력해주세요!";
					JOptionPane.showMessageDialog(null, messageOption);
                }
				else if (s.getService(name, 1).equals("1013"))
                    win.panelChange("pc1_Button");
                else if (s.getService(name, 1).equals("1014"))
                    win.panelChange("pc2_Button");
                else if (s.getService(name, 1).equals("1015"))
                    win.panelChange("pc3_Button");
                else if (s.getService(name, 1).equals("1016"))
                    win.panelChange("pc4_Button");
                
                //<노래방>
                else if (s.getService(name, 1).equals("1009"))
                    win.panelChange("sing1_Button");
                else if (s.getService(name, 1).equals("1011"))
                    win.panelChange("sing2_Button");
                else if (s.getService(name, 1).equals("1012"))
                    win.panelChange("sing3_Button");
                else if (s.getService(name, 1).equals("1010"))
                    win.panelChange("sing4_Button");
                
                //<음식점>
                else if (s.getService(name, 1).equals("1004"))
                    win.panelChange("restaurant1_Button");
                else if (s.getService(name, 1).equals("1002"))
                    win.panelChange("restaurant2_Button");
                else if (s.getService(name, 1).equals("1003"))
                    win.panelChange("restaurant3_Button");
                else if (s.getService(name, 1).equals("1001"))
                    win.panelChange("restaurant4_Button");
                
                //<독서실>
                else if (s.getService(name, 1).equals("1005"))
                    win.panelChange("study1_Button");
                else if (s.getService(name, 1).equals("1006"))
                    win.panelChange("study2_Button");
                else if (s.getService(name, 1).equals("1008"))
                    win.panelChange("study3_Button");
                else if (s.getService(name, 1).equals("1007"))
                    win.panelChange("study4_Button");
                
				else{
					try {
						String messageOption = "찾으시는 매장이 없습니다.";
						JOptionPane.showMessageDialog(null, messageOption);
						//win.panelChange("HomeButton");
						hm.setFocusable(true);
						hm.requestFocus();
					} catch(NullPointerException n) { }
				}
				tf_search.setText("");
				
			}
		});
		b_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLogined = DBlogin.abledAccount(tf_id.getText(), tf_pw.getText());
				if(isLogined) {
					userName = DBlogin.getUserName(tf_id.getText());
					win.setUserId(tf_id.getText());
					L_name.setText(userName + "님 환영합니다!");
					//Login_flag=1;
					baseLoginPanel.removeAll();
					baseLoginPanel.add(loginedPanel, BorderLayout.CENTER);
					revalidate();
					repaint();
					win.login_flag = isLogined;
				}
				else {
					String messageOption = "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.";
					JOptionPane.showMessageDialog(null, messageOption);
				}
			}
		});
		b_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLogined=false;
				win.login_flag=false;
				tf_id.setText("");
				tf_pw.setText("");
				baseLoginPanel.removeAll();
				baseLoginPanel.add(p_login, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
	}
	public boolean Login_flag() {
		return isLogined;
	}

	public void Logout() {
		isLogined=false;
		win.login_flag=false;
		tf_id.setText("");
		tf_pw.setText("");
		baseLoginPanel.removeAll();
		baseLoginPanel.add(p_login, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	  
	public HomeButton(MainPage win) {
		this.win = win;
		setLayout(new BorderLayout());
		setDisplay();
		//win.res_Panel = new restaurantButton(win);
		HomeButtonListener();
	}
}
