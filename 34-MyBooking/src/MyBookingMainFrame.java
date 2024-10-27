import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


class MainFrame extends JFrame implements ActionListener, MouseListener {
	MyBookingImpl mbi = new MyBookingImpl();
	
	Color blue = new Color(98, 99, 212);
	Container container = getContentPane();

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	ImageIcon imgClock = new ImageIcon("img/clock.png");

	JButton buttonR = new JButton("", imgClock);
	JButton buttonCal = new JButton("조회");

	JLabel labelImg = new JLabel();
	JLabel labelH11 = new JLabel();
	JLabel labelH12 = new JLabel();
	JLabel labelH13 = new JLabel();
	JLabel labelH14 = new JLabel();
	JLabel labelM11 = new JLabel();
	JLabel labelM12 = new JLabel();
	JLabel labelM13 = new JLabel();
	JLabel labelM14 = new JLabel();
	JLabel labelP11 = new JLabel();
	JLabel labelP12 = new JLabel();
	JLabel labelP13 = new JLabel();
	JLabel labelP14 = new JLabel();
	JLabel labelClock = new JLabel();
	JLabel labelCal = new JLabel("날짜 선택 : ");

	JPanel panelNorth = new JPanel();
	JPanel panelImg = new JPanel();
	JPanel panelCal = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelHotel = new JPanel();
	JPanel panelHotel1 = new JPanel();
	JPanel panelList11 = new JPanel();
	JPanel panelList12 = new JPanel();
	JPanel panelList13 = new JPanel();
	JPanel panelList14 = new JPanel();
	JPanel panelMotel = new JPanel();
	JPanel panelMotel1 = new JPanel();
	JPanel panelList21 = new JPanel();
	JPanel panelList22 = new JPanel();
	JPanel panelList23 = new JPanel();
	JPanel panelList24 = new JPanel();
	JPanel panelPension = new JPanel();
	JPanel panelPension1 = new JPanel();
	JPanel panelList31 = new JPanel();
	JPanel panelList32 = new JPanel();
	JPanel panelList33 = new JPanel();
	JPanel panelList34 = new JPanel();
	JPanel panelClock = new JPanel();
	
	JTextArea textH1 = new JTextArea();
	JTextArea textH2 = new JTextArea();
	JTextArea textH3 = new JTextArea();
	JTextArea textH4 = new JTextArea();
	JTextArea textM1 = new JTextArea();
	JTextArea textM2 = new JTextArea();
	JTextArea textM3 = new JTextArea();
	JTextArea textM4 = new JTextArea();
	JTextArea textP1 = new JTextArea();
	JTextArea textP2 = new JTextArea();
	JTextArea textP3 = new JTextArea();
	JTextArea textP4 = new JTextArea();
	

	UtilDateModel dateModel = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(dateModel);
	JDatePickerImpl calender = new JDatePickerImpl(datePanel);
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	

