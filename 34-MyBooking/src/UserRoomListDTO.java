public class UserRoomListDTO {
	private int roomNum; // 방 고유번호
	private String roomName; // 방 이름
	private String roomPrice; // 방 가격
	private String roomWhen; // 예약 날짜
	private String roomImage; // 예약 날짜
	private String placeName; // 숙소 이름
	private String placeAdd; // 숙소 주소
	private String placeTell; // 숙소 전화번호
	private String userId; // 사용자 id
	private String roomInfor; // 방 고유번호

	public void UserRoomListDTO() {

	}

	public UserRoomListDTO(String roomName, String roomPrice, String roomWhen, String roomImage, String userId,
			String placeName, String roomInfor, String placeAdd, String placeTell, int roomNum) {
		super();
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomWhen = roomWhen;
		this.roomImage = roomImage;
		this.placeName = placeName;
		this.roomInfor = roomInfor;
		this.placeAdd = placeAdd;
		this.placeTell = placeTell;
		this.userId = userId;
		this.roomNum = roomNum;

	}

	@Override
	public String toString() {
		return "UserRoomListDTO [roomName=" + roomName + ", roomPrice=" + roomPrice + ", roomWhen=" + roomWhen
				+ ", placeName=" + placeName + ", placeAdd=" + placeAdd + ", placeTell=" + placeTell + ", userId="
				+ userId + "]";
	}

	public String toRoom() {
		String str = " 방 이름: " + roomName + "\n 가격: " + roomPrice + "\n 예약 날짜: " + roomWhen + "\n"
				+ "\n 숙소 이름: " + placeName + "\n 주소: " + placeAdd + "\n Tell: " + placeTell;

		return str;

	}

	public String toImage() {
		String str = roomImage;

		return str;

	}

	// getter & setter
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomWhen() {
		return roomWhen;
	}

	public void setRoomWhen(String roomWhen) {
		this.roomWhen = roomWhen;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceAdd() {
		return placeAdd;
	}

	public void setPlaceAdd(String placeAdd) {
		this.placeAdd = placeAdd;
	}

	public String getPlaceTell() {
		return placeTell;
	}

	public void setPlaceTell(String placeTell) {
		this.placeTell = placeTell;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	public String getRoomInfor() {
		return roomInfor;
	}

	public void setRoomInfor(String roomInfor) {
		this.roomInfor = roomInfor;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

}
