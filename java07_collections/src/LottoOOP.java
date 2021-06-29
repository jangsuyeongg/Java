import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoOOP {
	Random random = new Random();
	Scanner scan= new Scanner(System.in);
	public LottoOOP() {
		
	}
	//1게임만들기 + 보너스 포함, 중복검사
	public void lottoCreate(int i) {
		//중복제거, 정렬
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		int num=0;
		while(lotto.size()<7) {
			num=random.nextInt(45)+1;
			lotto.add(num);			
		
		}
		//lotto TreeSet번호 7개가 있고, num에는 마지막으로 만든 번호가 있다.
		//보너스번호는 로또번호에서 지운다.  TreeSet번호 6개가 있다.
		lotto.remove(num);
	
		lottoPrint(i, lotto.toString(), num);
		//toString : 문자열로만들어 리턴하는 메소드
	}

	// 출력
	public void lottoPrint(int cnt, String lotto, int bonus) {
		System.out.print(cnt+"게임");
		System.out.print(lotto);//번호
		System.out.println(", bonus="+ bonus);
		
	}
	//계속여부 확인하는 메소드
	public boolean yesNO() {
		do {
			System.out.println("계속하시겠습니까(y:예. n:아니오)?");
			String qa =  scan.nextLine();
			//y:계속, n:종료, 그외 다시 
			if(qa.equalsIgnoreCase("y")) {
				return true;
			}else if(qa.equalsIgnoreCase("n")){
				return false;
			}
		}while(true);
	}
	
	public void lottoStart() {
		do {
			try {
			    System.out.print("게임수=");
			   	int game = Integer.parseInt(scan.nextLine());//NumberFormatException
			   	//게임
			   	for(int i=1; i<=game; i++) {
			   		 lottoCreate(i);
			   	
			   	}
				//계속여부
			   	if(!yesNO()) {
			   		break;
			   	}
			}catch(NumberFormatException nfe) {
				System.out.println("게임수는 양의 정수이어야 합니다.");
			}
		}while(true);
	}
	
	public static void main(String a[]) {
		LottoOOP oop = new LottoOOP();
		oop.lottoStart();
	}
}















