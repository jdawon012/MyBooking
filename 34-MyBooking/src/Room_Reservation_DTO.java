public class Room_Reservation_DTO {

	// 머가 필요하지?
	private int roomNum; // 방번호
	private String roomName; // 방 이름
	private String roomInfor; // 방 정보
	private int roomPrice; // 방 가격
	private int roomChack; // 공실 체크
	private String roomWhen; // 예약 날짜
	private String roomImage; // 방 이미지
	private String roomBigImage; // 큰 방 이미지
	private String userId; // 예약자 아이디?
	private String placeName; // 숙소 이름
	private String placeTell;	//숙소 번호
	private String userName;	//사용자 이름
	private String placeAdd;	//숙소 주소
	

	public Room_Reservation_DTO() {

	}

	@Override
	public String toString() {
		String str = "";
		str =  "선택한 방 정보 \n" 
				+"방 이름=" + roomName 
				+ "\n 방 정보=" + roomInfor 
				+ "\n 방 가격 =" + roomPrice + ", 예약 날짜 =" + roomWhen + 
				"\n 예약자 아이디 =" + userId + ", 숙소 이름 =" + placeName;
		return str;
	}
	// 방 정보
	public String toRoom() {
		String str = "";
		
		str = "방 이름 : " +roomName + 
				"\n  " + roomInfor +
				"\n" + 
				"\n 숙소 이름 : "+ placeName + 
				"\n 주소 : " +placeAdd +
				"\n Tell : " + placeTell;
		
		return str;
	}
	
	// 예약자 정보
	public String toUser() {
		String str = "";
		str = 	"\n"+
				" 예약 날짜 : " + roomWhen +
				"\n 아이디 : " + userId +
				"\n " + userName + " 님";  
		
		return str;
	}
	
	// 방 가격
	public String toPrice() {
		String str = "";
		
		str = roomPrice + "원";
		
		return str;
	}
	// 큰 방 이미지
	public String toRoomBigImage() {
		String str = "";
		
		str = "img/"+roomBigImage;
		
		return str;
		
	}
	
	
	

	// getter && setter
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

	public int getRoomChack() {
		return roomChack;
	}

	public void setRoomChack(int roomChack) {
		this.roomChack = roomChack;
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


	public String getRoomInfor() {
		return roomInfor;
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

	public String getPlaceTell() {
		return placeTell;
	}

	public void setPlaceTell(String placeTell) {
		this.placeTell = placeTell;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPlaceAdd() {
		return placeAdd;
	}

	public void setPlaceAdd(String placeAdd) {
		this.placeAdd = placeAdd;
	}

	
}
