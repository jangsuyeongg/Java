import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("정수입력=");
		int max=scan.nextInt();
		
		//전체합, 홀수합, 짝수합
		int total=0, odd=0, even=0;
		
		for(int i=1; i<=max; i++) {
			total += i;
			
			if(i%2==0) even +=i;
			else odd += i;
			
		}
	

		System.out.printf("1~%d까지의 합은 %d\n", max, total);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n", max, odd);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n", max, even);


	}
}


/*
실행
정수입력=100
1~100까지의 합은 5050
1~100까지의 홀수의 합은 2500
1~100까지의 짝수의 합은 2550

*/