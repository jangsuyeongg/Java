import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int age, sex, hei, wei;
		double stw, sti;
		String ass;

		System.out.print("나이=");
		age = scan.nextInt();
		System.out.print("성별(1:남성,2:여성)=");
		sex = scan.nextInt();
		System.out.print("키=");
		hei = scan.nextInt();
		System.out.print("현재체중=");
		wei = scan.nextInt();

		//계산
	/*	if(age<=35){
			if(sex==1){
				stw=(hei-100)*0.90;
			} else{
				stw=(hei-100)*0.85;	
			}
		}else{
			if(sex==1){
				stw=(hei-100)*0.95;
			} else{
				stw=(hei-100)*0.90;	
			}
		} 
*/

		if(age<=35 && sex==1) stw =((hei-100)*0.95);
		else if(age<=35 && sex!=1)  stw =((hei -100)*0.90);
		else if(age>35 && sex==1)  stw =((hei -100)*0.90);
		else stw = ((hei-100)*0.85);
	    sti = (wei/stw)*100;

	/*	if(sti<=85){
			ass="마른형";
		}else if(sti<=95){
			ass="조금마른형";
		}else if(sti<=115){
			ass="표준형";
		}else if(sti<=125){
			ass="조금비만형";
		}else
			ass="비만형";
*/
		if(sti<=85) ass="마른형";
	    else if(sti<=95) ass="조금마른형";
		else if(sti<=115) ass="표준형";
		else if(sti<=125) ass="조금비만형";
		else ass="비만형";



		//결과
		//System.out.printf("표준체중= %.0f", sti);
        System.out.printf("표준체중= %d", (int)sti);
		System.out.printf("당신의 표중체중지수는 %f 으로 %s\n 입니다.", sti, ass);


	}
}