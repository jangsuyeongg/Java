public class MethodTest {
	//멤버영억
	int num =12;
	String name="홍길동";
	String tel;//null
	//생성자 메소드: 생략시 자동추가(JVM)
	//			상속관계가 아닐때만 추가해준다
	//		매개변수는 데이터형이 다르거나 변수의 개수가 달라야 한다.
	MethodTest(){}
	MethodTest(String tel){
		System.out.println("연락처:"+tel);
	
	}
	//MethodTest(String name){	
	//}
	MethodTest(int num){
		
	}
	MethodTest(int num, String name){
		// this: 현재객체(현재 클래스)
		this.num = num;
		this.name= name;
		String tel="12345";
		
		this.tel = "02-1234-1234";
		
	}
	MethodTest(String name, int num){
		//생성자메소드에서 다른 생성자 메소드 호출하기
		//생성자메소드에서 다른생성자를 호출할때는 메소드 명을
		//직접표기할 수 없다. this라는걸 써야한다.
		//MethodTest(num, name); x
		//this()이용하여 다른 생성자 메소드를 호출할때는 반드시 첫번째 실행문이여야 한다.
		//System.out.println("===");
		this(num, name); 
		
	}
	
	
}