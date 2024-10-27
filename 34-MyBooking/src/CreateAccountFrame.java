

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class CA extends JFrame implements ActionListener {

	Color blue = new Color(98, 99, 212);
    MyBookingImpl mpip = new MyBookingImpl();

    Container container = getContentPane();
    JPanel[] big_pns = new JPanel[6]; // 큰 패널(전체 구조)

    JPanel logo_pns = new JPanel();
    JPanel tit_pns = new JPanel();
    JPanel[] sml_pns = new JPanel[7]; // 작은 패널(패널 당 구조)
    
    JPanel ac_btn_pns = new JPanel();

    JLabel tit_lbs = new JLabel("회원가입");
    JLabel under_lbs = new JLabel("_____________________________________");

    JLabel[] lbs = new JLabel[7];
    String[] lbs_strs = { "아이디", "비밀번호", "비밀번호 확인", "이름", "생년월일", "전화번호", "이메일"};

    JTextField[] tfs = new JTextField[5];
    JPasswordField[] pfs = new JPasswordField[2];

    JButton[] btns = new JButton[2];
    String[] btns_strs = { "가입하기", "취소" };
    
    ImageIcon logo = new ImageIcon("img/logo.png"); // 기본은 x 조건 만족하면 o로 변경(ActionListener 에
    Image logo_image = logo.getImage().getScaledInstance(70, 35, Image.SCALE_SMOOTH);
    ImageIcon scaledlogo = new ImageIcon(logo_image);

    ImageIcon icon = new ImageIcon("img/no.png"); // 기본은 x 조건 만족하면 o로 변경(ActionListener 에
    Image image = icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(image);
    ImageIcon imageIcon = new ImageIcon("img/hotel.png");
	
    
    
    // 글자 설정
    Font font = new Font("카페24 써라운드 에어 ", Font.BOLD, 15);
    Font lbsfont = new Font("카페24 써라운드", Font.BOLD, 30); // lbsfont: 글자 굵음, 크기 30

    public CA() {
    	setIconImage(imageIcon.getImage());
        setSize(400, 600);
        setLocation(300, 200);
        setTitle("My Booking");

        init();
        start();

        setResizable(false);
        setVisible(true);
    }

    private void init() {
        container.setLayout(new BorderLayout());
        for (int i = 0; i < big_pns.length; i++) {
            big_pns[i] = new JPanel();
            big_pns[i].setBackground(Color.WHITE);
        }

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(btns_strs[i]);
            btns[i].setBackground(Color.WHITE);
            btns[i].setFont(new Font("카페24 써라운드", Font.BOLD, 15));
        }
        
        // 로고 설정 (header)
        container.add("North", logo_pns);
        logo_pns.setBorder(new EmptyBorder(30,0,0,0));
        logo_pns.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel logoLabel = new JLabel(scaledlogo);
        logo_pns.setBackground(Color.WHITE);
        logo_pns.add("West",logoLabel);
        logo_pns.add("Center",tit_lbs);
        
        logoLabel.setBorder(new EmptyBorder(0,65,0,0));
        
        // 메인 설정 (body)
        container.add("West", big_pns[0]);
        big_pns[0].setPreferredSize(new Dimension(20, 600));
        container.add("Center", big_pns[1]); // 사용한 메인 패널
        container.add("East", big_pns[2]);
        big_pns[2].setPreferredSize(new Dimension(20, 600));

        big_pns[1].setLayout(new BorderLayout());

        big_pns[1].add("North", big_pns[3]);
        big_pns[1].add("Center", big_pns[4]);
        big_pns[1].add("South", big_pns[5]);

        big_pns[3].setLayout(new FlowLayout(FlowLayout.CENTER));

        big_pns[4].setLayout(new BoxLayout(big_pns[4], BoxLayout.Y_AXIS)); // 수직으로 컴포넌트를 배치하는 BoxLayout으로 변경

        big_pns[4].add(tit_pns); // 타이틀 패널 삽입
        tit_pns.setLayout(new FlowLayout(FlowLayout.CENTER));
        tit_pns.setBackground(Color.white);
        //tit_pns.add(tit_lbs);
        tit_pns.add(under_lbs); // 가로 줄
        tit_lbs.setFont(lbsfont);
        tit_lbs.setForeground(blue);

        for (int i = 0; i < sml_pns.length; i++) {
            lbs[i] = new JLabel(lbs_strs[i]); // 레이블 선언
            lbs[i].setFont(new Font("카페24 써라운드 에어 ", Font.BOLD, 12));

            sml_pns[i] = new JPanel();
            sml_pns[i].setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 0)); // FlowLayout을 이용하여 가로로 배치
            sml_pns[i].setBackground(Color.white);
            big_pns[4].add(sml_pns[i]);
        }

        for (int i = 0; i < tfs.length; i++) {
            tfs[i] = new JTextField(15);
            tfs[i].setPreferredSize(new Dimension(250, 25));
        }

        for (int i = 0; i < pfs.length; i++) {
            pfs[i] = new JPasswordField(15);
            pfs[i].setPreferredSize(new Dimension(250, 25));
        }
        sml_pns[0].add(lbs[0]);
        sml_pns[0].add(tfs[0]);

        sml_pns[1].add(lbs[1]);
        sml_pns[1].add(pfs[0]); // passwordField

        sml_pns[2].add(lbs[2]);
        sml_pns[2].add(pfs[1]); // passwordField

        sml_pns[3].add(lbs[3]);
        sml_pns[3].add(tfs[1]);

        sml_pns[4].add(lbs[4]);
        sml_pns[4].add(tfs[2]);

        sml_pns[5].add(lbs[5]);
        sml_pns[5].add(tfs[3]);

        sml_pns[6].add(lbs[6]);
        sml_pns[6].add(tfs[4]);

        for (int i = 0; i < sml_pns.length; i++) {		// 아이콘 라벨(o, x 추가)
            JLabel iconLabel = new JLabel(scaledIcon);
            sml_pns[i].add(iconLabel);
        }

        big_pns[4].add(ac_btn_pns);
        ac_btn_pns.setBackground(Color.white);
        ac_btn_pns.setLayout(new FlowLayout(FlowLayout.CENTER));
        ac_btn_pns.add(btns[0]); // 취소 버튼
        ac_btn_pns.add(btns[1]); // 가입하기 버튼
        
        btns[0].setBackground(blue);
        btns[0].setForeground(Color.white);
        btns[0].setFocusPainted(false);

        btns[1].setBackground(blue);
        btns[1].setForeground(Color.white);
        btns[1].setFocusPainted(false);

        for (int i = 0; i < pfs.length; i++) {
            pfs[i].getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateIcon();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateIcon();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateIcon();
                }
            });
        }

        for (int i = 0; i < tfs.length; i++) {
            tfs[i].getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateIcon();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateIcon();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateIcon();
                }
            });
        }

    }

    private void start() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        for (int i = 0; i < btns.length; i++) {
            btns[i].addActionListener(this); // 버튼 이벤트 추가
        }
    }

    private void setIcon(String imagePath, int panelIndex) {
        ImageIcon newIcon = new ImageIcon(imagePath);
        Image image = newIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel iconLabel = (JLabel) sml_pns[panelIndex].getComponent(2); // 2번째 컴포넌트는 아이콘 레이블
        iconLabel.setIcon(scaledIcon); // 이미지 아이콘 변경
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btns[0]) {
            String tfId = tfs[0].getText();
            char[] tfPw = pfs[0].getPassword();
            String strPw = new String(tfPw);

            char[] tfPwR = pfs[1].getPassword();
            String strPwR = new String(tfPwR);

            String tfName = tfs[1].getText();
            String tfBirth = tfs[2].getText();
            String tfTell = tfs[3].getText();
            String tfMail = tfs[4].getText();

            updateIcon();

            if (tfId.length() < 6) {
                JOptionPane.showMessageDialog(this, "ID는 최소 6자 이상으로 입력해주세요", "경고", JOptionPane.CANCEL_OPTION);
                return;
            }
            else if (strPw.length() < 6) {
                JOptionPane.showMessageDialog(this, "비밀번호는 최소 8자 이상으로 입력해주세요", "경고", JOptionPane.CANCEL_OPTION);
                return;
            }
            else if (!strPwR.equals(strPw)) {
                JOptionPane.showMessageDialog(this, "비밀번호를 똑같이 입력해주세요", "경고", JOptionPane.CANCEL_OPTION);
                return;
            }
            else if (tfName.length() < 2) {
                JOptionPane.showMessageDialog(this, "이름은 최소 2자 이상으로 입력해주세요", "경고", JOptionPane.CANCEL_OPTION);
                return;
            }
            else if (tfBirth.length() < 6) {
                JOptionPane.showMessageDialog(this, "생년월일 입력은 6자로 입력해주세요(ex: YYMMDD)", "경고", JOptionPane.CANCEL_OPTION);
                return;
            }
            else if (tfTell.length() < 6) {
                JOptionPane.showMessageDialog(this, "전화번호 입력", "전화번호는 최소 6자 이상 입력해주세요", JOptionPane.CANCEL_OPTION);
                return;
            }
            else if (tfMail.length() < 10 || !tfMail.contains("@") || !tfMail.contains(".com")) {
                JOptionPane.showMessageDialog(this, "유효한 이메일 주소가 아닙니다", "경고", JOptionPane.CANCEL_OPTION);
                return;
            }

            MemberDTO Mbdto = new MemberDTO();
            Mbdto.setUserId(tfId);
            Mbdto.setUserPw(strPw);
            Mbdto.setUserName(tfName);
            Mbdto.setUserBirth(tfBirth);
            Mbdto.setUserTell(tfTell);
            Mbdto.setUserMail(tfMail);

            String result = mpip.CreateAccount(Mbdto);
            if(result.equals("저장 성공")) result = "가입 완료";
			JOptionPane.showMessageDialog(this, result);
			dispose();
        }else if(e.getSource()==btns[1]) {
        	dispose();
        }
    }


	private void updateIcon() {
        String tfId = tfs[0].getText();
        String tfPw = new String(pfs[0].getPassword());
        String tfPwR = new String(pfs[1].getPassword());
        String tfName = tfs[1].getText();
        String tfBirth = tfs[2].getText();
        String tfTell = tfs[3].getText();
        String tfMail = tfs[4].getText();

        setIcon(tfId.trim().length() >= 6 ? "img/yes.png" : "img/no.png", 0);
        setIcon(tfPw.trim().length() >= 8 ? "img/yes.png" : "img/no.png", 1);
        setIcon(tfPwR.trim().length() >= 1 && tfPw.equals(tfPwR) ? "img/yes.png" : "img/no.png", 2); 
        setIcon(tfName.trim().length() >= 2 ? "img/yes.png" : "img/no.png", 3);     
        setIcon(tfBirth.trim().length() == 6 ? "img/yes.png" : "img/no.png", 4);  
        setIcon(tfTell.trim().length() >= 6 ? "img/yes.png" : "img/no.png", 5);
        setIcon(tfMail.trim().length() >= 10 && tfMail.contains("@") && tfMail.contains(".com") ? "img/yes.png" : "img/no.png", 6);
    }
}

public class CreateAccountFrame {
    public static void main(String[] args) {
        new CA();
    }
}
