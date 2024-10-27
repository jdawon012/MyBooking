import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Find_ID_PW_DAO {

	
	
	// 1. 드라이버 확인
	public Find_ID_PW_DAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. 디비 접속
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
		// 접속 성공시 connection 객체 리턴, 접속 실패 : null 반환
		return conn;
		
	}
	
	
	// 3. sql 작업
	//아이디 비밀번호 찾기 작업
	
	public String find_id(Find_ID_PW_DTO dto) {
		String sql = "select userId from member where userName = ? and userTell = ? ";
		String result_id = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserTell());
			rs = pstmt.executeQuery();
			
			//전화번호는 고유니깐 한번만 할꺼임
			if(rs.next()) {
				
				dto.setUserId(rs.getString("userId"));
				result_id = dto.getUserId();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//impl로 돌아감
		return result_id;
		
	}
	
	
	public String find_pw(Find_ID_PW_DTO dto) {
		String sql = "select userPw from member where userId = ? and userName = ? and userTell = ? ";
		String result_pw = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getUserTell());
			rs = pstmt.executeQuery();
			
			//전화번호는 고유니깐 한번만 할꺼임
			if(rs.next()) {
				
				dto.setUserPw(rs.getString("userPw"));
				result_pw = dto.getUserPw();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//impl로 돌아감
		return result_pw;
		
	}
	
	
	
	
}
