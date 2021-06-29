//메소드 안에 내부클래스만들기
public class MethodInner {
	String name="세종대왕";
	public MethodInner() {
		System.out.println("MethodInner");
	}
	public void start() {
		//내부클래스
		class MethodInnerTest{
			int num=20;
			String email = "aaaa@nate.com";
			MethodInnerTest(){
				
			}
			MethodInnerTest(int num){
				this.num = num;
			}
			void emailOutput() {
				System.out.println("num="+num);
				System.out.println("email="+email);
				System.out.println("name="+name);
			}
		}
		
		// 내부클래스 객체를 생성
		MethodInnerTest mt = new MethodInnerTest(500);
		mt.emailOutput();
	}
	public static void main(String[] args) {
		MethodInner mi = new MethodInner();
		mi.start();

	}
}
