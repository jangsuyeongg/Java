

public class Login {
	private final String USERID = "admin";
	private final String USERPWD = "1234";
	
	public Login() {// 관리자모드 고정 아이디, 비번
		// 사용자모드 아이디, 비번 설정은 BookManager에 설정해놓음!!! ㅠㅠ
		
	}
	// 로그인 체크 구현 (true:로그인성공, false:로그인실패)
	public boolean loginCheck(String userid, String userpwd) {
		if(userid.equals(USERID)&& userpwd.equals(USERPWD)){
			//로그인성공
			return true;
		}else {
			//로그인 실패
			return false;
		}
	}
	
}




