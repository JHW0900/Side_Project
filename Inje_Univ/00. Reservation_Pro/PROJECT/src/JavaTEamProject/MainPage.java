package JavaTEamProject;

import PCButton.*;
import SingButton.*;
import StudyButton.*;
import RestaurantButton.*;
import java.awt.Color;
import java.awt.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;


import javax.swing.*;

import JavaTEamProject.MainPage;
import JavaTEamProject.HomeButton;

import DataBase.*;

public class MainPage extends JFrame{
	
	public boolean login_flag;
	String userId;
	
	dbLogin DBl = new dbLogin();
	
	loadingPanel Loading_Panel = new loadingPanel();
	
	public HomeButton Home_Panel = null;
	public OrderListButton Order_Panel=null;
	public MyPageButton Mypage_Panel=null;
	public EventButton Event_Panel=null;
	public CustomerServiceButton Customer_Panel=null;
	public NoticeButton Notice_Panel=null;
	
	public pcButtonList pc_Panel=null;
	public singButtonList sing_Panel=null;
	public studyButtonList study_Panel=null;
	public restaurantButtonList res_Panel=null;
	
	public Register Register_Panel = null;
	
	public Notice1Button Notice1_Panel = null;
	public Notice2Button Notice2_Panel = null;
	public Notice3Button Notice3_Panel = null;
	public Notice4Button Notice4_Panel = null;
	public Notice5Button Notice5_Panel = null;
	public Notice6Button Notice6_Panel = null;
	
	public PCButton1 PC1_Panel = null;
	public PCButton1_Menu PC1Menu_Panel = null;
	public PCButton1_Information PC1Inf_Panel = null;
	public PCButton1_Picture PC1Pic_Panel = null;
	
	public PCButton2 PC2_Panel = null;
	public PCButton2_Menu PC2Menu_Panel = null;
	public PCButton2_Information PC2Inf_Panel = null;
	public PCButton2_Picture PC2Pic_Panel = null;
	
	public PCButton3 PC3_Panel = null;
	public PCButton3_Menu PC3Menu_Panel = null;
	public PCButton3_Information PC3Inf_Panel = null;
	public PCButton3_Picture PC3Pic_Panel = null;
	
	public PCButton4 PC4_Panel = null;
	public PCButton4_Menu PC4Menu_Panel = null;
	public PCButton4_Information PC4Inf_Panel = null;
	public PCButton4_Picture PC4Pic_Panel = null;
	
	public SingButton1 Sing1_Panel = null;
	public SingButton1_Menu Sing1Menu_Panel = null;
	public SingButton1_Information Sing1Inf_Panel = null;
	public SingButton1_Picture Sing1Pic_Panel = null;
	
	public SingButton2 Sing2_Panel = null;
	public SingButton2_Menu Sing2Menu_Panel = null;
	public SingButton2_Information Sing2Inf_Panel = null;
	public SingButton2_Picture Sing2Pic_Panel = null;
	
	public SingButton3 Sing3_Panel = null;
	public SingButton3_Menu Sing3Menu_Panel = null;
	public SingButton3_Information Sing3Inf_Panel = null;
	public SingButton3_Picture Sing3Pic_Panel = null;
	
	public SingButton4 Sing4_Panel = null;
	public SingButton4_Menu Sing4Menu_Panel = null;
	public SingButton4_Information Sing4Inf_Panel = null;
	public SingButton4_Picture Sing4Pic_Panel = null;
	
	public StudyButton1 Study1_Panel = null;
	public StudyButton1_Menu Study1Menu_Panel = null;
	public StudyButton1_Information Study1Inf_Panel = null;
	public StudyButton1_Picture Study1Pic_Panel = null;
	
	public StudyButton2 Study2_Panel = null;
	public StudyButton2_Menu Study2Menu_Panel = null;
	public StudyButton2_Information Study2Inf_Panel = null;
	public StudyButton2_Picture Study2Pic_Panel = null;
	
	public StudyButton3 Study3_Panel = null;
	public StudyButton3_Menu Study3Menu_Panel = null;
	public StudyButton3_Information Study3Inf_Panel = null;
	public StudyButton3_Picture Study3Pic_Panel = null;
	
