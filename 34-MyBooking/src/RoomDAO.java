import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
	public RoomDAO() {
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
	
	 // 모든 룸 정보 불러오기 
    public List<RoomDTO> RoomList(){
    	String sql = "select * from Room";
        List<RoomDTO> list = new ArrayList<RoomDTO>();
        
        Connection conn = getConnection();
        PreparedStatement pmt = null;
        ResultSet rs = null;
        
        try {
            pmt = conn.prepareStatement(sql);
            rs = pmt.executeQuery();
            
            while(rs.next()) {
                RoomDTO Rmdto = new RoomDTO();
                Rmdto.setRoomNum(rs.getInt("roomNum"));
                Rmdto.setRoomName(rs.getString("roomName"));
                Rmdto.setRoomCheck(rs.getInt("roomCheck"));
                Rmdto.setUserId(rs.getString("userId"));
                Rmdto.setRoomWhen(rs.getString("roomWhen"));
                Rmdto.setRoomPrice(rs.getInt("roomPrice"));
                Rmdto.setPlaceName(rs.getString("placeName"));
               
                list.add(Rmdto);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) rs.close();
                if(pmt!=null) pmt.close();
                if(conn!=null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    
    public RoomDTO SelectRoomCheck(int roomNum) {
        String sql = "SELECT roomCheck FROM Room WHERE roomNum = ?";
        RoomDTO Rmdto = null;

        Connection conn = getConnection();
        PreparedStatement pmt = null;
        ResultSet rs = null;

        try {
            pmt = conn.prepareStatement(sql);
            pmt.setInt(1, roomNum);
            rs = pmt.executeQuery();

            if (rs.next()) {
                Rmdto = new RoomDTO();
                Rmdto.setRoomCheck(rs.getInt("roomCheck"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pmt != null) pmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return Rmdto;
    }

    
    public int UpdateRoomCheck(int roomCheck, int roomNum) {
        String sql = "UPDATE Room SET roomCheck = ? WHERE roomNum = ?";
        int result = 0;

        // 접속
        Connection conn = getConnection();
        PreparedStatement pmt = null;

        try {
            pmt = conn.prepareStatement(sql);
            pmt.setInt(1, roomCheck);
            pmt.setInt(2, roomNum);

            result = pmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            // 접속 끊기
            try {
                if(pmt != null) pmt.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    
}