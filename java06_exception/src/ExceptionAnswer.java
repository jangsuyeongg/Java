import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionAnswer {

	public ExceptionAnswer() {
		start();
	}
	public void start() {
		do {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("숫자1=");
				int a = scan.nextInt();
				System.out.print("숫자2=");
				int b = scan.nextInt();
				int c = a/b;
				System.out.println("c="+c);
		
				String names[] = {"이순신","세종대왕"};
				for(int i=0; i<=names.length; i++) {
					System.out.println("이름="+names[i]);
				}
			}catch(InputMismatchException imie) {
				System.out.println("정수를 입력하여야 합니다.");
				//imie.printStackTrace();// 에러메시기 찍어주는 기능!! 어디에 문제있는지 알수있음. 
				System.out.println(imie.getMessage());//간단한 에러메시지 볼수있음.
			}catch(ArithmeticException ae) {
				System.out.println("0으로 나눌수 없습니다.");
				//ae.printStackTrace();
				System.out.println(ae.getMessage());
			}catch(ArrayIndexOutOfBoundsException aioo) {
				System.out.println("배열의 첨자값이 잘못되었습니다.");
				System.out.println(aioo.getMessage());
			}catch(NumberFormatException nfe) {
				System.out.println("숫자를 입력하여야 합니다.");
			}
		
		}while(true);
		
		}

	public static void main(String[] args) {
		new  ExceptionAnswer();
	}
}
