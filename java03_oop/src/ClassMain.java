
public class ClassMain {

	public static void main(String[] args) {
		ClassTest ct = new ClassTest();
		//System.out.println("b=" + ct.b);
		
	 ClassTest ct2 = new ClassTest(5678);
	 
	 //메소드 호출 : 객체명.메소드명()
	 ct.sum();
	 ct.total(100, 200);
	 
	 ct2.total(1000,2000);
	 
	}
	//내부클래스 

}
