
public class MethodTest2Main {

	public MethodTest2Main() {
		
	}

	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2();
		
		String gugu = mt.gugudan(8);//메소드 호출
		System.out.println(gugu);
		
		
		//반환형이 없는 메소드 호출
		mt.powerStart();
		
		//
		mt.channelUp();
		mt.channelUp();
		mt.channelDown();
		//static없는 메소드는 반드시 객체를 만들어 메소드를 호출해야 한다.
		mt.sum(20);
		//static이 메소드의 반환형 왼쪽에 잇는 경우는 메소드를 객체생성하지 않고 호출할 수 있다.
		// 클래스명.메소드명(매개변수)
		
		MethodTest2.sum(50);
		
	}

}