	public MainFrame() {
		setIconImage(imageIcon.getImage());
		setSize(400, 600);
		setLocation(750, 150);
		setTitle("My Booking");
		init();
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		container.setLayout(new BorderLayout());

		container.add("North", panelNorth);
		container.add("Center", panelCenter);

		// 상단 메인 이미지+예약 현황 버튼
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add("Center",panelImg);
		panelNorth.add("South",panelCal);
		
		panelImg.setLayout(new FlowLayout());
		panelImg.setBackground(Color.white);
		panelImg.add(labelImg);
		panelImg.add(buttonR);

		labelImg.setIcon(new ImageIcon("img/Plabel.jpg"));
		labelImg.setPreferredSize(new Dimension(270, 100));

//		panelClock.setLayout(new GridLayout(3, 1));
//		panelClock.setBackground(Color.white);
//		panelClock.setPreferredSize(new Dimension(100, 50));
//
//		panelClock.add(buttonR);
		buttonR.setFocusPainted(false);
		buttonR.setBackground(null);
		buttonR.setBorderPainted(false);
		buttonR.setPreferredSize(new Dimension(50, 50));
		
		//달력
		panelCal.setLayout(new BorderLayout());
		panelCal.setBorder(new EmptyBorder(0,5,5,10));
		panelCal.setBackground(Color.white);
		panelCal.add("West", labelCal);
		panelCal.add("Center", calender);
		panelCal.add("East", buttonCal);

		labelCal.setBackground(null);
		labelCal.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		
		calender.setBackground(Color.white);
		
		buttonCal.setBackground(blue);
		buttonCal.setForeground(Color.white);
		buttonCal.setFocusPainted(false);
		buttonCal.setFont(new Font("카페24 써라운드", Font.BOLD, 13));

		// 탭부분
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(tabbedPane);
		panelCenter.setBackground(Color.white);

		tabbedPane.setBackground(Color.white);
		tabbedPane.setBorder(new EmptyBorder(0,5,0,5));
		tabbedPane.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 13));
		tabbedPane.add(panelHotel,0);
		tabbedPane.setTitleAt(0, "호텔");
		tabbedPane.add(panelMotel,1);
		tabbedPane.setTitleAt(1, "모텔");
		tabbedPane.add(panelPension,2);
		tabbedPane.setTitleAt(2, "펜션");
		

		// 호텔 탭
		panelHotel.setLayout(new BorderLayout());
		panelHotel.add("Center", panelHotel1);

		
		panelHotel1.setLayout(new GridLayout(4, 1));
		panelHotel1.add(panelList11);
		panelHotel1.add(panelList12);
		panelHotel1.add(panelList13);
		panelHotel1.add(panelList14);

		panelList11.setLayout(new BorderLayout());
		panelList11.setBorder(new LineBorder(blue));
		panelList11.add("West", labelH11);
		panelList11.add("Center", textH1);
		labelH11.setIcon(new ImageIcon(mbi.getHotelImage(0)));
		
		textH1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textH1.setText(mbi.getHotelList(0));
		textH1.setEditable(false);
		textH1.setBackground(Color.white);

		panelList12.setLayout(new BorderLayout());
		panelList12.setBorder(new LineBorder(blue));
		panelList12.add("West", labelH12);
		panelList12.add("Center", textH2);
		labelH12.setIcon(new ImageIcon(mbi.getHotelImage(1)));
		textH2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textH2.setText(mbi.getHotelList(1));
		textH2.setEditable(false);
		textH2.setBackground(Color.white);

		panelList13.setLayout(new BorderLayout());
		panelList13.setBorder(new LineBorder(blue));
		panelList13.add("West", labelH13);
		panelList13.add("Center", textH3);
		labelH13.setIcon(new ImageIcon(mbi.getHotelImage(2)));
		
		textH3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textH3.setText(mbi.getHotelList(2));
		textH3.setEditable(false);
		textH3.setBackground(Color.white);

		panelList14.setLayout(new BorderLayout());
		panelList14.setBorder(new LineBorder(blue));
		panelList14.add("West", labelH14);
		panelList14.add("Center", textH4);
		labelH14.setIcon(new ImageIcon(mbi.getHotelImage(3)));
		textH4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textH4.setText(mbi.getHotelList(3));
		textH4.setEditable(false);
		textH4.setBackground(Color.white);

		// 모텔
		panelMotel.setLayout(new BorderLayout());
		panelMotel.add("Center", panelMotel1);
		
		panelMotel1.setLayout(new GridLayout(4, 1));
		panelMotel1.add(panelList21);
		panelMotel1.add(panelList22);
		panelMotel1.add(panelList23);
		panelMotel1.add(panelList24);

		panelList21.setLayout(new BorderLayout());
		panelList21.setBorder(new LineBorder(blue));
		panelList21.add("West", labelM11);
		panelList21.add("Center", textM1);
		labelM11.setIcon(new ImageIcon(mbi.getMotelImage(0)));
		textM1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textM1.setText(mbi.getMotelList(0));
		textM1.setEditable(false);
		textM1.setBackground(Color.white);

		panelList22.setLayout(new BorderLayout());
		panelList22.setBorder(new LineBorder(blue));
		panelList22.add("West", labelM12);
		panelList22.add("Center", textM2);
		labelM12.setIcon(new ImageIcon(mbi.getMotelImage(1)));
		textM2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textM2.setText(mbi.getMotelList(1));
		textM2.setEditable(false);
		textM2.setBackground(Color.white);

		panelList23.setLayout(new BorderLayout());
		panelList23.setBorder(new LineBorder(blue));
		panelList23.add("West", labelM13);
		panelList23.add("Center", textM3);
		labelM13.setIcon(new ImageIcon(mbi.getMotelImage(2)));
		textM3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textM3.setText(mbi.getMotelList(2));
		textM3.setEditable(false);
		textM3.setBackground(Color.white);

		panelList24.setLayout(new BorderLayout());
		panelList24.setBorder(new LineBorder(blue));
		panelList24.add("West", labelM14);
		panelList24.add("Center", textM4);
		labelM14.setIcon(new ImageIcon(mbi.getMotelImage(3)));
		textM4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textM4.setText(mbi.getMotelList(3));
		textM4.setEditable(false);
		textM4.setBackground(Color.white);

		// 펜션 탭
		panelPension.setLayout(new BorderLayout());
		panelPension.add("Center", panelPension1);
		
		panelPension1.setLayout(new GridLayout(4, 1));
		panelPension1.add(panelList31);
		panelPension1.add(panelList32);
		panelPension1.add(panelList33);
		panelPension1.add(panelList34);

		panelList31.setLayout(new BorderLayout());
		panelList31.setBorder(new LineBorder(blue));
		panelList31.add("West", labelP11);
		panelList31.add("Center", textP1);
		labelP11.setIcon(new ImageIcon(mbi.getPensenImage(0)));
		textP1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textP1.setText(mbi.getPensenList(0));
		textP1.setEditable(false);
		textP1.setBackground(Color.white);

		panelList32.setLayout(new BorderLayout());
		panelList32.setBorder(new LineBorder(blue));
		panelList32.add("West", labelP12);
		panelList32.add("Center", textP2);
		labelP12.setIcon(new ImageIcon(mbi.getPensenImage(1)));
		textP2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textP2.setText(mbi.getPensenList(1));
		textP2.setEditable(false);
		textP2.setBackground(Color.white);

		panelList33.setLayout(new BorderLayout());
		panelList33.setBorder(new LineBorder(blue));
		panelList33.add("West", labelP13);
		panelList33.add("Center", textP3);
		labelP13.setIcon(new ImageIcon(mbi.getPensenImage(2)));
		textP3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textP3.setText(mbi.getPensenList(2));
		textP3.setEditable(false);
		textP3.setBackground(Color.white);

		panelList34.setLayout(new BorderLayout());
		panelList34.setBorder(new LineBorder(blue));
		panelList34.add("West", labelP14);
		panelList34.add("Center", textP4);
		labelP14.setIcon(new ImageIcon(mbi.getPensenImage(3)));
		textP4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
		textP4.setText(mbi.getPensenList(3));
		textP4.setEditable(false);
		textP4.setBackground(Color.white);
		
