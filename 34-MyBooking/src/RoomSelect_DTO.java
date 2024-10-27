public class RoomSelect_DTO {

	public int roomNum; // 방 고유 번호
	public String roomName; // 방 이름
	public String roomPrice; // 방 가격
	public int roomChack; // 방 공실체크
	public String roomImage; // 방 이미지
	public String roomInfor; // 방 정보

	public String placeName; // 장소 이름
	public String placeAdd; // 장소 주소
	public String placeBigImage; // 장소 큰 이미지

	public RoomSelect_DTO() {

	}

	public RoomSelect_DTO(int roomNum, String roomName, String roomPrice,int roomChack, String roomImage, String roomInfor,
			String placeName, String placeAdd, String placeImage) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomImage = roomImage;
		this.roomInfor = roomInfor;
		this.placeName = placeName;
		this.placeAdd = placeAdd;
		this.placeBigImage = placeImage;
		this.roomChack = roomChack;
	}

	@Override
	public String toString() {
		return "RoomSelect_DTO [roomNum=" + roomNum + ", roomName=" + roomName + ", roomPrice=" + roomPrice
				+ ", roomImage=" + roomImage + ", roomInfor=" + roomInfor + ", placeName=" + placeName + ", placeAdd="
				+ placeAdd + ", placeImage=" + placeBigImage + "]";
	}

	
	
	// 방 정보 가져오깅
	public String toRoom() {
		String str = "";
		str = " "+ roomName +
			 "\n " + roomInfor +
			 "\n " +
			 "\n 입실 15:00" +
			 "\n 퇴실 11:00";
		
		return str;
		
	}
	
	//방 가격
	public String toRoomPrice() {
		
		String str = "";
		
		str = roomPrice + " 원";
		return str;
		
	}
	
	// 숙소 주소
	public String toPlaceAdd() {
		
		String str = ""; 
		str = placeAdd;
		return str;
	}
	
	
	// 방 이미지
	public String toRoomImage() {
		
		String str = ""; 
		str = "img/" + roomImage;
		
		return str;
	}
	
	
	//장소 이미지 
	public String toPlaceBigImage() {
		
		String str = ""; 
		str = "img/" + placeBigImage;
		
		return str;
		
	}
	
	public int toRoomNum() {
		
		int str = roomNum;
		
		return str;
	}
	
	
	//getter & setter
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

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
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

	public int getRoomChack() {
		return roomChack;
	}

	public void setRoomChack(int roomChack) {
		this.roomChack = roomChack;
	}

	public String getPlaceBigImage() {
		return placeBigImage;
	}

	public void setPlaceBigImage(String placeBigImage) {
		this.placeBigImage = placeBigImage;
	}

	public void setRoomInfor(String roomInfor) {
		this.roomInfor = roomInfor;
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

}
