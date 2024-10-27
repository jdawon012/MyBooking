
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MW extends JFrame implements ActionListener {

	String id;
	Maneger_WinDAO dao = new Maneger_WinDAO();
	Maneger_Win_Impl mp = new Maneger_Win_Impl();

	// 생성자에서 사용할 변수들
	JTextArea[] textAreas;
	JButton[] insertButtons;
	JButton[] deleteButtons;
	
	JButton homeButton = new JButton("홈으로");
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	

	public MW() {
		// this.id = id;
		setIconImage(imageIcon.getImage());
		setTitle("My Booking");
		setSize(500, 600);
		setLocationRelativeTo(null); // 화면 중앙에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		initComponents();
		addComponents();
		addActionListeners();

		setVisible(true);
	}

	private void initComponents() {
		// Text areas
		textAreas = new JTextArea[4];
		for (int i = 0; i < textAreas.length; i++) {
			textAreas[i] = new JTextArea();
			textAreas[i].setEditable(false);
			textAreas[i].setFont(new Font("카페24 써라운드", Font.BOLD, 12));

			// 텍스트 영역에 문자열 추가
			textAreas[i].setText(mp.getInfor(i));
		}

		// Insert buttons
		insertButtons = new JButton[4]; // 승인 버튼
		deleteButtons = new JButton[4]; // 거절 버튼
		for (int i = 0; i < insertButtons.length; i++) {
			// 승인 버튼 디자인 설정
			insertButtons[i] = new JButton("승인");
			insertButtons[i].setBackground(new Color(98, 99, 212));
			insertButtons[i].setForeground(Color.white);
			insertButtons[i].setFont(new Font("카페24 써라운드", Font.BOLD, 15));
			insertButtons[i].setPreferredSize(new Dimension(120, 40));
			insertButtons[i].setBorder(BorderFactory.createLineBorder(Color.white, 2));
			insertButtons[i].setFocusPainted(false);

			// 거절 버튼 디자인 설정
			deleteButtons[i] = new JButton("거절");
			deleteButtons[i].setBackground(new Color(98, 99, 212));
			deleteButtons[i].setForeground(Color.white);
			deleteButtons[i].setFont(new Font("카페24 써라운드", Font.BOLD, 15));
			deleteButtons[i].setPreferredSize(new Dimension(120, 40));
			deleteButtons[i].setBorder(BorderFactory.createLineBorder(Color.white, 2));
			deleteButtons[i].setFocusPainted(false);
		}
	}

	private void addComponents() {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// 상단 패널 설정
		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.setBackground(Color.white);
		
		// Title
				JLabel titleLabel = new JLabel("관리자용 예약관리");
				titleLabel.setFont(new Font("카페24 써라운드", Font.BOLD, 24));
				titleLabel.setForeground(new Color(98, 99, 212));
				topPanel.add(titleLabel, BorderLayout.CENTER);


		// Logo
		ImageIcon logoIcon = new ImageIcon("img/hotel.png"); // 로고 이미지 경로에 맞게 수정
		Image scaledLogoImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
		JLabel logoLabel = new JLabel(scaledLogoIcon);
		topPanel.add(logoLabel, BorderLayout.EAST);

		
		// Center panel
		JPanel centerPanel = new JPanel(new GridLayout(4, 1));
		centerPanel.setBackground(Color.white);
		for (int i = 0; i < 4; i++) {
			JPanel panel = new JPanel(new BorderLayout());
			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createLineBorder(new Color(98, 99, 212), 1));

			JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			ImageIcon roomIcon = new ImageIcon(mp.getImg(i));
			Image scaledRoomImage = roomIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon scaledRoomIcon = new ImageIcon(scaledRoomImage);
			JLabel roomImageLabel = new JLabel(scaledRoomIcon);
			imagePanel.add(roomImageLabel);

			JPanel textAreaPanel = new JPanel(new FlowLayout());
			textAreaPanel.add(textAreas[i]);
			textAreaPanel.setBackground(Color.white);
			

			JPanel buttonPanel = new JPanel(new GridLayout(2, 1)); // 2행 1열로 버튼 배치
			buttonPanel.setBackground(Color.white);
			buttonPanel.add(insertButtons[i]);
			buttonPanel.add(deleteButtons[i]);
			if (mp.bt_onoff(i) == 0) {
				buttonPanel.setVisible(false);
			}
			

			panel.add(imagePanel, BorderLayout.WEST);
			panel.add(textAreaPanel, BorderLayout.CENTER);
			panel.add(buttonPanel, BorderLayout.EAST);
			
			centerPanel.add(panel);
			
		}

		// Bottom panel
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.setBackground(Color.white);
//		JButton homeButton = new JButton("홈으로");
		homeButton.setBackground(new Color(98, 99, 212));
		homeButton.setForeground(Color.white);
		homeButton.setFont(new Font("카페24 써라운드", Font.BOLD, 13));
		bottomPanel.add(homeButton);

		// Add panels to container
		container.add(topPanel, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);
		container.add(bottomPanel, BorderLayout.SOUTH);
	}

	private void addActionListeners() {
		for (int i = 0; i < insertButtons.length; i++) {
			insertButtons[i].addActionListener(this);
			deleteButtons[i].addActionListener(this);
		}
		
		homeButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Insert 버튼 또는 Delete 버튼 클릭 시 동작하는 내용
		for (int i = 0; i < deleteButtons.length; i++) {
			
			if (e.getSource() == deleteButtons[i]) {
				if (mp.roomCancel(i) == 1) {
					JOptionPane.showMessageDialog(this, "거절", "예약 취소", JOptionPane.WARNING_MESSAGE);
					restart();
				} else if (mp.roomCancel(i) == 0) {
					JOptionPane.showMessageDialog(this, "db에 취소할 리스트가 없는데 어캄", "예약 취소", JOptionPane.WARNING_MESSAGE);
				} 
			}
			if (e.getSource() == insertButtons[i]) {
				if (mp.roomCheck(i) == 1) {
					
					JOptionPane.showMessageDialog(this, "승인", "예약 확인", JOptionPane.INFORMATION_MESSAGE);
					restart();
				} else if (mp.roomCheck(i) == 0) {
					JOptionPane.showMessageDialog(this, "db에 취소할 리스트가 없는데 어캄", "예약 취소", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		
		
		
		if(e.getSource()==homeButton) {
			dispose();
			new logFrame();
		}
	}

	public void restart() {
		// 화면을 새로고침하는 코드 작성
		//dispose();
		setVisible(false); // 현재 화면을 숨기고
		new MW(); // 새로운 예약 목록 화면 생성
	}
}

//public class Maneger_Win {
//	public static void main(String[] args) {
//		// new LoginFrame();
//		new MW();
//	}
//}
