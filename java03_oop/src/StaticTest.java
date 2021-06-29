
public class StaticTest {
	int num=1234;
	String name="홍길동";
	//현재클래스의 모든 객체에서 1개만 존재한다.(공동변수로 사용)
	static String addr="마포구";
	public StaticTest() {
		
	}
	//주소를 변경하는 메소드
	void setAddr(String addr) {
		this.addr = addr;
	}
	String getAddr() {
		return addr;
	}
}