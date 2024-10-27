import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class MyBookingRoomFrame extends JFrame implements ActionListener{
	//Room_ReservationFrame rrf = new Room_ReservationFrame();
	
	saveDTO svdto;
	
	MyBookingImpl MBI = new MyBookingImpl();
	
	Color blue = new Color(98, 99, 212);
	
	Container container = getContentPane();
	
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelR11 = new JPanel();
	JPanel panelR12 = new JPanel();
	JPanel panelR13 = new JPanel();
	JPanel panelR14 = new JPanel();
	JPanel panelR15 = new JPanel();
	JPanel panelR21 = new JPanel();
	JPanel panelR22 = new JPanel();
	JPanel panelR23 = new JPanel();
	JPanel panelR24 = new JPanel();
	JPanel panelR25 = new JPanel();
	JPanel panelR31 = new JPanel();
	JPanel panelR32 = new JPanel();
	JPanel panelR33 = new JPanel();
	JPanel panelR34 = new JPanel();
	JPanel panelR35 = new JPanel();
	JPanel panelAdd = new JPanel();
	JPanel panelName = new JPanel();

	JLabel labelHImg = new JLabel(new ImageIcon(MBI.placeImage()));
	JLabel labelR1Img = new JLabel(new ImageIcon(MBI.roomImage(0)));
	JLabel labelR2Img = new JLabel(new ImageIcon(MBI.roomImage(1)));
	JLabel labelR3Img = new JLabel(new ImageIcon(MBI.roomImage(2)));

	JLabel labelName = new JLabel(MBI.getPlaceName());
	JLabel labelAddress = new JLabel(MBI.getPlaceAdd());
	JLabel labelPrice1 = new JLabel(MBI.getRoomPrice(0));
	JLabel labelPrice2 = new JLabel(MBI.getRoomPrice(1));
	JLabel labelPrice3 = new JLabel(MBI.getRoomPrice(2));

	JButton buttonR1 = new JButton();
	JButton buttonR2 = new JButton();
	JButton buttonR3 = new JButton();

	JTextArea textR1 = new JTextArea();
	JTextArea textR2 = new JTextArea();
	JTextArea textR3 = new JTextArea();
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	

	public MyBookingRoomFrame() {
		setIconImage(imageIcon.getImage());
		setSize(400, 600);
		setLocation(900, 200);
		setTitle("My Booking");
		init();
		start();
		setVisible(true);
		setResizable(false);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.setBackground(blue);
		container.add("North", panelNorth);
		container.add("Center", panelCenter);

		panelNorth.setLayout(new BorderLayout());
		panelNorth.setBackground(null);
		panelNorth.add("North", panelName);
		panelNorth.add("Center", labelHImg);
		panelNorth.add("South", panelAdd);

		LineBorder lineBorder = new LineBorder(blue);
		EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
		panelNorth.setBorder(new CompoundBorder(lineBorder, emptyBorder));

		panelName.setLayout(new FlowLayout());
		panelName.setBackground(null);
		panelName.add(labelName);

		labelName.setForeground(Color.white);
		labelName.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 15));

		labelHImg.setPreferredSize(new Dimension(400, 130));

		panelAdd.setLayout(new FlowLayout());
		panelAdd.setBackground(Color.white);
		panelAdd.add(labelAddress);
		// labelAddress.setForeground(Color.white);
		labelAddress.setBorder(new EmptyBorder(0, 3, 0, 3));
		labelAddress.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));

		panelCenter.setLayout(new GridLayout(3, 1));
		panelCenter.setBackground(blue);
		panelCenter.setBorder(new EmptyBorder(0, 5, 5, 5));
		panelCenter.add(panelR11);
		panelCenter.add(panelR21);
		panelCenter.add(panelR31);

		// 방1
		panelR11.setBorder(new LineBorder(blue));
		panelR11.setBackground(Color.white);
		panelR11.setLayout(new BorderLayout());
		panelR11.add("Center", panelR12);
		panelR11.add("South", panelR13);	
		panelR12.setLayout(new BorderLayout());
		panelR12.add("West", labelR1Img);
		panelR12.add("Center", textR1);
		textR1.setText(MBI.getRoomInfor(0));
		textR1.setEditable(false);
		textR1.setFont(new Font("카페24 써라운드 에어 ", Font.PLAIN, 12));

		panelR13.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR13.setBackground(Color.white);
		panelR13.add(labelPrice1);
		panelR13.add(buttonR1);
		
		
		// 공실 체크 기능
		if (MBI.Chack(0) == 0) {
			buttonR1.setText("객실 예약");
		} else if (MBI.Chack(0) == 1 || MBI.Chack(0) == 2) {
			buttonR1.setText("예약 불가");
			buttonR1.setEnabled(false);
		}

		buttonR1.setBackground(blue);
		buttonR1.setForeground(Color.white);
		buttonR1.setFocusPainted(false);
		buttonR1.setFont(new Font("카페24 써라운드", Font.BOLD, 13));

		// 방2
		panelR21.setBorder(new LineBorder(blue));
		panelR21.setBackground(Color.white);
		panelR21.setLayout(new BorderLayout());
		panelR21.add("Center", panelR22);
		panelR21.add("South", panelR23);

		panelR22.setLayout(new BorderLayout());
		panelR22.add("West", labelR2Img);
		panelR22.add("Center", textR2);
		textR2.setText(MBI.getRoomInfor(1));
		textR2.setEditable(false);
		textR2.setFont(new Font("카페24 써라운드 에어 ", Font.PLAIN, 12));

		panelR23.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR23.setBackground(Color.white);
		panelR23.add(labelPrice2);
		panelR23.add(buttonR2);

		// 공실 체크 후 버튼 온오프
		if (MBI.Chack(1) == 0) {
			buttonR2.setText("객실 예약");
		} else if (MBI.Chack(1) == 1 || MBI.Chack(1) == 2) {
			buttonR2.setText("예약 불가");
			buttonR2.setEnabled(false);
		}

		buttonR2.setBackground(blue);
		buttonR2.setForeground(Color.WHITE);
		buttonR2.setFocusPainted(false);
		buttonR2.setFont(new Font("카페24 써라운드", Font.BOLD, 13));

		// 방3
		panelR31.setBorder(new LineBorder(blue));
		panelR31.setBackground(null);
		panelR31.setLayout(new BorderLayout());
		panelR31.add("Center", panelR32);
		panelR31.add("South", panelR33);

		panelR32.setLayout(new BorderLayout());
		panelR32.add("West", labelR3Img);
		panelR32.add("Center", textR3);
		textR3.setText(MBI.getRoomInfor(2));
		textR3.setEditable(false);
		textR3.setFont(new Font("카페24 써라운드 에어 ", Font.PLAIN, 12));

		panelR33.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR33.setBackground(Color.white);
		panelR33.add(labelPrice3);
		panelR33.add(buttonR3);

		// 공실 체크 후 버튼 온오프
		if (MBI.Chack(2) == 0) {
			buttonR3.setText("객실 예약");
		} else if (MBI.Chack(2) == 1 || MBI.Chack(2) == 2) {
			buttonR3.setText("예약 불가");
			buttonR3.setEnabled(false);
		}
		buttonR3.setBackground(blue);
		buttonR3.setForeground(Color.white);
		buttonR3.setFocusPainted(false);
		buttonR3.setFont(new Font("카페24 써라운드", Font.BOLD, 13));
		
		

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		buttonR1.addActionListener(this);
		buttonR2.addActionListener(this);
		buttonR3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//saveDTO svdto = new saveDTO();  
		//Room_ReservationFrame rrf = new Room_ReservationFrame();
		int num=0;
		// 방 고유 번호와 사용자 아이디가 넘어가야댐
		if (e.getSource() == buttonR1) {
			num = MBI.roomReservation_bt(0);
			svdto.setSaveRoomNum(num);
			
			// 선택한 방 번호와 사용자 아이디를 가지고 방 예약 화면으로 넘어가는 부분을 추가

		} else if (e.getSource() == buttonR2) {
			num = MBI.roomReservation_bt(1);
			svdto.setSaveRoomNum(num);

			// 선택한 방 번호와 사용자 아이디를 가지고 방 예약 화면으로 넘어가는 부분을 추가

		} else if (e.getSource() == buttonR3) {
			num = MBI.roomReservation_bt(2);
			svdto.setSaveRoomNum(num);

			// 선택한 방 번호와 사용자 아이디를 가지고 방 예약 화면으로 넘어가는 부분을 추가

		}
		
		
		dispose();
		new Room_ReservationFrame();
		//rrf.setVisible(true);
		

	}
}
