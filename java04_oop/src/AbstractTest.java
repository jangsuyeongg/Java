// 추상메소드를 1개이상 포함하는 클래스는 추상클래스이다. 
// 추상클래스는 class키워드왼쪽에 Abstract를 표기하여야 한다.
// 추상클래스는 반드시 상속받아 모든 추상메소드를 오버라이딩 하여야 한다. 
// 미완성된 클래스라고 한다.
public abstract class AbstractTest {
	int num = 100;
	String name = "홍길동";
	public AbstractTest() {
		
	}
	public void numOutput() {
		System.out.println("num="+num);
	}
	//실행부가 없는 메소드는 추상메소드이다.
	//추상메소드는 반환형 왼쪽에  abstract키워드를 표기하여야 한다.
	public abstract void print();
	public abstract void setData(int num, String name);

}