	public StudyButton4 Study4_Panel = null;
	public StudyButton4_Menu Study4Menu_Panel = null;
	public StudyButton4_Information Study4Inf_Panel = null;
	public StudyButton4_Picture Study4Pic_Panel = null;
	
	public RestaurantButton1 Restaurant1_Panel = null;
	public RestaurantButton1_Menu Restaurant1Menu_Panel = null;
	public RestaurantButton1_Information Restaurant1Inf_Panel = null;
	public RestaurantButton1_Picture Restaurant1Pic_Panel = null;
	
	public RestaurantButton2 Restaurant2_Panel = null;
	public RestaurantButton2_Menu Restaurant2Menu_Panel = null;
	public RestaurantButton2_Information Restaurant2Inf_Panel = null;
	public RestaurantButton2_Picture Restaurant2Pic_Panel = null;
	
	public RestaurantButton3 Restaurant3_Panel = null;
	public RestaurantButton3_Menu Restaurant3Menu_Panel = null;
	public RestaurantButton3_Information Restaurant3Inf_Panel = null;
	public RestaurantButton3_Picture Restaurant3Pic_Panel = null;
	
	public RestaurantButton4 Restaurant4_Panel = null;
	public RestaurantButton4_Menu Restaurant4Menu_Panel = null;
	public RestaurantButton4_Information Restaurant4Inf_Panel = null;
	public RestaurantButton4_Picture Restaurant4Pic_Panel = null;
	
	public serviceReservation Reserv_Panel = null;		
	
	JButton category = new JButton("Menu Bar");
	JButton home = new JButton("홈");
	JButton mypage = new JButton("   MY PAGE   ");
	JButton orderdetails = new JButton("예약내역");
	JButton notice = new JButton("공지사항");
	JButton event = new JButton("이벤트");
	JButton customerservice = new JButton("고객센터");
	
	JPanel menu = new JPanel();
	JPanel screen01 = new JPanel();
	
	JLabel pic = new JLabel("");
	
	Container contents = getContentPane();
	
	public MainPage() {
		setFrame();
		setFont();
		setDisplay();
		setListener();
	}
	
