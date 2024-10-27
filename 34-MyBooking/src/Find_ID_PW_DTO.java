public class Find_ID_PW_DTO {

	private String userId;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userTell;
	private String userMail;
	
	
	public Find_ID_PW_DTO(){
		
	}

	public Find_ID_PW_DTO(String userId, String userPw, String userName, String userBirth, String userTell,
			String userMail) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userTell = userTell;
		this.userMail = userMail;
	}

	@Override
	public String toString() {
		return "Find_ID_PW_DTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userBirth="
				+ userBirth + ", userTell=" + userTell + ", userMail=" + userMail + "]";
	}

	
	
	
	// getter & setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserTell() {
		return userTell;
	}

	public void setUserTell(String userTell) {
		this.userTell = userTell;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

}
