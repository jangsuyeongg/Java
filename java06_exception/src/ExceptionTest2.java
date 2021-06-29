
import java.util.Scanner;
import java.util.InputMismatchException;


public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest2() {
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
				
			}catch(ArrayIndexOutOfBoundsException aioo) {////Exception보다 먼저 와야한다
				System.out.println("배열의 첨자값 에러입니다.");
			}catch(Exception e) {// NumberException , ArithmeticException
				System.out.println("Exception -->"+e.getMessage());
			}
			
		}while(true);
		//	System.out.println("프로그램종료");
	}
	public static void main(String[] args) {
		ExceptionTest2 et = new ExceptionTest2();
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






