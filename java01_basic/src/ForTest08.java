import java.util.Scanner;
class ForTest08  
{
	public static void main(String[] args) 
	{
	Scanner scan= new Scanner(System.in);
	System.out.print("메뉴[1. 사각형의 넓이, 2. 원의넓이, 3. 종료]?");
	int cnt=scan.nextInt();
	if(cnt==1) { 
		System.out.print("가로=");
		int wid = scan.nextInt();
		System.out.print("세로=");
		int hei = scan.nextInt();
		int result=(wid*hei);
		System.out.printf("사각형의 넓이="+result);
		
	}else if (cnt==2) {
		System.out.print("반지름=");
		int r = scan.nextInt();
		double circle= r * r * 3.141592;
		System.out.print("원의넓이="+ circle);
	}else if(cnt==3) {
		System.out.println("메뉴를 다시선택하세요...");
	}
		
		
		
	}
}

			









/* 
사각형의 넓이 = 가로*세로
원의 넓이 = 반지름*반지름*3.141592

실행
메뉴[1. 사각형의 넓이, 2, 원의 넓이, 3.종료]?1
가로=
세로=
사각형의 넓이= 

메뉴[1. 사각형의 넓이, 2, 원의 넓이, 3.종료]?2
반지름=
원의 넓이=

메뉴[1. 사각형의 넓이, 2, 원의 넓이, 3.종료]?3

*/

