import java.util.Scanner;
import java.util.Arrays;

public class Lotto02 {
	
	int cnt, game;
	int lotto[]= new int[7];
	
	
	public Lotto02() {
		do {
			start();
			
		}while(true);
		
	}
	
	
		int getInput(String a) {
			Scanner scan = new Scanner(System.in);	
			System.out.print(a);
			return scan.nextInt();
		}
		
		
		void setInput() {
			 cnt = getInput("게임수=");
		}
	
	
		void setOutput() {
			for(int game=1; game<=cnt; game++) {
				
				int lotto[] = new int[7];
				for(int i=0; i<lotto.length; i++) {
					lotto[i] = (int)(Math.random()*45) +1;
					
					for(int c=0; c<i; c++) {
						if(lotto[i] == lotto[c]) {// 
							i--; 
							
						}
					}
				}	
				Arrays.sort(lotto);
				Arrays.toString(lotto);
			
				System.out.print(game+"게임=");
				for(int i=0;i<lotto.length-1; i++) {
					System.out.print(lotto[i]+", ");
				}
				System.out.println("bonus="+ lotto[6]);
			}
			
		
		  }
		
		
		void start() {
			setInput(); 
			setOutput();

		}
		
		
	
	
	public static void main(String[] args) {
		new Lotto02();
		
	}

}