import java.util.Scanner;
class IfElseTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("양의 정수를 입력=");
		int data = scan.nextInt();

		if(data%2==0){
			int result = data*100;
		}else{
			int result = data*200;
			System.out.printf("%d--> %d\n", data, result);
	
		
	}


	}
}


	

