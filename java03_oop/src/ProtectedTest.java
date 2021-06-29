
public class ProtectedTest {
	protected int num=1234;
	String name = "세종대왕";
	protected ProtectedTest(){
		System.out.println("같은패키지의 생성자메소드");
		
	}
	protected void print() {
		System.out.println("이름="+ name);
	}
}