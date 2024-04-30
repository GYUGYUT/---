package chat;
//이 클래스는 회원가입시 아이디 비밀번호 이름을 저장하는 클래스이다.
public class back {
	static String ID;
	static String PWD;
	static String NAME;
	static int port_p;
	
	public back(String ID,String PWD,String NAME) {
		back.ID = ID;
		back.PWD = PWD;
		back.NAME = NAME;
		back.port_p = 8888;
	}
	public static String ID_print() {
		return back.ID;
	}
	public static String PWD_print() {
		return back.PWD;
	}
	public static String NAME_print() {
		return back.NAME;
	}
	
	
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	*/

}
