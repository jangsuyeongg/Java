import java.util.Scanner;
class Ex02 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("양의 정수 입력=");
		int data = scanner.nextInt() ;


		int result = (data>=100 && data<=200)? data : 0 ;
	
        System.out.println("result="+result);


	}
}



/*
   임의의 수를 입력받아 입력받은 수가 100~200사이이면 입력받은 값을 출력하고, 
                                 아니면 0을 출력하라.
*/