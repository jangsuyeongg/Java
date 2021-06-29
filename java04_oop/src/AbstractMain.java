
public class AbstractMain extends AbstractTest{

	public AbstractMain() {
	}

	//상속받은 추상클래스내의 모든 추상메소드를 오버라이딩한다. 
	public void print() {
		System.out.println("num="+num+", name="+name);
		
	}
	
	public void setData(int num, String name) {
		this.num = num;// super.num = num; 
		this.name = name;// super.name = name;
	}
	public void start() {
		numOutput();
		setData(5000,"이순신");
		print();
	}
	
	
	public static void main(String[] args) {
		AbstractMain am = new AbstractMain();
		am.start();
	}

}