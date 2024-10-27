import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Room_ReservationFrame extends JFrame implements ActionListener {
	saveDTO svdto;
	
	MyBookingImpl rr = new MyBookingImpl();
	Container container = getContentPane();
	

	JPanel pl_north = new JPanel();
	JPanel pl_c = new JPanel();
	JPanel pl_south = new JPanel();
	JPanel pl_south_price = new JPanel();
	JPanel pl_south_bt = new JPanel();

	JPanel pl_c_center = new JPanel();
	JPanel pl_c_south = new JPanel();

	JPanel pl_c_up_img = new JPanel(); // 이미지 둘 판낼
	JPanel pl_c_up = new JPanel();

	JPanel pl_c_down = new JPanel(); // 방 정보 및 유저 이름 판낼
	JPanel pl_c_down_room = new JPanel();
	JPanel pl_c_down_user = new JPanel();

	JPanel pl_c_south_ga = new JPanel();
	JPanel pl_c_south_price = new JPanel();

	JTextArea ta_roomInfor = new JTextArea();
	JTextArea ta_userInfor = new JTextArea();

	JTextField tf_price = new JTextField("", 6);

	JButton bt_rsv = new JButton("예약하기");
	JButton bt_cc = new JButton("취소하기");

	JLabel lb_top = new JLabel("예약하기");
	JLabel lb_img = new JLabel();

	JLabel lb_price_name = new JLabel("가격");
	JLabel lb_price = new JLabel();
	ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	

	public Room_ReservationFrame() {
		setIconImage(imageIcon.getImage());
		setSize(400, 600);
		setTitle("My Booking");
		setLocation(900, 200);

		
		init();
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		int num = svdto.getSaveRoomNum();
		
		container.setLayout(new BorderLayout());
		container.add("North", pl_north);
		container.add("Center", pl_c);
		container.add("South", pl_south);

		// 상단
		pl_north.setLayout(new FlowLayout(FlowLayout.CENTER));
		pl_north.add(lb_top);
		//pl_north.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		pl_north.setBackground(new Color(98, 99, 212));
		lb_top.setPreferredSize(new Dimension(70, 30));
		lb_top.setForeground(Color.white);
		lb_top.setFont(new Font("카페24 써라운드", Font.PLAIN, 15));

		// 중단
		pl_c.setLayout(new BorderLayout());
		pl_c.add("Center", pl_c_center);

		pl_c_center.setLayout(new GridLayout(2, 1));
		pl_c_center.add(pl_c_up);
		pl_c_center.add(pl_c_down);
		
		//방 큰 이미지
		pl_c_up.setLayout(new FlowLayout(FlowLayout.CENTER));
		pl_c_up.add(lb_img);
		pl_c_up.setBackground(Color.white);
		

		
		//이미지을 왜
		lb_img.setIcon(new ImageIcon(rr.getBigImage(num)));
		lb_img.setPreferredSize(new Dimension(340, 200));
		

		pl_c_down.setLayout(new GridLayout(2, 1));
		pl_c_down.add(pl_c_down_room);
		pl_c_down.add(pl_c_down_user);
		pl_c_down.setBorder(BorderFactory.createLineBorder(new Color(98, 99, 212), 1));

		pl_c_down_room.setLayout(new BorderLayout());
		pl_c_down_room.add(ta_roomInfor);
		
		
		//방 정보
		ta_roomInfor.setEditable(false);
		ta_roomInfor.setText(rr.output_room());
		ta_roomInfor.setFont(new Font("카페24 써라운드", Font.PLAIN, 13));

		//사용자 정보
		pl_c_down_user.setLayout(new BorderLayout());
		pl_c_down_user.add(ta_userInfor);
		ta_userInfor.setEditable(false);
		ta_userInfor.setText(rr.output_user());
		ta_userInfor.setFont(new Font("카페24 써라운드", Font.PLAIN, 13));

		pl_south.setLayout(new GridLayout(2, 1));
		pl_south.add(pl_south_price);
		pl_south.add(pl_south_bt);

		pl_south_price.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pl_south_price.add(lb_price_name);
		pl_south_price.add(lb_price);
		pl_south_price.setBackground(Color.white);
		
		lb_price_name.setForeground(new Color(98, 99, 212));
		lb_price_name.setFont(new Font("카페24 써라운드", Font.PLAIN, 20));
		
		lb_price.setText(rr.roomprice());
		lb_price.setForeground(new Color(98, 99, 212));
		lb_price.setFont(new Font("카페24 써라운드", Font.PLAIN, 20));

		pl_south_bt.setLayout(new FlowLayout(FlowLayout.CENTER));
		pl_south_bt.add(bt_rsv);
		pl_south_bt.add(bt_cc);
		pl_south_bt.setBackground(Color.white);
		

		bt_rsv.setBackground(new Color(98, 99, 212));
		bt_rsv.setForeground(Color.white);
		bt_rsv.setFocusPainted(false);
		bt_rsv.setFont(new Font("카페24 써라운드", Font.PLAIN, 15));

		bt_cc.setBackground(new Color(98, 99, 212));
		bt_cc.setForeground(Color.white);
		bt_cc.setFocusPainted(false);
		bt_cc.setFont(new Font("카페24 써라운드", Font.PLAIN, 15));

	}

	private void start() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		bt_cc.addActionListener(this);
		bt_rsv.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bt_cc) {
			dispose();
			
			
		}else if (e.getSource() == bt_rsv) {
			if (rr.Reservation() == 0) { // db 수정함
				JOptionPane.showMessageDialog(this, "예약 실패입니다 왠진모름", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "예약 되었습니다.", "안내", JOptionPane.WARNING_MESSAGE);
				dispose();
				
				
			}
		}refresh();
	}
	
	
	public void refresh() {
	    // 화면을 새로고침하는 코드 작성
	    setVisible(false); // 현재 화면을 숨기고
	    new MyBookingRoomFrame(); // 새로운 예약 목록 화면 생성
	}
	
	
	
}
