import java.util.Random;
public class RandomTest {

	public static void main(String[] args) {
		// Random : 난수 생성클래스
		Random ran = new Random();
		
		for(int i=1; i<=1000; i++) {
			
			// 정수(int)를 구한다.
			//int random = ran.nextInt(100); // 0~99
			//int random= ran.nextInt();//+-21억
			//int random= ran.nextInt(50);//0~49
			//boolean random= ran.nextBoolean();
			//50~100   큰값-작은값+1   0~50
			int random =ran.nextInt(100-50+1)+50;
			
			System.out.print(random+"\t"); 
			if(i%10==0) {
				System.out.println();
				
			}
		}		
	}
}
