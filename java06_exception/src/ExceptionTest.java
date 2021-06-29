//예외처리 
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest() {
		
	}
	public void start() {
		do {
			try {
				//두수를 입력받아 사칙연산하여 출력하라.
				System.out.print("첫번쨰 수=");
				int n1 = scan.nextInt();//---------------
				System.out.print("두번째 수=");
				int n2 = scan.nextInt();//---------------
				
				int plus = n1 + n2;
				int minus = n1 - n2;
				int mul = n1 * n2;
				int devide = n1 / n2;//-------------------	
				System.out.println(n1+"+"+n2+"="+plus);
				System.out.println(n1+"-"+n2+"="+minus);
				System.out.println(n1+"*"+n2+"="+mul);
				System.out.println(n1+"/"+n2+"="+devide);
				
				String names[] = {"홍길동","김길동"};
				for(int i=0; i<=names.length; i++) {
					System.out.println("names["+i+"]="+names[i]);
					
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
			}finally {
				//예외발생과 상관없이 무조건 실행
				System.out.println("finally 실행됨...");
			}
			
		}while(true);
		//	System.out.println("프로그램종료");
		}
		public static void main(String[] args) {
			ExceptionTest et = new ExceptionTest();
			et.start();
		}

}
/*
  에러: 하드웨어 에러 처럼 프로그램에서 제어할 수 없는 에러를 말한다. 
  예외처리: 프로그램에서 제어할수있는 에러를 Exception이라고 한다.
  
  1. 방법
  try{
  	  실행문;
  	  예외발생할 가능성이 있는 명령어 또는 예외발생할 가능성이 없는 명령어를 모두 표기할 수 있다.
  	  
  }catch(예외종류){
  		예외가 발생하면 실행할 실행문
  }catch(예외종류){
  		예외가 발생하면 실행할 실행문
  
  }
  :
  :
  finally{
  		예외가 발생하든 안하든 무조건 실행되는 실행문;
  		생갹가능
  }
  
 */






