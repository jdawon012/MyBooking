import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room_Reservation_DAO {

	// 1. 드라이버 확인
	public Room_Reservation_DAO() {
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

	// 방정보 가져오기??
	// 상단에 표시
	public String output_room(int roomNum) {

		String sql = "select room.roomName,room.roomInfor,place.placeName, place.placeadd,place.placetell from room inner join place on place.placename = room.placename where roomNum = ?";
		String result = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			// pstmt.setInt(1, dto.getRoomNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Room_Reservation_DTO dto = new Room_Reservation_DTO();
				dto.setRoomName(rs.getString("roomName")); // 방이름
				dto.setRoomInfor(rs.getString("roomInfor")); // 방 정보
				dto.setPlaceName(rs.getString("placeName")); // 숙소 이름
				dto.setPlaceAdd(rs.getString("placeAdd")); // 숙소 주소
				dto.setPlaceTell(rs.getString("placeTell")); // 숙소 전화번호

				result = dto.toRoom();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

		return result;

	}

	// 예약자 정보 가져오기??
	// 하단 표시 //userid 가저오는 방법을 생각해야댐 앞에서 넘어올때
	public String output_user(String userId) {

		String sql = "select room.roomWhen, member.userId, member.userName from Member inner join room on Member.userId = room.userId where member.userId = ?";
		String result = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			// pstmt.setInt(1, dto.getRoomNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Room_Reservation_DTO dto = new Room_Reservation_DTO();
				dto.setRoomWhen(rs.getString("roomWhen")); // 예약 날짜
				dto.setUserId(rs.getString("userId")); // 예약자 아이디
				dto.setUserName(rs.getString("userName")); // 예약자 이름

				result = dto.toUser();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

		return result;

	}

	// 방 가격 얻어오기
	// 이전 화면에서 선택한 방의 번호를 알아야댐
	public String roomprice(int roomNum) {

		String sql = "select roomPrice from room where roomNum = ?";
		String result = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			// pstmt.setInt(1, dto.getRoomNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Room_Reservation_DTO dto = new Room_Reservation_DTO();
				dto.setRoomPrice(rs.getInt("roomPrice")); // 예약 날짜

				result = dto.toPrice();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

		return result;
	}

	// 예약 버튼 클릭시
	public int bt_Reservation(String userId, int roomNum) {
		 
		String sql = "update room set userId = ?, roomChack = 1 where roomNum = ?";
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, roomNum);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// if(rs!=null)rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Impl에서 옴
		return result;

	}

	// 취소 버튼 클릭시?
	public void cencle() {

	}

	public String getBigImage(int roomNum) {

		String sql = "select roomBigImage from room where roomNum = ?";
		String result = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			// pstmt.setInt(1, dto.getRoomNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Room_Reservation_DTO dto = new Room_Reservation_DTO();
				dto.setRoomBigImage(rs.getString("roomBigImage")); // 큰 이미지 

				result = dto.toRoomBigImage();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// if(rs!=null)rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//Impl로 넘어감
		return result;
	}
	

}
