import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class FID extends JFrame implements ActionListener, FocusListener {

	Container container = getContentPane();

	Color blue = new Color(98, 99, 212);

	MyBookingImpl find = new MyBookingImpl();

	JPanel pl_north = new JPanel();
	JPanel pl_north1 = new JPanel();
	JPanel pl_north2 = new JPanel();
	JPanel pl = new JPanel();

	JPanel pl11 = new JPanel();
	JPanel pl12 = new JPanel();
	JPanel pl13 = new JPanel();

	JPanel pl_id = new JPanel();
	JPanel pl_id_lb = new JPanel();
	JPanel pl_id_name = new JPanel();
	JPanel pl_id_tell = new JPanel();
	JPanel pl_id_bt = new JPanel();

	JPanel pl_pw = new JPanel();
	JPanel pl_pw_lb = new JPanel();
	JPanel pl_pw_id = new JPanel();
	JPanel pl_pw_name = new JPanel();
	JPanel pl_pw_tell = new JPanel();
	JPanel pl_pw_bt = new JPanel();

	JLabel lb_north = new JLabel("아이디/비밀번호 찾기");
	JLabel lb_id = new JLabel("");
	JLabel lb_id_name = new JLabel("이   름   ");
	JLabel lb_id_tell = new JLabel("연락처   ");
	JLabel lb_pw = new JLabel("");
	JLabel lb_pw_id = new JLabel("아이디   ");
	JLabel lb_pw_name = new JLabel("이   름   ");
	JLabel lb_pw_tell = new JLabel("연락처   ");
	JLabel under_lbs = new JLabel("________________________________________");

	JTextField tf_id_name = new JTextField(19);
	JTextField tf_id_tell = new JTextField(19);
	JTextField tf_pw_id = new JTextField(19);
	JTextField tf_pw_name = new JTextField(19);
	JTextField tf_pw_tell = new JTextField(19);

	JButton bt_findID = new JButton("아이디 찾기");
	JButton bt_findPw = new JButton("비밀번호 찾기");
	JButton bt_home = new JButton("로그인 화면으로");
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	

	public FID() {
		setIconImage(imageIcon.getImage());
		setSize(400, 600);
		setTitle("My Booking");
		setLocation(500, 200);
		init();
		start();
		setVisible(true);
		setResizable(false);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", pl_north);
		container.add("Center", pl);

		// 아이디 비번 찾기 로고
		pl_north.setLayout(new BorderLayout());
		pl_north.add("North", pl_north1);
		pl_north.setBackground(Color.white);
		pl_north.add("Center", pl_north2);
		pl_north.add("South", pl11);

		pl11.setLayout(new FlowLayout());
		pl11.add(under_lbs);
		pl11.setBackground(Color.white);
		pl11.setPreferredSize(new Dimension(400, 20));

		pl_north1.setPreferredSize(new Dimension(400, 20));
		pl_north1.setBackground(null);

		pl_north2.setLayout(new FlowLayout());
		pl_north2.add(lb_north);
		pl_north2.setBackground(null);

		lb_north.setPreferredSize(new Dimension(250, 70));
		lb_north.setFont(new Font("카페24 써라운드", Font.BOLD, 25));
		lb_north.setForeground(blue);

		// 아이디 비번 찾기 기능부분
		pl.setLayout(new GridLayout(2, 1));
		pl.setBackground(Color.white);
		pl.add(pl_id);
		pl.add(pl_pw);
		pl_id.setBackground(Color.white);

		// 상단부 아이디 찾기
		pl_id.setLayout(new GridLayout(5, 1));

		pl_id.add(pl_id_lb);
		pl_id.add(pl_id_name);
		pl_id.add(pl_id_tell);
		pl_id.add(pl_id_bt);
		pl_id.add(pl12); // 여백용

		pl12.setBackground(Color.white);

		// 테두리 없애기
		pl_id_name.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pl_id_tell.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pl_id_bt.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

		pl_id_lb.setLayout(new FlowLayout());
		pl_id_lb.setBackground(Color.white);
		pl_id_lb.add(lb_id);

		lb_id.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		lb_id.setVerticalAlignment(JLabel.BOTTOM);

		pl_id_name.setLayout(new FlowLayout());
		pl_id_name.setBackground(Color.white);
		pl_id_name.add(lb_id_name);
		pl_id_name.add(tf_id_name);

		lb_id_name.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		tf_id_name.setPreferredSize(new Dimension(250, 30));

		pl_id_tell.setLayout(new FlowLayout());
		pl_id_tell.setBackground(Color.white);
		pl_id_tell.add(lb_id_tell);
		pl_id_tell.add(tf_id_tell);

		lb_id_tell.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		tf_id_tell.setPreferredSize(new Dimension(250, 30));

		pl_id_bt.setLayout(new FlowLayout());
		pl_id_bt.setBackground(Color.white);
		pl_id_bt.add("Center", bt_findID);
		
		tf_id_name.setForeground(Color.LIGHT_GRAY);
		tf_id_tell.setForeground(Color.LIGHT_GRAY);

		bt_findID.setFont(new Font("카페24 써라운드", Font.BOLD, 13));
		bt_findID.setBackground(blue);
		bt_findID.setBorderPainted(false);
		bt_findID.setFocusPainted(false);
		bt_findID.setForeground(Color.white);

		// 하단부 비밀번호 찾기
		pl_pw.setLayout(new GridLayout(5, 1));
		pl_pw.setBackground(Color.white);

		pl_pw.add(pl_pw_id);
		pl_pw.add(pl_pw_name);
		pl_pw.add(pl_pw_tell);
		pl_pw.add(pl_pw_bt);
		pl_pw.add(pl_pw_lb);
		// pl_pw.add(pl13);

		// 배경색
		pl_pw_lb.setBackground(Color.white);
		pl_pw_id.setBackground(Color.white);
		pl_pw_name.setBackground(Color.white);
		pl_pw_tell.setBackground(Color.white);
		pl_pw_bt.setBackground(Color.white);
		pl13.setBackground(Color.white);

		pl_pw_id.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pl_pw_name.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pl_pw_tell.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pl_pw_bt.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

		pl_pw_lb.setLayout(new FlowLayout(FlowLayout.CENTER));
		pl_pw_lb.add(lb_pw);
		lb_pw.setFont(new Font("카페24 써라운드", Font.BOLD, 15));

		pl_pw_id.setLayout(new FlowLayout());
		pl_pw_id.add(lb_pw_id);
		pl_pw_id.add(tf_pw_id);

		pl_pw_name.setLayout(new FlowLayout());
		pl_pw_name.add(lb_pw_name);
		pl_pw_name.add(tf_pw_name);

		pl_pw_tell.setLayout(new FlowLayout());
		pl_pw_tell.add(lb_pw_tell);
		pl_pw_tell.add(tf_pw_tell);

		pl_pw_bt.setLayout(new FlowLayout());
		pl_pw_bt.add(bt_findPw);

		bt_findPw.setBackground(blue);
		bt_findPw.setBorderPainted(false);
		bt_findPw.setFocusPainted(false);
		bt_findPw.setForeground(Color.white);

		// text크기
		tf_pw_id.setPreferredSize(new Dimension(250, 30));
		tf_pw_name.setPreferredSize(new Dimension(250, 30));
		tf_pw_tell.setPreferredSize(new Dimension(250, 30));

		// text폰트 색
		tf_pw_id.setForeground(Color.LIGHT_GRAY);
		tf_pw_name.setForeground(Color.LIGHT_GRAY);
		tf_pw_tell.setForeground(Color.LIGHT_GRAY);

		// 폰트
		lb_pw_id.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		lb_pw_name.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		lb_pw_tell.setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));
		bt_findPw.setFont(new Font("카페24 써라운드", Font.BOLD, 13));
		
		tf_id_name.setText("이름을 입력하세요");
		tf_id_tell.setText("010-XXXX-XXXX"); 
		tf_pw_id.setText("아이디를 입력하세요");
		tf_pw_name.setText("이름을 입력하세요");
		tf_pw_tell.setText("010-XXXX-XXXX") ;
		

	}

	private void start() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		bt_findID.addActionListener(this);
		bt_findPw.addActionListener(this);

		tf_id_name.addFocusListener(this);
		tf_id_tell.addFocusListener(this);
		tf_pw_id.addFocusListener(this);
		tf_pw_name.addFocusListener(this);
		tf_pw_tell.addFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_findID) { // 아이디 찾기 버튼 클릭시
			String name = tf_id_name.getText();
			String tell = tf_id_tell.getText();

			if (name.equals("") || name.equals("이름을 입력하세요")) {
				JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (tell.equals("") || tell.equals("010-XXXX-XXXX")) {
				JOptionPane.showMessageDialog(this, "전화번호를 입력해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String result_id = find.find_Id(name, tell);

			if (result_id != "") {
				JOptionPane.showMessageDialog(this, name + "님의 아이디는 " + result_id + " 입니다", "정보",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "등록된 아이디가 없습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
			}

			clear_tf_id();
		}

		// 비밀번호 찾기 버튼 클릭시
		else if (e.getSource() == bt_findPw) {
			String id = tf_pw_id.getText();
			String name = tf_pw_name.getText();
			String tell = tf_pw_tell.getText();

			if (id.equals("") || id.equals("아이디를 입력하세요")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (name.equals("") || name.equals("이름을 입력하세요")) {
				JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (tell.equals("") || tell.equals("010-XXXX-XXXX")) {
				JOptionPane.showMessageDialog(this, "전화번호를 입력해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String result_pw = find.find_Pw(id, name, tell);

			if (result_pw != "") {
				JOptionPane.showMessageDialog(this, name + "님의 비밀번호는 " + result_pw + " 입니다", "정보",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "등록된 아이디가 없습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
			}

			clear_tf_pw();

		} else if (e.getSource() == bt_home) {

		}

	}

	public void clear_tf_id() {
		tf_id_name.setText("이름을 입력하세요");
		tf_id_name.setForeground(Color.LIGHT_GRAY);
		tf_id_tell.setText("010-XXXX-XXXX");
		tf_id_tell.setForeground(Color.LIGHT_GRAY);
	}

	public void clear_tf_pw() {
		tf_pw_id.setText("아이디를 입력하세요");
		tf_pw_id.setForeground(Color.LIGHT_GRAY);
		tf_pw_name.setText("이름을 입력하세요");
		tf_pw_name.setForeground(Color.LIGHT_GRAY);
		tf_pw_tell.setText("010-XXXX-XXXX");
		tf_pw_tell.setForeground(Color.LIGHT_GRAY);
	}

	// 그뭐냐 입력칸 임시 메시지 작성 클릭시 빈칸됨
	@Override
	public void focusGained(FocusEvent e) {
		JTextField textField = (JTextField) e.getSource();
		
		String tempText = "";
		if (textField == tf_id_name) {
			tempText = "이름을 입력하세요";
		} else if (textField == tf_id_tell) {
			tempText = "010-XXXX-XXXX";
		} else if (textField == tf_pw_id) {
			tempText = "아이디를 입력하세요";
		} else if (textField == tf_pw_name) {
			tempText = "이름을 입력하세요";
		} else if (textField == tf_pw_tell) {
			tempText = "010-XXXX-XXXX";
		}
		if (textField.getText().equals(tempText)) {
			textField.setText("");
			textField.setForeground(Color.black);
		}

	}

	// 입력칸에 텍스트 입력 없고 다른곳 클릭시 다시 임시메시지 나옴
	@Override
	public void focusLost(FocusEvent e) {
		JTextField textField = (JTextField) e.getSource();
		String tempText = "";
		
		if (textField == tf_id_name) {
			tempText = "이름을 입력하세요";
		} else if (textField == tf_id_tell) {
			tempText = "010-XXXX-XXXX";
		} else if (textField == tf_pw_id) {
			tempText = "아이디를 입력하세요";
		} else if (textField == tf_pw_name) {
			tempText = "이름을 입력하세요";
		} else if (textField == tf_pw_tell) {
			tempText = "010-XXXX-XXXX";
		}
		if (textField.getText().isEmpty()) {
			textField.setForeground(Color.lightGray);
			textField.setText(tempText);
		}

	}

}

public class Find_ID_PW_Frame {
	public static void main(String[] args) {
		//new FID();
	}

}
