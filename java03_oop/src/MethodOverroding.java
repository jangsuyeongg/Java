
public class MethodOverroding {

	public MethodOverroding() {
		// TODO Auto-generated constructor stub
	}

	
	//오버로딩
	// 같은 클래스에서 메소드명이 같은 메소드가 여러개 존재할 때 오버로딩이라고 한다.
	// 메소드명과 반환형이 같은 매개변수의 갯수가 데이터형은 달라야한다.
	int totalResult() {
		//1~100까지의 합을 구한다.
		int result =0;
		for(int i=1; i<=100; i++) {
			result += i;
		}
		return result;
	}
	// 1~max까지 합을 구한다.
	int totalResult(int max) {
		
		int result=0;
		for(int i=1; i<=max; i++) {
			result += i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		MethodOverroding mo = new MethodOverroding();
		
		int r = mo.totalResult();//1~100까지 합
		int rr = mo.totalResult(200);//1~200까지 합
		System.out.println("r="+r);
		System.out.println("rr="+rr);
		
		System.out.println(100);
		System.out.println(10.36);
		System.out.println('A');
	}
}