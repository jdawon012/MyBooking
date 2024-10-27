
public interface MyBooking {
	public void login();
	public void managerLogin();
	public void join();
	public void idFind();
	public void pwFind();
	public String find_Id(String name, String tell);				//아이디 찾기
	public String find_Pw(String id, String name, String tell);	//비밀번호 찾기
	
	public String getPlaceName();		//호텔 이름 가져오기
	public String getPlaceAdd();		//호텔 정보 가져오기
	public String getRoomInfor(int i);			//방 정보 가져오기
	public String getRoomPrice(int i);		//방 가격 가저오기
	public String placeImage();			// 장소 이미지 가져오기ㅏ
	public String roomImage(int i);		//방 이미지 가져오기
	public int roomReservation_bt(int i); 	//객실 예약 버튼 클릭시 방 고유 번호 넘김
	public int Chack(int i);		//방 체크
	
	public String output_room();	//방정보 가져오기??
	public String output_user();		//예약자 정보 가져오기??
	public String roomprice();
	public int Reservation();		//예약 버튼 클릭시
	public void cencle();			//취소버튼?
	public String getBigImage(int i);
	
	public String getInfor(int i);		//정보 가져오기? sql한번에 할듯
	public String getImage(int i);		//이미지 가져오깅
	public int bt_onoff(int i);		//리스트 있으면 버튼 보이게 안보이게
	public int roomCencle(int i);
	
	public String getHotelList(int i);		//호텔 목록 받아오기	받아올것 : 이미지, 이름, 주소
	public String getMotelList(int i);		//호텔 목록 받아오기	받아올것 : 이미지, 이름, 주소
	public String getPensenList(int i);		//호텔 목록 받아오기	받아올것 : 이미지, 이름, 주소
	
	public String getHotelImage(int i);		// 이미지 가져오기
	public String getMotelImage(int i);
	public String getPensenImage(int i);
	
	public String getHotelName(int i);			// 선택한 숙소 이름 저장해서 넘기기
	public String getMotelName(int i);
	public String getPensenName(int i);
	
	
	

}
