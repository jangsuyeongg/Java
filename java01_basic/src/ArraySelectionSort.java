import java.util.Random;
public class ArraySelectionSort {

	public static void main(String[] args) {
		Random ran = new Random();
		int ranInt[] = new int[10];
		
		for(int i=0; i<ranInt.length; i++) {
			ranInt[i] =ran.nextInt(100)+1;
			
		}
		
		for(int point=0; point<ranInt.length-1; point++) {//1,2,3,4,5,6,
			
		for(int i=point+1; i<ranInt.length;i++) {//0->1,2,3,4,
											// 1->2,3,4,5,
			
			if(ranInt[point] > ranInt[i]) {
				int temp = ranInt[point];
				ranInt[point]= ranInt[i];
				ranInt[i] = temp;
			}
		}
	}
	//출력
	for(int data: ranInt) {
		System.out.print(data+"\t");
	}
	System.out.println();

		
	}

}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 1-100사이의 난수 10개이상 생성하여 배열대입후 오름차순으로 정렬하여 출력하라.
		// Selection Sort [선택정렬] 이용해라.
		
	/*	int num[] = new int[100];
		
		for(int i=0; i<num.length; i++) {
			int random = (int)(Math.random()*(100-1+1))+1;
			num[i] = random;
		}
		for(int j=0; j<num.length-1; j++) {
			for(int i=j+1; i<num.length;i++) {
				if(num[j] > num[i]) {
					
					int temp = num[j];
					num[j] = num [i];
					num[i] = temp;
				}
			}
		}
		for(int i=0; i<10; i++) {
			System.out.print(num[i]+", ");
		}
		
		*/
