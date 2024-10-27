
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Maneger_WinDAO {

	// 1. 드라이버 확인
	public Maneger_WinDAO() {
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

	// sql 만들깅
	// 예약한 방정보 같은거 가져오기

	public List<Maneger_WinDTO> getInforM(String manegerId) {
		
		String sql = "select room.roomImage, room.roomName, maneger.placeName, room.roomWhen, room.roomNum, room.userId, room.roomChack from room INNER JOIN maneger ON room.placename = maneger.placename where maneger.manegerId = ? and room.roomChack = 1";

		List<Maneger_WinDTO> list = new ArrayList<Maneger_WinDTO>();

		// 1)접속
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manegerId);
			rs = pstmt.executeQuery();

			// 얘는 여러개를 불러와야 되니깐 while
			while (rs.next()) {

				String roomName = rs.getString("roomName"); // 방 이름
				String roomWhen = rs.getString("roomWhen"); // 날짜
				String roomImage = rs.getString("roomImage"); // 방 사진
				int roomNum = rs.getInt("roomNum"); // 방 번호
				String placeName = rs.getString("placeName"); // 장소 이름
				String userId = rs.getString("userId");
				int roomChack = rs.getInt("roomChack"); // 방 체크

				Maneger_WinDTO dto = new Maneger_WinDTO(roomNum, roomName, roomWhen, roomImage, placeName, userId, manegerId, roomChack);
				list.add(dto);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			try { // 3) db 접속
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	public int check(int roomNum) {
		String sql = "update Room set roomChack = 2 where roomNum = ?";
		int result = 0;

		Connection conn = getConnection();
		PreparedStatement ptmt = null;

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, roomNum);

			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 취소하기

	public int cancel(/*String manegerId, */int roomNum) {
		String sql = "update room set roomChack = 0 ,userId = 'userNull'where roomNum = ?";
		//String sql = "update room set roomCheck = 0 where manegerId = ? and roomNum = ?";
		int result = 0;

		Connection conn = getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			//pstmt.setString(1, manegerId);
			pstmt.setInt(1, roomNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
		
	}
	
	
	 
	 
	// 방의 데이터가 있는지 여부를 확인하는 메서드
	public boolean hasData() {
	    try (Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM Room WHERE manegerId = 'qwer' and roomcheck != 1")) {
	        ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        return count > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
