//t.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoOOP {
	Random random = new Random();
	Scanner scan= new Scanner(System.in);
	public LottoOOP() {
		
	}
	public int[] lottoCreate() {
		int lotto[] = new int[7];
		for(int i=0; i<lotto.length; i++) {
			//로또번호 생성
			lotto[i] = random.nextInt(45)+1;			
			//중복검사 
			i = doubleCheck(lotto, i);
		}
		return lotto;
	}
	//중복검사
	public int doubleCheck(int lotto[], int i) {
		for(int j=0; j<i; j++) {
			if(lotto[j] == lotto[i]) {
				i--;
				break;
			}
		}
		return i ;
	}
	
	// 출력
	public void lottoPrint(int cnt, int lotto[]) {
		System.out.print(cnt+"게임");
		System.out.print( Arrays.toString(Arrays.copyOfRange(lotto, 0, 6)));//번호
		System.out.println(", bonus="+ lotto[6]);
		
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
			   		int lotto[] = lottoCreate();
			   		Arrays.sort(lotto,0,6);//정렬
			   		lottoPrint(i,lotto);// 출력
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













