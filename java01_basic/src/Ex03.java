import java.util.Scanner;
class Ex03 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		for(;;){
		System.out.print("메뉴선택[1. 사각형의 넓이, 2. 사각형의 둘레, 3. 종료]?");
		int menu = sc.nextInt() ;

		if(menu==3 ){
			System.exit(0);

		}else{
		System.out.print("가로(밑변)=");
		int width = sc. nextInt();
		System.out.print("세로(높이)=");
		int height = sc.nextInt();


		int result = (menu == 1)? width*height : (width+height)*2 ;

		String msg = (menu==1)? "넓이":"둘레";

		System.out.println("사각형의 "+msg+"="+ result);



		   

		}
		}
	}
}
/*
사각형의 넓이 = 밑변 * 높이
사각형의 둘레 (가로+세로)*2

실행
메뉴선택(1. 사각형의 넓이, 2. 사각형의 둘레)? 1
가로(밑변)=
세로(높이)=
사각형의 넓이 = 

메뉴선택(1. 사각형의 넓이, 2. 사각형의 둘레)? 2
가로(밑변)=
세로(높이)=
사각형의 둘레 = 




*/