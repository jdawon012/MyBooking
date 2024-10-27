
public class Maneger_WinDTO {
	private int roomNum; // 방 고유번호
	private String roomName; // 방 이름
	private String roomWhen; // 예약 날짜
	private String roomImg; // 방 이미지
	private String placeName; // 숙소 이름
	private String userId; // 사용자 id
	private String manegerId;
	private int roomChack; // 체크
	
	public Maneger_WinDTO() {}

	public Maneger_WinDTO(int roomNum, String roomName, String roomWhen, String roomImg, String placeName, String userId,
			String manegerId, int roomChack) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomWhen = roomWhen;
		this.roomImg = roomImg;
		this.placeName = placeName;
		this.userId = userId;
		this.manegerId = manegerId;
		this.roomChack = roomChack;
	}

	public String toRoom() {
		String str = " 방 이름 : " + roomName +  "\n 예약 날짜 : " + roomWhen + "\n" + "\n"
				+ "\n 숙소 이름 : " + placeName + "\n";

		return str;

	}

	public String toImg() {
		String str = "img/" + roomImg;

		return str;
	}

	// getter & setter
	public int getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public String getRoomWhen() {
		return roomWhen;
	}


	public void setRoomWhen(String roomWhen) {
		this.roomWhen = roomWhen;
	}


	public String getRoomImg() {
		return roomImg;
	}


	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}


	public String getPlaceName() {
		return placeName;
	}


	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getManegerId() {
		return manegerId;
	}


	public void setManegerId(String manegerId) {
		this.manegerId = manegerId;
	}


	public int getRoomCheck() {
		return roomChack;
	}


	public void setRoomCheck(int roomCheck) {
		this.roomChack = roomCheck;
	}
}

	