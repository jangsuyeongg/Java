import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//Set인터페이스상속받은 클래스는 
		//1. 입력순서를 유지하지 않는다.
		//2. 중복데이터를 허용하지 않는다.
		
		double[] data = {12.3, 3.4, 5.6, 12.3, 5.2, 9.1, 9.1, 6.1};
		
		HashSet<Double> hs = new HashSet<Double>();
		
		for(double a : data) {
			hs.add(a);
		}
		
		System.out.println("size="+ hs.size());//--
		
		Iterator<Double> ii =hs.iterator();
		
		//while(trye)
		while(ii.hasNext()) {
			Double iiData = ii.next();
			System.out.println(iiData);
		}
	}

	public static void main(String[] args) {
		new HashSetTest();

	}
}