	public void setService(int key, int seat) {
		Reserv_Panel.setService(key, seat);
		Reserv_Panel.setReservationPanel(key);
		panelChange("test");
		}
	
	
	public void setFont() {
		String FontStyle = "SansSerif";
		int FontSize = 25;
		
		int B_ColorR = 255;
		int B_ColorG = 255;
		int B_ColorB = 255;
		
		int F_ColorR = 34;
		int F_ColorG = 166;
		int F_ColorB = 179;
		
		int L_ColorR = 126;
		int L_ColorG = 214;
		int L_ColorB = 223;
		
		category.setFont(new Font(FontStyle, Font.BOLD, 20));		
		home.setFont(new Font(FontStyle, Font.BOLD, FontSize));	
		mypage.setFont(new Font(FontStyle, Font.BOLD, FontSize));			
		orderdetails.setFont(new Font(FontStyle, Font.BOLD, FontSize));			
		notice.setFont(new Font(FontStyle, Font.BOLD, FontSize));			
		event.setFont(new Font(FontStyle, Font.BOLD, FontSize));		
		customerservice.setFont(new Font(FontStyle, Font.BOLD, FontSize));	
		
		// menubar 버튼 배경색 흰색
		category.setBackground(new Color(34,166,179));	
		home.setBackground(new Color(B_ColorR,B_ColorG,B_ColorB));	
		mypage.setBackground(new Color(B_ColorR,B_ColorG,B_ColorB));	
		orderdetails.setBackground(new Color(B_ColorR,B_ColorG,B_ColorB));	
		notice.setBackground(new Color(B_ColorR,B_ColorG,B_ColorB));	
		event.setBackground(new Color(B_ColorR,B_ColorG,B_ColorB));	
		customerservice.setBackground(new Color(B_ColorR,B_ColorG,B_ColorB));	
		
		// menubar 버튼 전경색 녹색
		category.setForeground(new Color(0,0,0));
		home.setForeground(new Color(F_ColorR,F_ColorG,F_ColorB));
		mypage.setForeground(new Color(F_ColorR,F_ColorG,F_ColorB));
		orderdetails.setForeground(new Color(F_ColorR,F_ColorG,F_ColorB));
		notice.setForeground(new Color(F_ColorR,F_ColorG,F_ColorB));
		event.setForeground(new Color(F_ColorR,F_ColorG,F_ColorB));
		customerservice.setForeground(new Color(F_ColorR,F_ColorG,F_ColorB));
		
		// menubar 버튼 테두리 색 녹색, 테두리 굵기
		category.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB)));
		home.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB),3));
		mypage.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB),3));
		orderdetails.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB),3));
		notice.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB),3));
		event.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB),3));
		customerservice.setBorder(BorderFactory.createLineBorder(new Color(L_ColorR,L_ColorG,L_ColorB),3));
	}
	
	public void setFrame() {
		setTitle("선결제 예약 프로그램");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setVisible(true);
	}
	
	public void setDisplay() {
		contents.setLayout(new BorderLayout(25,0));
		contents.setBackground(Color.WHITE);
		screen01.setBackground(Color.WHITE);
		menu.setLayout(new GridLayout(7,1));
		
		contents.add(menu, "West");
		contents.add(screen01,"Center");
		
		contents.add(Loading_Panel);
		
		setFocusable(true);
		requestFocus();
		
		menu.add(category);
		menu.add(home);
		menu.add(mypage);
		menu.add(orderdetails);
		menu.add(notice);
		menu.add(event);
		menu.add(customerservice);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void setListener() {
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelChange("HomeButton");
			}
		});
		orderdetails.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 로그인해야 접속가능 C
				// 예약 안되면 못 들어가게 하기 F
				login_flag=Home_Panel.Login_flag();
				if(login_flag) {
					if(DBl.getIsreservation(getUserId()) == 1)
						panelChange("OrderListButton");
					else {
						String messageOption = " 예약내역이 없습니다.";
						JOptionPane.showMessageDialog(null, messageOption);
					}
				}
				else {
					String messageOption = "로그인후 예약내역을 보실 수 있습니다!";
					JOptionPane.showMessageDialog(null, messageOption);
					setFocusable(true);
					requestFocus();
				}
			}
		});
		notice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelChange("NoticeButton");
			}
		});
		mypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 로그인해야 접속가능
				login_flag=Home_Panel.Login_flag();
				if(login_flag) {
					panelChange("MyPageButton");
				}
				else {
					String messageOption = "로그인후 사용해 주십시오!";
					JOptionPane.showMessageDialog(null, messageOption);
					setFocusable(true);
					requestFocus();
				}
			}
		});
		
		event.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelChange("EventButton");
			}
		});
		customerservice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelChange("CustomerServiceButton");
			}
		});
			/*			Debuging 용도			*/
		category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setFocusable(true);
				requestFocus();
			}
		});
	}

	public void setWhite(){ contents.setBackground(Color.WHITE); }
	public void setMint(){ contents.setBackground(new Color(223, 249, 251)); }
	
	public void panelChange(String cgPnl) {
		contents.removeAll();
		contents.add(menu, "West");
		if(cgPnl.equals("HomeButton")) {
			setWhite();
			contents.add(Home_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("OrderListButton")) {
			setMint();
			Order_Panel.setLabel();
			contents.add(Order_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("NoticeButton")) {
			setMint();
			contents.add(Notice_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("MyPageButton")) {
			Mypage_Panel.readInfo();
			setMint();
			contents.add(Mypage_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("EventButton")) {
			setMint();
			contents.add(Event_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("CustomerServiceButton")) {
			setMint();
			contents.add(Customer_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pcButton")) {
			contents.add(pc_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("singButton")) {
			contents.add(sing_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("studyButton")) {
			contents.add(study_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("restaurantButton")) {
			contents.add(res_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("Register")) {
			setMint();
			contents.add(Register_Panel,"Center");
			revalidate();
			repaint();
		}
		/*			Debuging 용도				*/
		else if(cgPnl.equals("test")) {
			contents.add(Reserv_Panel,"Center");
			revalidate();
			repaint();
		}
		
		
		// 공지사항 내의 버튼 클릭 시 패널 전환
		else if (cgPnl.equals("notice1Button")) {
			setWhite();
			contents.add(Notice1_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("notice2Button")) {
			setWhite();
			contents.add(Notice2_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("notice3Button")) {
			setWhite();
			contents.add(Notice3_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("notice4Button")) {
			setWhite();
			contents.add(Notice4_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("notice5Button")) {
			setWhite();
			contents.add(Notice5_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("notice6Button")) {
			setWhite();
			contents.add(Notice6_Panel, "Center");
			revalidate();
			repaint();
		}

		// PC방 list 내의 버튼 클릭 시 패널 전환
		else if(cgPnl.equals("pc1_Button")) {
			contents.add(PC1_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc1_menu_Button")) {
			contents.add(PC1Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc1_information_Button")) {
			contents.add(PC1Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc1_picture_Button")) {
			contents.add(PC1Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		else if(cgPnl.equals("pc2_Button")) {
			contents.add(PC2_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc2_menu_Button")) {
			contents.add(PC2Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc2_information_Button")) {
			contents.add(PC2Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc2_picture_Button")) {
			contents.add(PC2Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		else if(cgPnl.equals("pc3_Button")) {
			contents.add(PC3_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc3_menu_Button")) {
			contents.add(PC3Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc3_information_Button")) {
			contents.add(PC3Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc3_picture_Button")) {
			contents.add(PC3Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		
		else if(cgPnl.equals("pc4_Button")) {
			contents.add(PC4_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc4_menu_Button")) {
			contents.add(PC4Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc4_information_Button")) {
			contents.add(PC4Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("pc4_picture_Button")) {
			contents.add(PC4Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		// 노래방 list 내의 버튼 클릭 시 패널 전환
		else if (cgPnl.equals("sing1_Button")) {
			contents.add(Sing1_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("sing1_menu_Button")) {
			contents.add(Sing1Menu_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("sing1_information_Button")) {
			contents.add(Sing1Inf_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("sing1_picture_Button")) {
			contents.add(Sing1Pic_Panel, "Center");
			revalidate();
			repaint();
		}
		
		else if(cgPnl.equals("sing2_Button")) {
			contents.add(Sing2_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing2_menu_Button")) {
			contents.add(Sing2Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing2_information_Button")) {
			contents.add(Sing2Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing2_picture_Button")) {
			contents.add(Sing2Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		
		else if(cgPnl.equals("sing3_Button")) {
			contents.add(Sing3_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing3_menu_Button")) {
			contents.add(Sing3Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing3_information_Button")) {
			contents.add(Sing3Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing3_picture_Button")) {
			contents.add(Sing3Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		
		else if(cgPnl.equals("sing4_Button")) {
			contents.add(Sing4_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing4_menu_Button")) {
			contents.add(Sing4Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing4_information_Button")) {
			contents.add(Sing4Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("sing4_picture_Button")) {
			contents.add(Sing4Pic_Panel,"Center");
			revalidate();
			repaint();
		}	
		
		// 독서실 list 내의 버튼 클릭 시 패널 전환
		else if (cgPnl.equals("study1_Button")) {
			contents.add(Study1_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("study1_menu_Button")) {
			contents.add(Study1Menu_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("study1_information_Button")) {
			contents.add(Study1Inf_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("study1_picture_Button")) {
			contents.add(Study1Pic_Panel, "Center");
			revalidate();
			repaint();
		}
		
		else if(cgPnl.equals("study2_Button")) {
			contents.add(Study2_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study2_menu_Button")) {
			contents.add(Study2Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study2_information_Button")) {
			contents.add(Study2Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study2_picture_Button")) {
			contents.add(Study2Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		else if(cgPnl.equals("study3_Button")) {
			contents.add(Study3_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study3_menu_Button")) {
			contents.add(Study3Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study3_information_Button")) {
			contents.add(Study3Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study3_picture_Button")) {
			contents.add(Study3Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		else if(cgPnl.equals("study4_Button")) {
			contents.add(Study4_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study4_menu_Button")) {
			contents.add(Study4Menu_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study4_information_Button")) {
			contents.add(Study4Inf_Panel,"Center");
			revalidate();
			repaint();
		}
		else if(cgPnl.equals("study4_picture_Button")) {
			contents.add(Study4Pic_Panel,"Center");
			revalidate();
			repaint();
		}
		
		// 음식점 list 내의 버튼 클릭 시 패널 전환
		else if (cgPnl.equals("restaurant1_Button")) {
			contents.add(Restaurant1_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant1_menu_Button")) {
			contents.add(Restaurant1Menu_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant1_information_Button")) {
			contents.add(Restaurant1Inf_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant1_picture_Button")) {
			contents.add(Restaurant1Pic_Panel, "Center");
			revalidate();
			repaint();
		}
		
		else if (cgPnl.equals("restaurant2_Button")) {
			contents.add(Restaurant2_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant2_menu_Button")) {
			contents.add(Restaurant2Menu_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant2_information_Button")) {
			contents.add(Restaurant2Inf_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant2_picture_Button")) {
			contents.add(Restaurant2Pic_Panel, "Center");
			revalidate();
			repaint();
		}
		
		else if (cgPnl.equals("restaurant3_Button")) {
			contents.add(Restaurant3_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant3_menu_Button")) {
			contents.add(Restaurant3Menu_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant3_information_Button")) {
			contents.add(Restaurant3Inf_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant3_picture_Button")) {
			contents.add(Restaurant3Pic_Panel, "Center");
			revalidate();
			repaint();
		}
		
		else if (cgPnl.equals("restaurant4_Button")) {
			contents.add(Restaurant4_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant4_menu_Button")) {
			contents.add(Restaurant4Menu_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant4_information_Button")) {
			contents.add(Restaurant4Inf_Panel, "Center");
			revalidate();
			repaint();
		} else if (cgPnl.equals("restaurant4_picture_Button")) {
			contents.add(Restaurant4Pic_Panel, "Center");
			revalidate();
			repaint();
		}
	}
	
	public String getUserId() { return userId; }
	
	public void setUserId(String id) { this.userId = id; }
	
	public void HB_Logout() { Home_Panel.Logout(); }
	
	public static void main(String[] args) {
		MainPage win = new MainPage();
		win.Home_Panel = new HomeButton(win);
		win.Order_Panel = new OrderListButton(win);
		win.Notice_Panel = new NoticeButton(win);
		win.Mypage_Panel = new MyPageButton(win);
		win.Event_Panel = new EventButton(win);
		win.Customer_Panel = new CustomerServiceButton(win);
		
		win.pc_Panel = new pcButtonList(win);
		win.sing_Panel = new singButtonList(win);
		win.study_Panel = new studyButtonList(win);
		win.res_Panel = new restaurantButtonList(win);
		
		win.Register_Panel = new Register(win);
		win.Reserv_Panel = new serviceReservation(win);		/*			Debuging 용도				*/
		
		win.Notice1_Panel = new Notice1Button(win);
		win.Notice2_Panel = new Notice2Button(win);
		win.Notice3_Panel = new Notice3Button(win);
		win.Notice4_Panel = new Notice4Button(win);
		win.Notice5_Panel = new Notice5Button(win);
		win.Notice6_Panel = new Notice6Button(win);
		
		win.PC1_Panel = new PCButton1(win);
		win.PC1Menu_Panel = new PCButton1_Menu(win);
		win.PC1Inf_Panel = new PCButton1_Information(win);
		win.PC1Pic_Panel = new PCButton1_Picture(win);
		
		win.PC2_Panel = new PCButton2(win);
		win.PC2Menu_Panel = new PCButton2_Menu(win);
		win.PC2Inf_Panel = new PCButton2_Information(win);
		win.PC2Pic_Panel = new PCButton2_Picture(win);
		
		win.PC3_Panel = new PCButton3(win);
		win.PC3Menu_Panel = new PCButton3_Menu(win);
		win.PC3Inf_Panel = new PCButton3_Information(win);
		win.PC3Pic_Panel = new PCButton3_Picture(win);
		
		win.PC4_Panel = new PCButton4(win);
		win.PC4Menu_Panel = new PCButton4_Menu(win);
		win.PC4Inf_Panel = new PCButton4_Information(win);
		win.PC4Pic_Panel = new PCButton4_Picture(win);
		
		
		win.Sing1_Panel = new SingButton1(win);
		win.Sing1Menu_Panel = new SingButton1_Menu(win);
		win.Sing1Inf_Panel = new SingButton1_Information(win);
		win.Sing1Pic_Panel = new SingButton1_Picture(win);
		
		win.Sing2_Panel = new SingButton2(win);
		win.Sing2Menu_Panel = new SingButton2_Menu(win);
		win.Sing2Inf_Panel = new SingButton2_Information(win);
		win.Sing2Pic_Panel = new SingButton2_Picture(win);
		
		win.Sing3_Panel = new SingButton3(win);
		win.Sing3Menu_Panel = new SingButton3_Menu(win);
		win.Sing3Inf_Panel = new SingButton3_Information(win);
		win.Sing3Pic_Panel = new SingButton3_Picture(win);
		
		win.Sing4_Panel = new SingButton4(win);
		win.Sing4Menu_Panel = new SingButton4_Menu(win);
		win.Sing4Inf_Panel = new SingButton4_Information(win);
		win.Sing4Pic_Panel = new SingButton4_Picture(win);
		
		win.Study1_Panel = new StudyButton1(win);
		win.Study1Menu_Panel = new StudyButton1_Menu(win);
		win.Study1Inf_Panel = new StudyButton1_Information(win);
		win.Study1Pic_Panel = new StudyButton1_Picture(win);
		
		win.Study2_Panel = new StudyButton2(win);
		win.Study2Menu_Panel = new StudyButton2_Menu(win);
		win.Study2Inf_Panel = new StudyButton2_Information(win);
		win.Study2Pic_Panel = new StudyButton2_Picture(win);
		
		win.Study3_Panel = new StudyButton3(win);
		win.Study3Menu_Panel = new StudyButton3_Menu(win);
		win.Study3Inf_Panel = new StudyButton3_Information(win);
		win.Study3Pic_Panel = new StudyButton3_Picture(win);
		
		win.Study4_Panel = new StudyButton4(win);
		win.Study4Menu_Panel = new StudyButton4_Menu(win);
		win.Study4Inf_Panel = new StudyButton4_Information(win);
		win.Study4Pic_Panel = new StudyButton4_Picture(win);
		
		win.Restaurant1_Panel = new RestaurantButton1(win);
		win.Restaurant1Menu_Panel = new RestaurantButton1_Menu(win);
		win.Restaurant1Inf_Panel = new RestaurantButton1_Information(win);
		win.Restaurant1Pic_Panel = new RestaurantButton1_Picture(win);
		
		win.Restaurant2_Panel = new RestaurantButton2(win);
		win.Restaurant2Menu_Panel = new RestaurantButton2_Menu(win);
		win.Restaurant2Inf_Panel = new RestaurantButton2_Information(win);
		win.Restaurant2Pic_Panel = new RestaurantButton2_Picture(win);
		
		win.Restaurant3_Panel = new RestaurantButton3(win);
		win.Restaurant3Menu_Panel = new RestaurantButton3_Menu(win);
		win.Restaurant3Inf_Panel = new RestaurantButton3_Information(win);
		win.Restaurant3Pic_Panel = new RestaurantButton3_Picture(win);
		
		win.Restaurant4_Panel = new RestaurantButton4(win);
		win.Restaurant4Menu_Panel = new RestaurantButton4_Menu(win);
		win.Restaurant4Inf_Panel = new RestaurantButton4_Information(win);
		win.Restaurant4Pic_Panel = new RestaurantButton4_Picture(win);
		
		win.panelChange("HomeButton");
	}
}
