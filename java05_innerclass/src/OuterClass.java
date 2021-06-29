// 객체로 내부클래스 호출
public class OuterClass {
	int num = 100;
	String name = "홍길동";
	public OuterClass() {
		System.out.println("OuterClass생성자 메소드 실행됨.");
	}
	public  void print() {
		System.out.println("num="+num);
		System.out.println("name="+name);
		//외부클래스에서 내부클래스의 멤버변수는 접근불가하다. 
		//System.out.println("tel="+ tel);
	}
	public void createInner() {
		//클래스내에서 내부클래스 객체 생성하기
		InnerClass cc = new InnerClass();
		cc.tel = "010-9999-9999";
		cc.output();
	}

	//내부클래스
	class InnerClass{
		//멤버변수
		String tel = "010-1234-5678";
		//생성자메소드
		InnerClass(){
			System.out.println("InnerClass생성자 메소드 실행됨");
		}
		//메소드
		public void output() {
			System.out.println("tel="+tel);
			//외부클래스의 멤버변수는 내부클래스에서 접근할수 있다. 
			System.out.println("num--->"+num);
			System.out.println("name--->"+ name);
		}
		
	}
	
	public static void main(String[] args) {
	//	OuterClass oc = new OuterClass();
	//	oc.print();
		
		//내부 클래스 객체 생성하기
		//1. 외부클래스객체 생성->내부클래스 객체생성
		InnerClass ic = new OuterClass().new InnerClass();
		ic.output();
		
		//2. 
		OuterClass oc2  = new OuterClass();
		InnerClass ic2 = oc2.new InnerClass();
		ic.output();
		
		//
		oc2.createInner();

	}

}
