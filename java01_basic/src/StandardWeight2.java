import java.util.Scanner;
class StandardWeight2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
	
		System.out.print("나이=");
		int age = scan.nextInt();
		System.out.print("성별(1:남성,2:여성)=");
		int gender = scan.nextInt();
		System.out.print("키=");
		double height = scan.nextDouble();
		System.out.print("현재체중=");
		double weight = scan.nextDouble();

		double idx = 0.90;
		if(age<=35 && gender==2)
			idx = 0.85;
		else if(age >= 60 && gender == 1)
			idx = 0.95;

		//표준체중

		double sWeight = (height-100)*idx;

		//표준체중지수
		double sWeightIndex = (weight/sWeight)*100;
		//표중체중지수 평가기준
		String sWeightMsg = "";
		if(sWeightIndex<=85) sWeightMsg = "마른형";
		else if(sWeightIndex<=95) sWeightMsg = "조금마른형";
		else if(sWeightIndex<=115) sWeightMsg = "조금비만형";
		else sWeightMsg = "비만형";

		System.out.printf("표준체중=%.2f\n", sWeight);
		System.out.printf("당신의 표준체중지수는 %.2f으로 %s입니다.\n", sWeightIndex, sWeightMsg);



	}
}
