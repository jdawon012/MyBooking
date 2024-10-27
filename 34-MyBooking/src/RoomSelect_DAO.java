

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomSelect_DAO {

	// 1. 드라이버 확인
	public RoomSelect_DAO() {
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

	// sql 부분
	// 숙소 주소 가져오기
	public String getPlaceAdd(String placeName) {
		
		String sql = "select placeAdd from place where placeName = ? ";
		String result = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeName);
			rs = pstmt.executeQuery();

			// 장소 이미지 단 하나
			if (rs.next()) {
				RoomSelect_DTO dto = new RoomSelect_DTO();
				dto.setPlaceAdd(rs.getString("placeAdd")); // 주소

				result = dto.toPlaceAdd();
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
		// Impl로 넘어감
		return result;

	}

	// 방 정보 가져오기 최대 3
	public List<RoomSelect_DTO> getRoomInfor(String placeName) {

		String sql = "select room.roomNum, room.roomName, room.roomPrice, room.roomChack, room.roomImage, room.roomInfor, place.placeName, place.placeAdd, place.placeImage "
				+ "from room inner join place on place.placename = room.placename where room.placeName = ? order by roomNum";
		String str = "";
		List<RoomSelect_DTO> list = new ArrayList<RoomSelect_DTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int roomNum = rs.getInt("roomNum");
				String roomName = rs.getString("roomName");
				String roomPrice = rs.getString("roomPrice");
				int roomChack = rs.getInt("roomChack");
				String roomImage = rs.getString("roomImage");
				String roomInfor = rs.getString("roomInfor");
				String s_placeName = rs.getString("placeName");
				String placeAdd = rs.getString("placeAdd");
				String placeImage = rs.getString("placeImage");

				RoomSelect_DTO dto = new RoomSelect_DTO(roomNum, roomName, roomPrice, roomChack, roomImage, roomInfor,
						s_placeName, placeAdd, placeImage);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 3) db 접속 끊기
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

	public String getPlaceImage(String placeName) {

		String sql = "select placeBigImage from place where placeName = ? ";
		String result = "";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeName);
			rs = pstmt.executeQuery();

			// 장소 이미지 단 하나
			if (rs.next()) {
				RoomSelect_DTO dto = new RoomSelect_DTO();
				dto.setPlaceBigImage(rs.getString("placeBigImage")); // 큰 이미지

				result = dto.toPlaceBigImage();
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
		// Impl로 넘어감
		return result;

	}
}

	// 방 이미지 가져오깅
//	public String getRoomImage(String placeName) {
//		String result = "";
//		return result;
//	}
//
//}
