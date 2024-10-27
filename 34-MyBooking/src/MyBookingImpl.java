import java.util.List;

public class MyBookingImpl implements MyBooking {
	MemberDAO mdao = new MemberDAO();
	Find_ID_PW_DAO fdao = new Find_ID_PW_DAO();
	RoomDAO rdao = new RoomDAO();	
	RoomSelect_DAO rsdao = new RoomSelect_DAO();
	UserRoomListDAO urdao = new UserRoomListDAO();
	MainPlaceDAO mpdao = new MainPlaceDAO();
	
	saveDTO svdto = new saveDTO();  
			
	// 회원가입을 통한 insert
	public String CreateAccount(MemberDTO Mbdto) {
        List<MemberDTO> list = mdao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            MemberDTO memberDTO = list.get(i);
            if (memberDTO.getUserId().equals(Mbdto.getUserId())) {
                return Mbdto.getUserId() + " 학번이 이미 존재하고 있습니다.";
            }
        }

        int result = mdao.createAccountArticle(Mbdto);

        if (result > 0)
            return "저장 성공";
        else
            return "저장 실패";
    }
	
	// Manager_reservation창
    // 
    public String selectAllRoom() {
        List<RoomDTO> list = rdao.RoomList();
        String result = String.format("%s\t %s\t %s\t %s\t %s\t\t %s\t %s\n\n",
                "방 번호", "방 이름", "공실", "유저 아이디", "예약일", "가격", "숙소명");
        for (int i = 0; i < list.size(); i++) {
            RoomDTO Rmdto = list.get(i);
            result += Rmdto.toString() + "\n";
        }
        return result;
    }

    public int updateRoomCheck(int roomCheck, int roomNum) {
        return rdao.UpdateRoomCheck(roomCheck, roomNum);
    }
    
	@Override
	public void login() {
		
		
	}

	@Override
	public void managerLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void join() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void idFind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pwFind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String find_Id(String name, String tell) {
		Find_ID_PW_DTO dto = new Find_ID_PW_DTO();
		String result_id = "";
		
		dto.setUserName(name);
		dto.setUserTell(tell);
		
		result_id = fdao.find_id(dto);
		
		//frame 로 넘어감
		return result_id;
	}

	@Override
	public String find_Pw(String id, String name, String tell) {
		Find_ID_PW_DTO dto = new Find_ID_PW_DTO();
		String result_pw = "";
		
		dto.setUserId(id);
		dto.setUserName(name);
		dto.setUserTell(tell);
		
		result_pw = fdao.find_pw(dto);
		
		//frame 로 넘어감
		return result_pw;
	}

	// 선택한 숙소? 정보 가져오기
	// 숙소 이름 가져오기? 이게 맞냐 함수로 가져오는게 몰라 해바걍
	// 어캐해야 할지 모르겠음 화면 붙이면서 생각
	@Override
	public String getPlaceName() {

		/** dto.getPlaceName(); **/ // 이걸로 받아와야 될꺼같음
		
		
		String str = svdto.getSavePlaceName();

		return str;
	}

	// 숙소 주소
	@Override
	public String getPlaceAdd() {

		// 선택한 숙소 이름 임시
		//String placeName = "여수 라마다 프라자 호텔";
		String placeName = svdto.getSavePlaceName();
		String str = "";

		RoomSelect_DAO dao = new RoomSelect_DAO();

		str = dao.getPlaceAdd(placeName);

		// frame으로 넘어감
		return str;

	}

	// 방 정보 가져오기
	// 선택한 숙소 값을 가져와야댐
	@Override
	public String getRoomInfor(int i) {
		// 선택한 숙소 이름 임시
				//String placeName = "여수 라마다 프라자 호텔";
				String placeName = svdto.getSavePlaceName();
				String str = "";

				List<RoomSelect_DTO> list = rsdao.getRoomInfor(placeName);

				if (i < list.size()) {
					RoomSelect_DTO dto = list.get(i);
					str = dto.toRoom();
				} else {
					str = "";
				}

				// frame으로 넘어감
				return str;

	}

	// 객실 예약 버튼 클릭시 해당하는 방의 번호를 넘김
	@Override
	public int roomReservation_bt(int i) {

		// 선택한 숙소 이름 임시
		//String placeName = "여수 라마다 프라자 호텔";
		String placeName = svdto.getSavePlaceName();
		int str = 0;

		List<RoomSelect_DTO> list = rsdao.getRoomInfor(placeName);

		if (i < list.size()) {
			RoomSelect_DTO dto = list.get(i);
			str = dto.toRoomNum();
		}

		// frame으로 넘어감
		return str;

	}

	// 방 가격 가져오기

	@Override
	public String getRoomPrice(int i) {

		// 선택한 숙소 이름 임시
		//String placeName = "여수 라마다 프라자 호텔";
		String placeName = svdto.getSavePlaceName();
		String str = "";

		List<RoomSelect_DTO> list = rsdao.getRoomInfor(placeName);

		if (i < list.size()) {
			RoomSelect_DTO dto = list.get(i);
			str = dto.toRoomPrice();
		} else {
			str = "";
		}

		// frame으로 넘어감
		return str;

	}

	// 숙소 이미지 가져오기
	// 선택한 숙소 값을 가져와야댐
	@Override
	public String placeImage() {
		String result = "";
		// 선택한 숙소 이름 임시
		//String placeName = "여수 라마다 프라자 호텔";
		String placeName = svdto.getSavePlaceName();
		RoomSelect_DAO dao = new RoomSelect_DAO();

		result = dao.getPlaceImage(placeName);

		// frame으로 돌아감
		return result;

	}

	// 방이미지 가져오기
	// 선택한 숙소 값을 가져와야댐

	@Override
	public String roomImage(int i) {

		// 선택한 숙소 이름 임시
		//String placeName = "여수 라마다 프라자 호텔";
		String placeName = svdto.getSavePlaceName();
		String str = "";

		List<RoomSelect_DTO> list = rsdao.getRoomInfor(placeName);

		if (i < list.size()) {
			RoomSelect_DTO dto = list.get(i);
			str = dto.toRoomImage();
		} else {
			str = "";
		}

		// frame으로 넘어감
		return str;

	}

	//방 정보 출력하기
		//frame에서 옴
		@Override
		public String output_room() {
			//임시로 1번방
			//int roomNum = 1;
			int roomNum = svdto.getSaveRoomNum();
			String result ="";
			Room_Reservation_DTO dto = new Room_Reservation_DTO();
			Room_Reservation_DAO dao = new Room_Reservation_DAO();
			
			result = dao.output_room(roomNum);
			
//			result = dto.toString();
			
			//frame으로 돌아감
			return result;
			
			
			
		}

		@Override
		public String output_user() {
			String result ="";
			//임시 유저 id
			//String userId = "user1";
			String userId = svdto.getSaveUserId();
			Room_Reservation_DAO dao = new Room_Reservation_DAO();
			
			result = dao.output_user(userId);
			
			return result;
			
		}
		
		@Override
		public String roomprice() {
			String result ;
			//임시 방 번호
			//int roomNum = 1;
			int roomNum = svdto.getSaveRoomNum();
			
			Room_Reservation_DAO dao = new Room_Reservation_DAO();
			
			result = dao.roomprice(roomNum);
			
			//frame으로 돌아감
			return result;
			
		}

		
		//예약 버튼
		@Override
		public int Reservation() {
			
			Room_Reservation_DAO dao = new Room_Reservation_DAO();
			
			//임시 사용자 아이디와  예약할 방 번호
			//String userId = "user2";
			String userId = svdto.getSaveUserId();
			//int roomNum = 1;
			int roomNum = svdto.getSaveRoomNum();
			// 정상작동시 1로 줄꺼임
			int result = 0;
			
			result = dao.bt_Reservation(userId,roomNum);
			
			//frame으로 돌아감
			return result;
			
			
			
		}

		@Override
		public void cencle() {
			// TODO Auto-generated method stub
			
		}
		
		
		//예약 화면
		@Override
		public String getBigImage(int num) {
			String result ="";
			//임시 가져올 방 큰 이미지의 방 번호
			//int roomNum = 1;
			//int roomNum = svdto.getSaveRoomNum();
			
			Room_Reservation_DAO dao = new Room_Reservation_DAO();
			
			result = dao.getBigImage(num);
			
			System.out.println(num);
			System.out.println(result);
			
			//frame으로 돌아감
			return result;
			
		}

		// userId를 받아와야댐 쉽지아늠 getuserId인데 이거 그 머냐 멀까
		@Override
		public String getInfor(int i/** String userId **/
		) {
			// 테스트 용 임시 사용자 아이디
			//String userId = "user1";
			String userId = svdto.getSaveUserId();

			String str = "";
			List<UserRoomListDTO> list = urdao.getInfor(userId);

			if (i < list.size()) {
				UserRoomListDTO dto = list.get(i);
				str = dto.toRoom();
			} else {
				str = "";
			}

			return str;

		}
		
		//방 이미지 가져오기
		@Override
		public String getImage(int i) {
			// 테스트 용 임시 사용자 아이디
			//String userId = "user1";
			String userId = svdto.getSaveUserId();

			List<UserRoomListDTO> list = urdao.getInfor(userId);

			String str = "";
			if (i < list.size()) {
				UserRoomListDTO dto = list.get(i);
				str = dto.toImage();
				str = "img/" + str;
			}

			return str;

		}

		// 버튼 스위치?
		@Override
		public int bt_onoff(int i) {

			// 테스트 용 임시 사용자 아이디
			//String userId = "user1";
			String userId = svdto.getSaveUserId();

			List<UserRoomListDTO> list = urdao.getInfor(userId);
			int btox = 0;
			if (i < list.size()) {
				btox = 1;
			} else {
				btox = 0;
			}

			return btox;

		}

		
		
		//취소하깅
		@Override
		public int roomCencle(int i) {
			int result = 0;
			
			//int roomNum = 0;
			int roomNum = svdto.getSaveRoomNum();
			
			// 테스트 용 임시 사용자 아이디
			//String userId = "user1";
			String userId = svdto.getSaveUserId();
			
			List<UserRoomListDTO> list = urdao.getInfor(userId);
			
			
			UserRoomListDTO dto = list.get(i);
			
			//방 번호 가져오기	
			roomNum = dto.getRoomNum();
			//System.out.println(roomNum);
			//System.out.println(userId);
			//방 번호 랑 이름으로 취소하기
			result = urdao.cencle(userId, roomNum);
			
			//frame으로
			return result;
		}

		// 공실 체크 함수
		@Override
		public int Chack(int i) {

			//String placeName = "여수 라마다 프라자 호텔";
			String placeName = svdto.getSavePlaceName();
			int str;
			List<RoomSelect_DTO> list = rsdao.getRoomInfor(placeName);

			if (i < list.size()) {

				RoomSelect_DTO dto = list.get(i);
				str = dto.getRoomChack();

			} else {
				str = 0;
			}

			return str;
		}

		// frame에서 옴
		// 호텔 목록 가져오기 1-4
		@Override
		public String getHotelList(int i) {

			String str = "";

			List<MainPlaceDTO> list = mpdao.getHotelList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toPlace();
			} else {
				str = "";
			}
			return str;

		}

		// 모텔 목록 가져오기 1-4
		@Override
		public String getMotelList(int i) {
			String str = "";

			List<MainPlaceDTO> list = mpdao.getMotelList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toPlace();
			} else {
				str = "";
			}

			return str;
		}

		// 펜션 목록 가져오기 1-4
		@Override
		public String getPensenList(int i) {
			String str = "";

			List<MainPlaceDTO> list = mpdao.getPensenList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toPlace();
			} else {
				str = "";
			}

			return str;
		}

		// 호텔 이미지 가져오기
		@Override
		public String getHotelImage(int i) {
			String str = "";

			List<MainPlaceDTO> list = mpdao.getHotelList();
			System.out.println("");

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toImage();
			} else {
				str = "";
			}
			return str;
		}

		// 모텔 이미지 가져오기
		@Override
		public String getMotelImage(int i) {

			String str = "";

			List<MainPlaceDTO> list = mpdao.getMotelList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toImage();
			} else {
				str = "";
			}

			return str;
		}

		// 펜션 이미지 가져오기
		@Override
		public String getPensenImage(int i) {
			String str = "";

			List<MainPlaceDTO> list = mpdao.getPensenList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toImage();
			} else {
				str = "";
			}

			return str;
		}

		// 숙소 이름 저장용
		@Override
		public String getHotelName(int i) {

			String str = "";

			List<MainPlaceDTO> list = mpdao.getHotelList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toName();
			} else {
				str = "";
			}
			return str;

		}

		@Override
		public String getMotelName(int i) {

			String str = "";

			List<MainPlaceDTO> list = mpdao.getMotelList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toName();
			} else {
				str = "";
			}

			return str;

		}

		@Override
		public String getPensenName(int i) {

			String str = "";

			List<MainPlaceDTO> list = mpdao.getPensenList();

			if (i < list.size()) {
				MainPlaceDTO dto = list.get(i);
				str = dto.toName();
			} else {
				str = "";
			}

			return str;

		}

		
		
	
}
