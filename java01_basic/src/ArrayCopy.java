
public class ArrayCopy {

	public static void main(String[] args) {
		//배열의 복사
		int num[] = {20,49,51,68,75,12,57,69};
		//			원본배열명      복사할 시작index   복사할곳 배열명      index       복사할데이터의 갯수
		// arraycopy(Object src, int srcPos,     Object dest,  int destPos, int length)
		//            num            2             target         5             3
		// num배열에서 index 2에서부터 3개만 복사를 하여 새로운 배열에 대입
		int target[] = new int[10];
				
		System.arraycopy(num, 2, target, 5, 3);
		
		for(int i=0; i<target.length; i++) {
			System.out.println("target["+i+"]="+ target[i]);
			
		}
				
	}

}
