import java.util.Scanner;

public class OOP_Ex01 {

	public OOP_Ex01() {
		int dan= danInput();
		String result = gugudan(dan);
		System.out.println(result);	
		//	System.out.println(gugudan(danInput()));
	}

	//단 입력받기
	int danInput() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단입력=");
		return scan.nextInt();
		
	}
	
	
	// 구구단 출력하기
	String gugudan(int dan) {
		String gugu="";
		for(int i=2; i<=9;i++) {
			gugu+= dan+"*"+i+"="+dan*i+"\n";
		}
		return gugu;
	}
	

	public static void main(String[] args) {
		OOP_Ex01 oop = new OOP_Ex01();
		
	//System.out.println(oop.gugudan(oop.danInput()));

	}

}

// 콘솔에서 단을 입력받아 입력받은 구구단은 출력하라.