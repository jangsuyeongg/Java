
public class AaaBbbMain {

	public AaaBbbMain() {
		
	}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		//하위클래스로 객체를 생성하면 상위클래스에 대입된다.
		AAA a = new BBB();
		a.output();
	
	
		System.out.println("b.tel="+ b.tel);//010-12234-1234
		//System.out.println("a.tel="+ a.tel);
		System.out.println("");
		System.out.println("a.name="+a.name);
		System.out.println("a.num="+a.num);
		
		BBB c = (BBB)a;
		c.output();
		Object obj = new BBB();
		BBB d =(BBB)obj;
		d.output();
		//형변환
		
	
	}
}
