//1. 인터페이스상속
public class RunnableTest implements Runnable{
	String msg;
	public RunnableTest() {
		
	}
	public RunnableTest(String msg) {
		this.msg=msg;
	}
	//스레드 구현영역을 run()메소드에 오버라이딩
	public void run() {
		int i = 1;
		while(true) {
			System.out.println(msg+"===>"+i++);
		}
	}
	
	public static void main(String[] args) {
		RunnableTest rt1 = new RunnableTest("첫번째스레드");
		RunnableTest rt2 = new RunnableTest("두번째스레드");
		
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		
		t1.start();
		t2.start();
		

	}

}
