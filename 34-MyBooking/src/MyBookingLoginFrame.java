import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.tools.javac.Main;

class logFrame extends JFrame implements ActionListener, KeyListener {
	
	MemberDAO memdao = new MemberDAO();
	ManegerDAO menadao = new ManegerDAO();
	
	Container container = getContentPane();

	JCheckBox checkManager = new JCheckBox("관리자 로그인");
	
	Color blue = new Color(98, 99, 212);
	Color gray = new Color(95, 95, 95);

	JLabel labelId = new JLabel("아이디 ", JLabel.RIGHT);
	JLabel labelPw = new JLabel("비밀번호 ", JLabel.RIGHT);
	JLabel labelLogo = new JLabel();

	JTextField textId = new JTextField(10);
	JPasswordField textPw = new JPasswordField(10);

	JButton buttonLogin = new JButton("로그인");
	JButton buttonFind = new JButton("아이디/비밀번호\n 찾기");
	JButton buttonJoin = new JButton("회원가입");

	JPanel panelLogo = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelCheck = new JPanel();
	JPanel panelId = new JPanel();
	JPanel panelPw = new JPanel();
	JPanel panelLogin = new JPanel();
	JPanel panelButton = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel panelIdPwLog = new JPanel();
	JPanel panelIdId = new JPanel();
	JPanel panelPwPw = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	public logFrame() {
		setIconImage(imageIcon.getImage());
		setLocationRelativeTo(null);
		setSize(400, 600);
		setLocation(700, 200);
		setTitle("My Booking");
		init();
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panelLogo);
		container.add("Center", panelCenter);
		container.add("South", panelSouth);

		panelLogo.setLayout(new BorderLayout());
		panelLogo.add(labelLogo);

		labelLogo.setIcon(new ImageIcon("img/MyBookingLogo.jpg"));
		labelLogo.setPreferredSize(new Dimension(400, 200));

		panelCenter.setLayout(new GridLayout(3, 1, 10, 5));
		panelCenter.setBackground(Color.white);
		panelCenter.add(panelCheck);
		panelCenter.add(panel1);
		panelCenter.add(panelButton);

		panelCheck.setLayout(new BorderLayout());
		panelCheck.add("North", panel5);
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(400, 40));
		panelCheck.add("West", panel4);
		panel4.setBackground(Color.white);
		panel4.setPreferredSize(new Dimension(85, 20));
		panelCheck.add("Center", checkManager);
		
		checkManager.setBackground(Color.white);
		checkManager.setFocusPainted(false);
		checkManager.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 11));

		panel1.setLayout(new BorderLayout());
		panel1.setBackground(Color.white);
		panel1.add("West", panel2);
		panel1.add("Center", panelIdPwLog);
		panel1.add("East", panel3);
		
		panel2.setPreferredSize(new Dimension(30, 50));
		panel3.setPreferredSize(new Dimension(40, 50));
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);

		panelIdPwLog.setLayout(new BorderLayout(5, 5));
		panelIdPwLog.add("East", panelLogin);
		panelIdPwLog.add("West", panelIdId);
		panelIdPwLog.add("Center", panelPwPw);
		panelIdPwLog.setBackground(Color.white);

		panelIdId.setLayout(new GridLayout(2, 1, 0, 5));
		panelIdId.setBackground(Color.white);
		panelIdId.add(labelId);
		panelIdId.add(labelPw);
		
		labelId.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		labelPw.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));


		panelPwPw.setLayout(new GridLayout(2, 1, 0, 5));
		panelPwPw.setBackground(Color.white);
		panelPwPw.add(textId);
		panelPwPw.add(textPw);

		panelLogin.setLayout(new BorderLayout());
		panelLogin.add(buttonLogin);
		buttonLogin.setBackground(new Color(98, 99, 212));
		buttonLogin.setForeground(Color.white);
		buttonLogin.setFocusPainted(false);
		buttonLogin.setFont(new Font("카페24 써라운드", Font.PLAIN, 15));

		panelButton.setLayout(new FlowLayout());
		panelButton.setBackground(Color.white);
		panelButton.add(buttonFind);
		panelButton.add(buttonJoin);
		
		buttonFind.setBorderPainted(false);
		buttonFind.setBackground(Color.white);
		buttonFind.setFocusPainted(false);
		buttonFind.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		buttonFind.setForeground(gray);
		
		buttonJoin.setBorderPainted(false);
		buttonJoin.setBackground(Color.white);
		buttonJoin.setFocusPainted(false);
		buttonJoin.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		buttonJoin.setForeground(gray);

		panelSouth.setPreferredSize(new Dimension(400, 120));
		panelSouth.setBackground(Color.white);

	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		buttonFind.addActionListener(this);
		buttonJoin.addActionListener(this);
		buttonLogin.addActionListener(this);
		checkManager.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == buttonLogin) {
			String ID = textId.getText();
			String PW = textPw.getText();

			if (textId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.", "Error", JOptionPane.WARNING_MESSAGE);
			} 
			if(checkManager.isSelected()) {
				int result = menadao.mlogin(ID, PW);
				if(result == 1) {
					saveDTO dto = new saveDTO();
					dto.setSaveManegerId(ID);
					new MW();
					
				}else if(result==0) {
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-1) {
					JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-2) {
					JOptionPane.showMessageDialog(this, "데이터베이스 오류가 발생했습니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				int result = memdao.ulogin(ID, PW);
				if(result == 1) {
					saveDTO dto = new saveDTO();
					dto.setSaveUserId(ID);
					new MainFrame();
				}else if(result==0) {
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-1) {
					JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}else if(result==-2) {
					JOptionPane.showMessageDialog(this, "데이터베이스 오류가 발생했습니다.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			//saveDTO 에 로그인한 아이디 값 저장
//			saveDTO dto = new saveDTO();
//			dto.setSaveUserId(ID);
			
			//System.out.println(dto.getSaveUserId());
			
			
		}else if(e.getSource()==buttonFind) {
			new FID();
		}else if(e.getSource()==buttonJoin) {
			new CA();
		}else if(e.getSource()==checkManager) {
			textId.setText("");
			textPw.setText("");
			
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class MyBookingLoginFrame {
	public static void main(String[] args) {
		
		new logFrame();
	}
}
