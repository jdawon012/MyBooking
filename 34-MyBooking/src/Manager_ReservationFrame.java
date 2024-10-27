// 관리자 예약 관리 화면

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class MR extends JFrame implements ActionListener {
	Container container = getContentPane();
	List<String> dataList = new ArrayList<String>();
	JList<String> list = new JList<>();
	
	ImageIcon reload = new ImageIcon("img/reload.png");
	
	Color blue = new Color(98, 99, 212);

	JPanel[] big_pns = new JPanel[3];

	// 패널
	JPanel topPns = new JPanel();
	JPanel botPns = new JPanel();

	// 제목
	JLabel tit_lbs = new JLabel("관리자용 예약 관리");
	JLabel under_lbs = new JLabel("_____________________________________");

	// 스크롤
	JScrollPane scrollPane = new JScrollPane(list);

	// 버튼
	JButton Ybutton = new JButton("수락");
	JButton Nbutton = new JButton("거절");
	// 버튼 클릭 시 select를 시켜줌으로써 실시간으로 들어오는 데이터를 동기화 시킴(누락되는 데이터를 없애기 위함)
	JButton restart = new JButton(reload);

	public MR() {
		setSize(400, 600);
		setLocation(900, 200);
		setTitle("My Booking 관리자용");

		init();
		start();

		setResizable(false);
		setVisible(true);
	}

	private void init() {
		// 메인 틀 조정
		container.setLayout(new BorderLayout());

		for (int i = 0; i < big_pns.length; i++) {
			big_pns[i] = new JPanel();
		}

		// 양 끝 공백 만들기 위함
		container.add("West", big_pns[0]);
		container.setBackground(Color.white);
		container.add("Center", big_pns[1]); // 사용한 메인 패널
		container.add("East", big_pns[2]);
		big_pns[0].setPreferredSize(new Dimension(20, 600));
		big_pns[2].setPreferredSize(new Dimension(20, 600));

		big_pns[1].setLayout(new BorderLayout());
		big_pns[1].setBackground(Color.white);
		big_pns[1].add("North", topPns); // 위 패널
		big_pns[1].add("Center", scrollPane); // 스크롤
		big_pns[1].add("South", botPns); // 아래 패널

		// 위 패널
		topPns.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topPns.add("Center",tit_lbs);
		topPns.add("East", restart);
		
		tit_lbs.setFont(new Font("카페24 써라운드", Font.BOLD, 28)); // 글자 설정
		tit_lbs.setForeground(blue);
		tit_lbs.setBackground(Color.white);
		
		restart.setBackground(null);
		restart.setBorderPainted(false);
		restart.setFocusPainted(false);

		// 아래 패널
		//botPns.add(Ybutton); // 수락
		botPns.add(Nbutton); // 거절
		
		Ybutton.setBackground(blue);
		Ybutton.setForeground(Color.white);
		Ybutton.setFocusPainted(false);
		Ybutton.setBorderPainted(false);
		Ybutton.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		
		Nbutton.setBackground(blue);
		Nbutton.setForeground(Color.white);
		Nbutton.setFocusPainted(false);
		Nbutton.setBorderPainted(false);
		Nbutton.setFont(new Font("카페24 써라운드", Font.BOLD, 15));
		
		topPns.setBackground(Color.white);
		botPns.setBackground(Color.white);
		big_pns[0].setBackground(Color.white);
		big_pns[1].setBackground(Color.white);
		big_pns[2].setBackground(Color.white);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Ybutton.addActionListener(this);
		Nbutton.addActionListener(this);

		// 예약 입력 테이블이랑 관리자 예약 관리 프로그램 테이블을 같게 해야 코딩이 쉽다.
		// 예약 입력 시 지점 고유 코드(기본키)와 관련된 데이터만 select 함(search를 이용)
		// 추가 버튼 이벤트 처리

		// 삭제 버튼 이벤트 처리 <- 이 부분은 추가 혹은 삭제를 클릭 시 해당 리스트를 자동으로 삭제시키게끔 만들어야 한다.

	}

	private void updateJList() { // <- 이건 건들 필요 없다.
		// ArrayList를 배열로 변환하여 JList 업데이트
		list.setListData(dataList.toArray(new String[0]));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Ybutton) {
			int[] selectedIndices = list.getSelectedIndices();
			for (int i = selectedIndices.length - 1; i >= 0; i--) {
				dataList.remove(selectedIndices[i]);
			}
			// JList 업데이트
			updateJList();
		} else if (e.getSource() == Nbutton) {
			int[] selectedIndices = list.getSelectedIndices();
			for (int i = selectedIndices.length - 1; i >= 0; i--) {
				dataList.remove(selectedIndices[i]);
			}
			// JList 업데이트
			updateJList();
		}

	}
}

public class Manager_ReservationFrame {
	public static void main(String[] args) {
		new MR();
	}
}
