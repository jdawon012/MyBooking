
public class RoomDTO {
	private int roomNum;
	private String roomName;
	private int roomPrice;
	private int roomCheck;
	private String roomWhen;
	private String roomImage;
	private String roomBigImage;
	private String userId;
	private String placeName;
	private String roomInfor; // 방 고유번호
	
	public RoomDTO(){
		
	}

	@Override
	public String toString() {
		return "RoomDTO [roomNum=" + roomNum + ", roomName=" + roomName + ", roomPrice=" + roomPrice + ", roomCheck="
				+ roomCheck + ", roomWhen=" + roomWhen + ", roomImage=" + roomImage + ", roomBigImage=" + roomBigImage
				+ ", userId=" + userId + ", placeName=" + placeName + "]";
	}

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

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getRoomCheck() {
		return roomCheck;
	}

	public void setRoomCheck(int roomCheck) {
		this.roomCheck = roomCheck;
	}

	public String getRoomWhen() {
		return roomWhen;
	}

	public void setRoomWhen(String roomWhen) {
		this.roomWhen = roomWhen;
	}

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	public String getRoomBigImage() {
		return roomBigImage;
	}

	public void setRoomBigImage(String roomBigImage) {
		this.roomBigImage = roomBigImage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	
}
