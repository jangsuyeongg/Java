package test;

public class ProtectedTest2 {
	protected String tel = "010-1234-8959";
	
	protected ProtectedTest2(){
		System.out.println("다른패키지의 생성자메소드");
		
	}
	protected void telOutput() {
		System.out.println("전화번호="+ tel);
	}
	
	public String getTel() {
		return tel; //객체생성이 안됨. 
	}
	public static ProtectedTest2 getInstance() {// 생성안되니까 static , getInstance 단독으로 호출
		return new ProtectedTest2();
		//getInstance() - static calendar 못써서 대신 쓰는거...?
	}
}