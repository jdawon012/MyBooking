

import java.util.List;


public class Maneger_Win_Impl implements Maneger_Win_Interface {
	RoomDAO Rmdao = new RoomDAO();
	Maneger_WinDAO dao = new Maneger_WinDAO();
	
	saveDTO svdto = new saveDTO() ;

	// userId를 받아와야댐 쉽지아늠 getuserId인데 이거 그 머냐 멀까
	@Override
	public String getInfor(int i) {
		
		String result = "";
		// MyDTO Mdto = new MyDTO();
		// List<MyDTO> list = dao.getInforM(Mdto.getManegerId());
		String manegerId = svdto.getSaveManegerId();
		List<Maneger_WinDTO> list = dao.getInforM(manegerId);
		
		if (i < list.size()) {
			Maneger_WinDTO dto = list.get(i);
			result = dto.toRoom();
		} else {
			result = "";
		}
		return result;

	}
	
	//방 이미지 가져오기
	@Override
	public String getImg(int i) {
	    // 테스트 용 임시 사용자 아이디
	    // MyDTO Mdto = new MyDTO();
	    // List<MyDTO> list = dao.getInforM(Mdto.getManegerId());
		
		String manegerId = svdto.getSaveManegerId();

		List<Maneger_WinDTO> list = dao.getInforM(manegerId);


	    String str = "";
	    
	    if (i < list.size()) {
	        Maneger_WinDTO dto = list.get(i);
	        str = dto.toImg(); // 이미지 경로 직접 반환
	    }
	    
	    return str;
	}
		/*
		if (i < list.size()) {
			MyDTO dto = list.get(i);
			str += dto.toImg();
			
		}
		*/
		

	// 버튼 스위치?
	@Override
	public int bt_onoff(int i) {

		String manegerId = svdto.getSaveManegerId();

		List<Maneger_WinDTO> list = dao.getInforM(manegerId);
		int btox = 0;
		if (i < list.size()) {
			btox = 1;
		} else {
			btox = 0;
		}

		return btox;

	}
	
	@Override
	public int roomCheck(int i) {		// 누가 캔슬을 cancel이게 아니라 cencle로 쓰냐
		int result = 0;
		int roomNum = 0;
	
		String manegerId = svdto.getSaveManegerId();

		List<Maneger_WinDTO> list = dao.getInforM(manegerId);
		
		Maneger_WinDTO dto = list.get(i);
		//방 번호 가져오기	
		roomNum = dto.getRoomNum();
		
		//방 번호 랑 이름으로 체크하기
		result = dao.check(/*manegerId, */roomNum);
		
		//frame으로
		return result;
	}

	
	
	//취소하깅
	@Override
	public int roomCancel(int i) {		// 누가 캔슬을 cancel이게 아니라 cencle로 쓰냐
		int result = 0;
		int roomNum = 0;
	
		String manegerId = svdto.getSaveManegerId();

		List<Maneger_WinDTO> list = dao.getInforM(manegerId);
		
		Maneger_WinDTO dto = list.get(i);
		//방 번호 가져오기	
		roomNum = dto.getRoomNum();
		
		//방 번호 랑 이름으로 취소하기
		result = dao.cancel(/*manegerId, */roomNum);
		//frame으로
		return result;
	}

	
	

}
