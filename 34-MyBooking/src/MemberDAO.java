import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 접속 성공 : Connection 객체, 접속 실패 : null
		return conn;
	}
	
	//유저 로그인
	public int ulogin(String UserId, String UserPw) {
		String sql = "select UserPw from Member where UserId = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, UserId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(UserPw)) return 1; //로그인 성공
				else return 0; //비밀번호 틀림
			}
			return -1; //아이디 틀림
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -2; //데이터베이스 오류
	}
	
	// 회원 가입
    public int createAccountArticle(MemberDTO Mbdto) {
        String sql = "INSERT INTO Member(userId, userPw, userName, userBirth, userTell, userMail) VALUES (?, ?, ?, ?, ?, ?)";
        int result = 0;
        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Mbdto.getUserId());
            pstmt.setString(2, Mbdto.getUserPw());
            pstmt.setString(3, Mbdto.getUserName());
            pstmt.setString(4, Mbdto.getUserBirth());
            pstmt.setString(5, Mbdto.getUserTell());
            pstmt.setString(6, Mbdto.getUserMail());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
	
    public List<MemberDTO> selectAll() {
        String sql = "select * from Member";
        List<MemberDTO> list = new ArrayList<>();

        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberDTO Mbdto = new MemberDTO();
                Mbdto.setUserId(rs.getString("userId"));
                Mbdto.setUserPw(rs.getString("userPw"));
                Mbdto.setUserName(rs.getString("userName"));
                Mbdto.setUserBirth(rs.getString("userBirth"));
                Mbdto.setUserTell(rs.getString("userTell"));
                Mbdto.setUserMail(rs.getString("userMail"));
                // 리스트에 저장
                list.add(Mbdto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
