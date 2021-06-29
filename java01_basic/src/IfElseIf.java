import java.util.Scanner;
class IfElseIf
{
public static void main(String[] args)
{
Scanner scan = new Scanner(System.in);


	// 1. 급여입력
	System.out.print("급여를 입력하세요-->");
	int sal = scan.nextInt();
    double bonus = 0;
	if(sal>=10000 && sal<=20000){
		bonus = (sal * 0.2);
	}else if(sal>20000 && sal<=30000){
		bonus = (sal * 0.15);
	}else if(sal>30000 && sal<=40000){
		bonus = (sal * 0.1);
	}else if(sal>40000 && sal<=50000){
		bonus = (sal * 0.05);
	}
	System.out.printf("급여=%d, 보너스=%.0f\n", sal, bonus);
  }
}

/*
    int bonus = 0;
	if(sal>=10000 && sal<=20000){
		bonus = (int)(sal * 0.2);
	}else if(sal>20000 && sal<=30000){
		bonus = (int)(sal * 0.15);
	}else if(sal>30000 && sal<=40000){
		bonus = (int)(sal * 0.1);
	}else if(sal>40000 && sal<=50000){
		bonus = (int)(sal * 0.05);
	}
	System.out.printf("급여=%d, 보너스=%d\n", sal, bonus);

	*/