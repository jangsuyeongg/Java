import java.util.Scanner;
class Ex04_if 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int kor, eng, math, total;
		double avg;
		char grade;

		System.out.print("국어=");
		kor = scan.nextInt();
		System.out.print("영어=");
		eng = scan.nextInt();
		System.out.print("수학=");
		math = scan.nextInt();

		total = kor + eng + math;
		avg = total / 3.0;
		

		if(avg>=90) grade = 'A';
		else if(avg>=80) grade = 'B';
		else if(avg>=70) grade = 'C';
		else if(avg>=60) grade = 'D';
		else grade = 'F';

		System.out.printf("총점=%d\n평균=%.2f\n학점=%c\n", total, avg, grade );


	}
}
