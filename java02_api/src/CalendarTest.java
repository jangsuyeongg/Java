import java.util.Calendar;
class CalendarTest 
{
	public static void main(String[] args) 
	{
		//컴퓨터의 날짜 시간정보 얻어오기
		// Calendar, Date

		Calendar now = Calendar.getInstance();
		//getInstance - 객체를 생성해주는 메소드 

		now.set(2018,6,14);
		now.set(Calendar.YEAR, 2022);
		now.set(Calendar.MONTH, 10);
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);

		String weekStr = "";
		switch(week){
			case 1: weekStr = "일"; break;
			case 2: weekStr = "월"; break;
			case 3: weekStr = "화"; break;
			case 4: weekStr = "수"; break;
			case 5: weekStr = "목"; break;
			case 6: weekStr = "금"; break;
			case 7: weekStr = "토"; break;
		}
		System.out.printf("%d년 %d월 %d일 (%s) %d:%d\n", year, month, day, weekStr, hour, minute);

		System.out.println(now);

		
		//2022/11/14

		int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("마지막날=>"+ lastDay);
		int lastMonth = now.getActualMaximum(Calendar.MONTH);
		System.out.println("월중에 제일큰값=>"+ lastMonth);
		int lastYear = now.getActualMaximum(Calendar.YEAR);
		System.out.println("년도중에 제일큰값=>"+ lastYear);


	}
}
