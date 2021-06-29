import java.util.Scanner;
class SwitchTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("정수입력=");
		int color = scan.nextInt();

		switch(color){
			case 1:
				System.out.println("빨강");
			    break;
			case 2:
				System.out.println("노랑");
				break;
			case 3:
				System.out.println("파랑");
			case 4:
				System.out.println("초록");
				break;
			default:
				System.out.println("검정");
				break;
		}
	}
}


// ctrl +  C = Y  누르면 창 닫힘. 
// 반복문 활용 for