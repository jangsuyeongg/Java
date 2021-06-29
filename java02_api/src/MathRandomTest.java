
public class MathRandomTest {

	public static void main(String[] args) {
		// 난수: 컴퓨터가 실행되는 시험에 0.0과 1.0사이의 값이 생성된다.
		
		// 100 -> 0~99
		//     -> 50~100
		
		//랜덤으로 원하는 숫자 범위 구하는 공식!! 
		for(int i=1; i<1000;i++) {
			double ran = Math.random();
			
			int ranInt = (int)(ran*(6)) +1;
			//                   (정수화)( 난수*(큰값-작은값+1)) +작은값
			
			System.out.println(ranInt+"\t");
			if(i%10==0) System.out.println();
			
		}

	}

}
