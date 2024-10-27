import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainPlaceDAO {

	// 1. 드라이버 확인
	public MainPlaceDAO() {
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
	// 호텔 목록 가져와서 리스트에 하나씩 저장? 하기
	public List<MainPlaceDTO> getHotelList() {

		String sql = "select placeName, placeAdd,placeImage, placeStar from place where placetype = ? ";
		String str = "";
		List<MainPlaceDTO> list = new ArrayList<MainPlaceDTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "호텔");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String placeName = rs.getString("placeName");
				String placeAdd = rs.getString("placeAdd");
				String placeImage = rs.getString("placeImage");
				double placeStar = rs.getDouble("placeStar");

				MainPlaceDTO dto = new MainPlaceDTO(placeName, placeAdd, placeImage, placeStar);
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
		//impl로 감
		return list;

	}

	// 모텔 목록 가져와서 리스트에 하나씩 저장? 하기
	
	public List<MainPlaceDTO> getMotelList() {

		String sql = "select placeName, placeAdd,placeImage, placeStar from place where placetype = ? ";
		String str = "";
		List<MainPlaceDTO> list = new ArrayList<MainPlaceDTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "모텔");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String placeName = rs.getString("placeName");
				String placeAdd = rs.getString("placeAdd");
				String placeImage = rs.getString("placeImage");
				double placeStar = rs.getDouble("placeStar");

				MainPlaceDTO dto = new MainPlaceDTO(placeName, placeAdd, placeImage, placeStar);
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
		//impl로 감
		return list;

	}
	

	// 펜션 목록 가져와서 리스트에 하나씩 저장? 하기
	public List<MainPlaceDTO> getPensenList() {

		String sql = "select placeName, placeAdd,placeImage, placeStar from place where placetype = ? ";
		String str = "";
		List<MainPlaceDTO> list = new ArrayList<MainPlaceDTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "펜션");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String placeName = rs.getString("placeName");
				String placeAdd = rs.getString("placeAdd");
				String placeImage = rs.getString("placeImage");
				double placeStar = rs.getDouble("placeStar");

				MainPlaceDTO dto = new MainPlaceDTO(placeName, placeAdd, placeImage, placeStar);
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
		//impl로 감
		return list;

	}

}