//		container.setLayout(new BorderLayout());
//
//		container.add("North", panelNorth);
//		container.add("Center", panelCenter);
//
//		// 상단 메인 이미지+예약 현황 버튼
//		panelNorth.setLayout(new BorderLayout());
//		panelNorth.add("Center",panelImg);
//		panelNorth.add("South",panelCal);
//		
//		panelImg.setLayout(new FlowLayout());
//		panelImg.setBackground(Color.white);
//		panelImg.add(labelImg);
//		panelImg.add(buttonR);
//
//		labelImg.setIcon(new ImageIcon("img/Plabel.jpg"));
//		labelImg.setPreferredSize(new Dimension(270, 100));
//
//		//panelClock.setLayout(new GridLayout(3, 1));
//		//panelClock.setBackground(Color.white);
//		//panelClock.setPreferredSize(new Dimension(100, 50));
//
//		//panelClock.add(buttonR);
//		buttonR.setFocusPainted(false);
//		buttonR.setBackground(null);
//		buttonR.setBorderPainted(false);
//		buttonR.setPreferredSize(new Dimension(50, 50));
//		
//		//달력
//		panelCal.setLayout(new BorderLayout());
//		panelCal.setBorder(new EmptyBorder(0,5,5,10));
//		panelCal.setBackground(Color.white);
//		panelCal.add("West", labelCal);
//		panelCal.add("Center", calender);
//		panelCal.add("East", buttonCal);
//
//		labelCal.setBackground(null);
//		labelCal.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
//		
//		calender.setBackground(Color.white);
//		
//		buttonCal.setBackground(blue);
//		buttonCal.setForeground(Color.white);
//		buttonCal.setFocusPainted(false);
//		buttonCal.setFont(new Font("카페24 써라운드", Font.BOLD, 13));
//
//		// 탭부분
//		panelCenter.setLayout(new BorderLayout());
//		panelCenter.add(tabbedPane);
//		panelCenter.setBackground(Color.white);
//
//		tabbedPane.setBackground(Color.white);
//		tabbedPane.setBorder(new EmptyBorder(0,5,0,5));
//		tabbedPane.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 13));
//		tabbedPane.add(panelHotel,0);
//		tabbedPane.setTitleAt(0, "호텔");
//		tabbedPane.add(panelMotel,1);
//		tabbedPane.setTitleAt(1, "모텔");
//		tabbedPane.add(panelPension,2);
//		tabbedPane.setTitleAt(2, "펜션");
//		
//
//		// 호텔 탭
//		panelHotel.setLayout(new BorderLayout());
//		panelHotel.add("Center", panelHotel1);
//
//		
//		panelHotel1.setLayout(new GridLayout(4, 1));
//		panelHotel1.add(panelList11);
//		panelHotel1.add(panelList12);
//		panelHotel1.add(panelList13);
//		panelHotel1.add(panelList14);
//
//		panelList11.setLayout(new BorderLayout());
//		panelList11.setBorder(new LineBorder(blue));
//		panelList11.add("West", labelH11);
//		panelList11.add("Center", textH1);
//		labelH11.setIcon(new ImageIcon(mpi.getHotelImage(0)));
//		textH1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textH1.setText("\n  여수 라마다 프라자 호텔\n\n"+"  여수시) 여수EXPO역 차량 7분");
//		textH1.setEditable(false);
//		textH1.setBackground(Color.white);
//
//		panelList12.setLayout(new BorderLayout());
//		panelList12.setBorder(new LineBorder(blue));
//		panelList12.add("West", labelH12);
//		panelList12.add("Center", textH2);
//		labelH12.setIcon(new ImageIcon("img/hotelSky.jpg"));
//		textH2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textH2.setText("\n  스카이베이호텔 경포\n\n"+"  강릉시) 강문해변 차량 2분");
//		textH2.setEditable(false);
//		textH2.setBackground(Color.white);
//
//		panelList13.setLayout(new BorderLayout());
//		panelList13.setBorder(new LineBorder(blue));
//		panelList13.add("West", labelH13);
//		panelList13.add("Center", textH3);
//		labelH13.setIcon(new ImageIcon("img/hotelSea.jpg"));
//		textH3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textH3.setText("\n  씨크루즈호텔 속초\n\n"+"  속초시) 속초항 차량 4분");
//		textH3.setEditable(false);
//		textH3.setBackground(Color.white);
//
//		panelList14.setLayout(new BorderLayout());
//		panelList14.setBorder(new LineBorder(blue));
//		panelList14.add("West", labelH14);
//		panelList14.add("Center", textH4);
//		labelH14.setIcon(new ImageIcon("img/hotelEl.jpg"));
//		textH4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textH4.setText("\n  엘모멘토 광안\n\n"+"  수영구) 광안리해수욕장 도보 1분");
//		textH4.setEditable(false);
//		textH4.setBackground(Color.white);
//
//		// 모텔
//		panelMotel.setLayout(new BorderLayout());
//		panelMotel.add("Center", panelMotel1);
//		
//		panelMotel1.setLayout(new GridLayout(4, 1));
//		panelMotel1.add(panelList21);
//		panelMotel1.add(panelList22);
//		panelMotel1.add(panelList23);
//		panelMotel1.add(panelList24);
//
//		panelList21.setLayout(new BorderLayout());
//		panelList21.setBorder(new LineBorder(blue));
//		panelList21.add("West", labelM11);
//		panelList21.add("Center", textM1);
//		labelM11.setIcon(new ImageIcon("img/MotelSo.jpg"));
//		textM1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textM1.setText("\n  소래포구3S\n\n"+"  남동구 논현동");
//		textM1.setEditable(false);
//		textM1.setBackground(Color.white);
//
//		panelList22.setLayout(new BorderLayout());
//		panelList22.setBorder(new LineBorder(blue));
//		panelList22.add("West", labelM12);
//		panelList22.add("Center", textM2);
//		labelM12.setIcon(new ImageIcon("img/MotelGu.jpg"));
//		textM2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textM2.setText("\n  구월동 구월호텔 九\n\n"+"  인천터미널역 도보 14분");
//		textM2.setEditable(false);
//		textM2.setBackground(Color.white);
//
//		panelList23.setLayout(new BorderLayout());
//		panelList23.setBorder(new LineBorder(blue));
//		panelList23.add("West", labelM13);
//		panelList23.add("Center", textM3);
//		labelM13.setIcon(new ImageIcon("img/MotelBr.jpg"));
//		textM3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textM3.setText("\n  하단 브라운도트 호텔-하단점\n\n"+"  하단역 도보 6분");
//		textM3.setEditable(false);
//		textM3.setBackground(Color.white);
//
//		panelList24.setLayout(new BorderLayout());
//		panelList24.setBorder(new LineBorder(blue));
//		panelList24.add("West", labelM14);
//		panelList24.add("Center", textM4);
//		labelM14.setIcon(new ImageIcon("img/MotelBo.jpg"));
//		textM4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textM4.setText("\n  구포 본호텔-구 바르도호텔\n\n"+"  덕천역 도보 9분");
//		textM4.setEditable(false);
//		textM4.setBackground(Color.white);
//
//		// 펜션 탭
//		panelPension.setLayout(new BorderLayout());
//		panelPension.add("Center", panelPension1);
//		
//		panelPension1.setLayout(new GridLayout(4, 1));
//		panelPension1.add(panelList31);
//		panelPension1.add(panelList32);
//		panelPension1.add(panelList33);
//		panelPension1.add(panelList34);
//
//		panelList31.setLayout(new BorderLayout());
//		panelList31.setBorder(new LineBorder(blue));
//		panelList31.add("West", labelP11);
//		panelList31.add("Center", textP1);
//		labelP11.setIcon(new ImageIcon("img/PenSen.jpg"));
//		textP1.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textP1.setText("\n  태안 센티마르펜션 글램핑&카라반\n\n"+"  태안군) 학암포해수욕장 도보 5분");
//		textP1.setEditable(false);
//		textP1.setBackground(Color.white);
//
//		panelList32.setLayout(new BorderLayout());
//		panelList32.setBorder(new LineBorder(blue));
//		panelList32.add("West", labelP12);
//		panelList32.add("Center", textP2);
//		labelP12.setIcon(new ImageIcon("img/PenGa.jpg"));
//		textP2.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textP2.setText("\n  가평 풀빌라&글램핑랜드\n\n"+"  가평군) 쁘띠프랑스 차량 11분");
//		textP2.setEditable(false);
//		textP2.setBackground(Color.white);
//
//		panelList33.setLayout(new BorderLayout());
//		panelList33.setBorder(new LineBorder(blue));
//		panelList33.add("West", labelP13);
//		panelList33.add("Center", textP3);
//		labelP13.setIcon(new ImageIcon("img/PenSt.jpg"));
//		textP3.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textP3.setText("\n  포항 씨엔스톤\n\n"+"  포항시) 청진해변 바로 앞");
//		textP3.setEditable(false);
//		textP3.setBackground(Color.white);
//
//		panelList34.setLayout(new BorderLayout());
//		panelList34.setBorder(new LineBorder(blue));
//		panelList34.add("West", labelP14);
//		panelList34.add("Center", textP4);
//		labelP14.setIcon(new ImageIcon("img/PenSa.jpg"));
//		textP4.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 14));
//		textP4.setText("\n  서귀포 사계해담은스파펜션\n\n"+"  서귀포시) 용머리해안 차량 3분");
//		textP4.setEditable(false);
//		textP4.setBackground(Color.white);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		textH1.addMouseListener(this);
		textH2.addMouseListener(this);
		textH3.addMouseListener(this);
		textH4.addMouseListener(this);
		textM1.addMouseListener(this);
		textM2.addMouseListener(this);
		textM3.addMouseListener(this);
		textM4.addMouseListener(this);
		textP1.addMouseListener(this);
		textP2.addMouseListener(this);
		textP3.addMouseListener(this);
		textP4.addMouseListener(this);
		buttonR.addMouseListener(this);
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		saveDTO svdto = new saveDTO();
		//MyBookingRoomFrame mf = new MyBookingRoomFrame();
		
		if(e.getSource()==buttonR) {
			UserRoomListFrame ur = new UserRoomListFrame();
			ur.setVisible(true);
			setVisible(false);
		}
		if(e.getSource()==textH1) {		
			//선택한 숙소 이름
			svdto.setSavePlaceName(mbi.getHotelName(0));
			
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textH2) {
			svdto.setSavePlaceName(mbi.getHotelName(1));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textH3) {
			svdto.setSavePlaceName(mbi.getHotelName(2));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textH4) {
			svdto.setSavePlaceName(mbi.getHotelName(3));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textM1) {
			svdto.setSavePlaceName(mbi.getMotelName(0));
			
			
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textM2) {
			svdto.setSavePlaceName(mbi.getMotelName(1));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textM3) {
			svdto.setSavePlaceName(mbi.getMotelName(2));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textM4) {
			svdto.setSavePlaceName(mbi.getMotelName(3));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textP1) {
			svdto.setSavePlaceName(mbi.getPensenName(0));
			
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textP2) {
			svdto.setSavePlaceName(mbi.getPensenName(1));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textP3) {
			svdto.setSavePlaceName(mbi.getPensenName(2));
			new MyBookingRoomFrame();
			
		}else if(e.getSource()==textP4) {
			svdto.setSavePlaceName(mbi.getPensenName(3));
			new MyBookingRoomFrame();
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class MyBookingMainFrame {
	public static void main(String[] args) {
		//new MainFrame();
	}

}
