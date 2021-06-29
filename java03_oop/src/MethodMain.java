public class MethodMain {

	public static void main(String[] args) {
		//		객체명(instance = reference 변수	
		//							생성자메소드
		MethodTest mt = new MethodTest();
		MethodTest mt2 = new MethodTest("010-1234-5678");
		
		//객체내의 멤버영역의 변수를 다른 데이터로 수정하기
		mt.name= "이순신";
		System.out.println("mt.name="+ mt.name);
		System.out.println("mt2.name="+ mt2.name);

		//
		MethodTest mt3 = new MethodTest(100, "세종대왕");
		
		System.out.println("mt3.num="+ mt3.num);//100
		System.out.println("mt3.name="+mt3.name);//세종대왕
		System.out.println("mt3.tel="+mt3.tel);//010-1234-1234
		
		MethodTest mt4 = new MethodTest("장영실", 200);
		System.out.println("mt4.num="+mt4.num);//200
		System.out.println("mt4.name="+mt4.name);//장영실
		System.out.println("mt4.tel="+mt4.tel);//02-1234-1234
	}

}