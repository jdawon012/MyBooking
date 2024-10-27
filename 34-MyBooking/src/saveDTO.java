
public class saveDTO {

	private static String saveUserId;
	private static int saveRoomNum;
	private static String savePlaceName;
	private static String saveManegerId;

	public saveDTO() {

	}

	public saveDTO(String saveUserId, int saveRoomNum,String savePlaceName,String saveManegerId) {
		super();
		this.saveUserId = saveUserId;
		this.saveRoomNum = saveRoomNum;
		this.savePlaceName = savePlaceName;
		this.saveManegerId = saveManegerId;
	}

	public static String getSaveUserId() {
		return saveUserId;
	}

	public static void setSaveUserId(String saveUserId) {
		saveDTO.saveUserId = saveUserId;
	}

	public static int getSaveRoomNum() {
		return saveRoomNum;
	}

	public static void setSaveRoomNum(int saveRoomNum) {
		saveDTO.saveRoomNum = saveRoomNum;
	}

	public static String getSavePlaceName() {
		return savePlaceName;
	}

	public static void setSavePlaceName(String savePlaceName) {
		saveDTO.savePlaceName = savePlaceName;
	}

	public static String getSaveManegerId() {
		return saveManegerId;
	}

	public static void setSaveManegerId(String saveManegerId) {
		saveDTO.saveManegerId = saveManegerId;
	}
	
	

}
