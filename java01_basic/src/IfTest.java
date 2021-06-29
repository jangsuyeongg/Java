import java.util.Scanner;
class IfTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int num;

		System.out.print("0보다 큰 정수를 입력하세요...");
		num = scan.nextInt();

		if(num/2 == num/2.0) //num%2==0
			System.out.printf("%d은 짝수입니다.",num);
		    System.out.println("End");
	}
			
	}
	


