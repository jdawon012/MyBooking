import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoomListDAO {

	
	// 1. 드라이버 확인
		public UserRoomListDAO() {
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

		
		//sql 만들깅
		//예약한 방정보 같은거 가져오기
		public List<UserRoomListDTO> getInfor(String userId) {
			String sql = "select room.roomName, room.roomPrice, room.roomWhen, room.roomImage,"
					+ " room.userId, room.placeName, room.roomInfor, place.placeAdd, "
					+ "place.placeTell, room.roomNum from room inner join place on place.placename = room.placename where userId = ?";
			List<UserRoomListDTO> list = new ArrayList<UserRoomListDTO>();
			
			// 1)접속
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				// 얘는 여러개를 불러와야 되니깐 while
				while (rs.next()) {
					
						String roomName = rs.getString("roomName");
						String roomPrice = rs.getString("roomPrice");
						String roomWhen = rs.getString("roomWhen");
						String roomImage = rs.getString("roomImage");
						
						String placeName = rs.getString("placeName");
						String roomInfor = rs.getString("roomInfor");
						String placeAdd = rs.getString("placeAdd");
						String placeTell = rs.getString("placeTell");
						int roomNum = rs.getInt("roomNum");
					
					UserRoomListDTO dto = new UserRoomListDTO(roomName,roomPrice,roomWhen,roomImage,userId,placeName,roomInfor,placeAdd,placeTell,roomNum);
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
		
		// 2. 취소하기
		
		public int cencle(String userId, int roomNum) {
			
			
			String sql = "update room set userId = 'userNull', roomChack = 0 where userId = ? and roomNum = ?";
			int result = 0;
			
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, userId);
				pstmt.setInt(2, roomNum);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {

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
		
		
	
	
		

		
	
	
	
	
}
