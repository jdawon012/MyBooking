import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class UserRoomListFrame extends JFrame implements ActionListener {
	MyBookingImpl urli = new MyBookingImpl();
	Color blue = new Color(98, 99, 212);

	Container container = getContentPane();

	JPanel pl_top = new JPanel();
	JPanel pl_center = new JPanel();
	JPanel pl_down = new JPanel();

	JPanel pl_top_top = new JPanel();
	JPanel pl_top_top_logo = new JPanel();
	JPanel pl_top_top_icon = new JPanel();
	JPanel pl_top_username = new JPanel();

	JPanel pl_center_list1 = new JPanel();
	JPanel pl_center_list2 = new JPanel();
	JPanel pl_center_list3 = new JPanel();
	JPanel pl_center_list4 = new JPanel();

	JPanel pl_list1_img = new JPanel();
	JPanel pl_list2_img = new JPanel();
	JPanel pl_list3_img = new JPanel();
	JPanel pl_list4_img = new JPanel();

	JPanel pl_list1_txt = new JPanel();
	JPanel pl_list2_txt = new JPanel();
	JPanel pl_list3_txt = new JPanel();
	JPanel pl_list4_txt = new JPanel();

	JPanel pl_list1_bt = new JPanel();
	JPanel pl_list2_bt = new JPanel();
	JPanel pl_list3_bt = new JPanel();
	JPanel pl_list4_bt = new JPanel();

	JTextArea ta_list1 = new JTextArea();
	JTextArea ta_list2 = new JTextArea();
	JTextArea ta_list3 = new JTextArea();
	JTextArea ta_list4 = new JTextArea();

	JButton bt_home = new JButton("홈으로");
	JButton bt_back = new JButton("뒤로가기");
	JButton bt_cencel = new JButton("예약취소");

	JButton bt_list1 = new JButton("취소하기");
	JButton bt_list2 = new JButton("취소하기");
	JButton bt_list3 = new JButton("취소하기");
	JButton bt_list4 = new JButton("취소하기");

	JLabel lb_icon_logo = new JLabel();
	JLabel lb_icon_hotel = new JLabel();
	JLabel lb_icon_room1 = new JLabel();
	JLabel lb_icon_room2 = new JLabel();
	JLabel lb_icon_room3 = new JLabel();
	JLabel lb_icon_room4 = new JLabel();

	JLabel lb_top = new JLabel("예약 현황");
	JLabel lb_username = new JLabel("");
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	

	public UserRoomListFrame() {
		setIconImage(imageIcon.getImage());
		setSize(430, 600);
		setTitle("My Booking");
		setLocation(750, 150);
		init();
		start();
		setVisible(true);
		setResizable(false);

	}

	/** 이미지 크기 조절해보기 **/
	private void image() {

		ImageIcon icon_hotel = new ImageIcon("img/hotel.png");
		ImageIcon icon_room1 = new ImageIcon(urli.getImage(0));
		ImageIcon icon_room2 = new ImageIcon(urli.getImage(1));
		ImageIcon icon_room3 = new ImageIcon(urli.getImage(2));
		ImageIcon icon_room4 = new ImageIcon(urli.getImage(3));

		Image img_hotel = icon_hotel.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Image img_room1 = icon_room1.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
		Image img_room2 = icon_room2.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
		Image img_room3 = icon_room3.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
		Image img_room4 = icon_room4.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);

		ImageIcon resized_hotel = new ImageIcon(img_hotel);
		ImageIcon resized_room1 = new ImageIcon(img_room1);
		ImageIcon resized_room2 = new ImageIcon(img_room2);
		ImageIcon resized_room3 = new ImageIcon(img_room3);
		ImageIcon resized_room4 = new ImageIcon(img_room4);

		lb_icon_hotel.setIcon(resized_hotel);
		lb_icon_room1.setIcon(resized_room1);
		lb_icon_room2.setIcon(resized_room2);
		lb_icon_room3.setIcon(resized_room3);
		lb_icon_room4.setIcon(resized_room4);

	}
	/** 이미지 크기 조절 끝  **/
	
	
	
	
	private void init() {

		image();
		
		
		container.setLayout(new BorderLayout());
		container.setBackground(Color.white);
		container.add("North", pl_top);
		container.add("Center", pl_center);
		container.add("South", pl_down);

		// 상단부
		pl_top.setLayout(new BorderLayout());
		pl_top.add("North", pl_top_top);
		pl_top.add("Center", pl_top_username);

		pl_top_username.setBackground(Color.white);
		pl_top_username.setLayout(new FlowLayout());
		pl_top_username.add(lb_username);

		pl_top_top.setLayout(new FlowLayout());
		pl_top_top.setBackground(Color.white);
		pl_top_top.add("Center", lb_top);
		pl_top_top.add("East", lb_icon_hotel);

		lb_top.setBorder(new EmptyBorder(10, 20, 0, 10));

		// lb_icon_hotel.setBorder(new EmptyBorder(10,0,5,60));

		lb_top.setFont(new Font("카페24 써라운드", Font.BOLD, 30)); // Arial 폰트, 볼드체, 크기 20으로 설정
		lb_top.setForeground(blue);
		// 중단부

		pl_center.setLayout(new GridLayout(4, 1));
		pl_center.setBackground(Color.white);
		pl_center.add(pl_center_list1);
		pl_center.add(pl_center_list2);
		pl_center.add(pl_center_list3);
		pl_center.add(pl_center_list4);

		// 외곽선
		pl_center_list1.setBorder(new LineBorder(blue, 1));
		pl_center_list2.setBorder(new LineBorder(blue, 1));
		pl_center_list3.setBorder(new LineBorder(blue, 1));
		pl_center_list4.setBorder(new LineBorder(blue, 1));

		// 리스트1
		pl_center_list1.setLayout(new BorderLayout());
		pl_center_list1.add("West", pl_list1_img);
		pl_center_list1.add("Center", pl_list1_txt);
		pl_center_list1.add("East", pl_list1_bt);

		pl_list1_img.setLayout(new GridLayout());
		pl_list1_img.setBackground(Color.white);
		pl_list1_img.add(lb_icon_room1);

		pl_list1_txt.setLayout(new GridLayout());
		pl_list1_txt.add(ta_list1);
		
		
		//예약내용 나오기 1번
		ta_list1.setText(urli.getInfor(0));
		ta_list1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));

		ta_list1.setEditable(false);

		pl_list1_bt.setLayout(new GridLayout());
		pl_list1_bt.add(bt_list1);

		bt_list1.setBackground(blue);
		bt_list1.setForeground(Color.white);
		bt_list1.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		bt_list1.setPreferredSize(new Dimension(75, 0));
		bt_list1.setBorder(new LineBorder(Color.white, 2));
		bt_list1.setFocusPainted(false);
		
		if(urli.bt_onoff(0)==0) {
		bt_list1.setVisible(false);
		pl_list1_bt.setBackground(Color.white);
		}

		// 리스트2
		pl_center_list2.setLayout(new BorderLayout());
		pl_center_list2.add("West", pl_list2_img);
		pl_center_list2.add("Center", pl_list2_txt);
		pl_center_list2.add("East", pl_list2_bt);

		pl_list2_img.setLayout(new GridLayout());
		pl_list2_img.setBackground(Color.white);
		pl_list2_img.add(lb_icon_room2);

		pl_list2_txt.setLayout(new GridLayout());
		pl_list2_txt.add(ta_list2);
		
		//예약내용 나오기 2번
		ta_list2.setText(urli.getInfor(1));
		ta_list2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));

		ta_list2.setEditable(false);

		pl_list2_bt.setLayout(new GridLayout());
		pl_list2_bt.add(bt_list2);

		bt_list2.setBackground(blue);
		bt_list2.setForeground(Color.white);
		bt_list2.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		bt_list2.setPreferredSize(new Dimension(75, 0));
		bt_list2.setBorder(new LineBorder(Color.white, 2));
		bt_list2.setFocusPainted(false);
		if(urli.bt_onoff(1)==0) {
			bt_list2.setVisible(false);
			pl_list2_bt.setBackground(Color.white);
		}

		// 리스트3
		pl_center_list3.setLayout(new BorderLayout());
		pl_center_list3.add("West", pl_list3_img);
		pl_center_list3.add("Center", pl_list3_txt);
		pl_center_list3.add("East", pl_list3_bt);

		pl_list3_img.setLayout(new GridLayout());
		pl_list3_img.setBackground(Color.white);
		pl_list3_img.add(lb_icon_room3);

		pl_list3_txt.setLayout(new GridLayout());
		pl_list3_txt.add(ta_list3);
		
		//예약내용 나오기 3번
		ta_list3.setText(urli.getInfor(2));
		ta_list3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		

		ta_list3.setEditable(false);

		pl_list3_bt.setLayout(new GridLayout());
		pl_list3_bt.add(bt_list3);
		bt_list3.setBackground(blue);
		bt_list3.setForeground(Color.white);
		bt_list3.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		bt_list3.setPreferredSize(new Dimension(75, 0));
		bt_list3.setBorder(new LineBorder(Color.white, 2));
		bt_list3.setFocusPainted(false);
		if(urli.bt_onoff(2)==0) {
			bt_list3.setVisible(false);
			pl_list3_bt.setBackground(Color.white);
			}
		

		// 리스트4
		pl_center_list4.setLayout(new BorderLayout());
		pl_center_list4.add("West", pl_list4_img);
		pl_center_list4.add("Center", pl_list4_txt);
		pl_center_list4.add("East", pl_list4_bt);

		pl_list4_img.setLayout(new GridLayout());
		pl_list4_img.setBackground(Color.white);
		pl_list4_img.add(lb_icon_room4);

		pl_list4_txt.setLayout(new GridLayout());
		pl_list4_txt.add(ta_list4);
		
		//예약내용 나오기 4번
		ta_list4.setText(urli.getInfor(3));
		ta_list4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		ta_list4.setEditable(false);

		pl_list4_bt.setLayout(new GridLayout());
		pl_list4_bt.add(bt_list4);
		bt_list4.setBackground(blue);
		bt_list4.setForeground(Color.white);
		bt_list4.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		bt_list4.setPreferredSize(new Dimension(75, 0));
		bt_list4.setBorder(new LineBorder(Color.white, 2));
		bt_list4.setFocusPainted(false);
		
		if(urli.bt_onoff(3)==0) {
			bt_list4.setVisible(false);
			pl_list4_bt.setBackground(Color.white);
		}

		// 하단부
		pl_down.setLayout(new FlowLayout());
		pl_down.setBackground(Color.white);
		pl_down.add(bt_home);
		bt_home.setBackground(blue);
		bt_home.setForeground(Color.white);
		bt_home.setFont(new Font("카페24 써라운드", Font.BOLD, 13));
	}

	private void start() {

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		bt_list1.addActionListener(this);
		bt_list2.addActionListener(this);
		bt_list3.addActionListener(this);
		bt_list4.addActionListener(this);
		bt_home.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_home) {
			dispose();
			MainFrame mainF = new MainFrame();
			mainF.setVisible(true);
		}else if(e.getSource() == bt_list1){		//리스트 1번 취소
			
			if(urli.roomCencle(0)== 1) {
				JOptionPane.showMessageDialog(this, "취소 성공입니다 야호", "추카", JOptionPane.WARNING_MESSAGE);
			}else if(urli.roomCencle(0)==0) {
				JOptionPane.showMessageDialog(this, "db에 취소할 리스트가 없는데 어캄", "실패", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "비상 망했다", "머임", JOptionPane.WARNING_MESSAGE);
			}
			refresh();
		}else if(e.getSource() == bt_list2) {		//리스트 2번 취소
			
			if(urli.roomCencle(1)== 1) {
				JOptionPane.showMessageDialog(this, "취소 성공입니다 야호", "추카", JOptionPane.WARNING_MESSAGE);
			}else if(urli.roomCencle(1)==0) {
				JOptionPane.showMessageDialog(this, "db에 취소할 리스트가 없는데 어캄", "실패", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "비상 망했다", "머임", JOptionPane.WARNING_MESSAGE);
			}
			refresh();
		}else if(e.getSource() == bt_list3) {		//리스트 3번 취소
			
			if(urli.roomCencle(2)== 1) {
				JOptionPane.showMessageDialog(this, "취소 성공입니다 야호", "추카", JOptionPane.WARNING_MESSAGE);
			}else if(urli.roomCencle(2)==0) {
				JOptionPane.showMessageDialog(this, "db에 취소할 리스트가 없는데 어캄", "실패", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "비상 망했다", "머임", JOptionPane.WARNING_MESSAGE);
			}
			refresh();
		}else if(e.getSource() == bt_list4) {		//리스트 4번 취소
			
			if(urli.roomCencle(3)== 1) {
				JOptionPane.showMessageDialog(this, "취소 성공입니다 야호", "추카", JOptionPane.WARNING_MESSAGE);
			}else if(urli.roomCencle(3)==0) {
				JOptionPane.showMessageDialog(this, "db에 취소할 리스트가 없는데 어캄", "실패", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "비상 망했다", "머임", JOptionPane.WARNING_MESSAGE);
			}
			refresh();
		}

	}
	
	
	
	public void refresh() {
	    // 화면을 새로고침하는 코드 작성
	    setVisible(false); // 현재 화면을 숨기고
	    new UserRoomListFrame(); // 새로운 예약 목록 화면 생성
	}
}