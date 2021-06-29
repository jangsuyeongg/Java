import java.util.Scanner;
import java.util.Calendar;
class CalendarEx03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("년도=");
		int year = scan.nextInt();
		System.out.print("월=");
		int month = scan.nextInt();

		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		//현재 날짜 시간 객체 구하기
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, 1);// 날짜변경 

		int week = date.get(Calendar.DAY_OF_WEEK); // 1일이 무슨요일인지 구하는거

		//달의 마지막날
		//1,3,5,7,8,10,12 ->31일
		//4,6,9,11-> 30일
		//2 -> 28일,29일

	/*	int lastDay = 31;
		switch(month){
			case 4: 
			case 6:
			case 9:
			case 11:
				lastDay=30;break;
			case 2:
				// 년도가 4로 나누어지고, 100으로 안나눠지면 윤년이다.
				// 400으로 나누어지면 윤년이다
				if(year%4==0 && year%100!=0 || year%400==0){
					lastDay = 29;
				}else{
					lastDay = 28;
				}
		}
		*/
		
		int lastDay = date.getActualMaximum(Calendar.DATE); 
		//공백출력
		for(int s=1; s<week; s++){
			System.out.print("\t");
		}
		//날짜 출력
		for(int d=1; d<=lastDay;d++){
			System.out.print(d+"\t"); 
			if((d+week-1)%7==0){
				System.out.println();
			}
		}
		System.out.println();

	}
}
