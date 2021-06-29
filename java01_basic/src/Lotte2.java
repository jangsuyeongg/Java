import java.util.Scanner;
public class Lotte2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		do {
			//게임수 입력
			System.out.print("게임수=");
			int cnt = scan.nextInt();
		
			//입력받은 게임수 만큼 게임만들기
			for(int game=1; game<=cnt; game++) {
				//게임1개 만들기
				//로또번호+보너스를 난수로 생성하여 저장할 배열
				int lotto[] = new int[7];
				for(int i=0; i<lotto.length; i++) {
					lotto[i] = (int)(Math.random()*45) +1;
					//중복검사
					for(int c=0; c<i; c++) {
						if(lotto[i] == lotto[c]) {// 
							i--; // 같은데이터면 하나를 줄여서 중복을 없앤다.
							
						}
					}
				}
				//정렬
				for(int i=0; i<lotto.length-2; i++) {//0,1,2,3,4
					for(int j=0; j<lotto.length-2-i; j++) {
						if(lotto[j] > lotto[j+1]) {
							int temp = lotto[j];
							lotto[j] = lotto[j+1];
							lotto[j+1] = temp;
						}
					}
				}
				
				//출력
				System.out.print(game+"게임=");
				for(int i=0;i<lotto.length-1; i++) {
					System.out.print(lotto[i]+", ");
				}
				System.out.println("bonus="+ lotto[6]);
			}
		
			//=====================================================
			System.out.print("계속하시겠습니까[1:예, 2:아니오]?");
			int check =scan.nextInt();
			if(check==2) break;
		}while(true);
	}
}