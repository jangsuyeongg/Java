import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		
		List<MemberVO> mem = new ArrayList<MemberVO>();
		mem.add( new MemberVO("홍길동","기획부","2020-10-10", 5000));
		mem.add( new MemberVO("이순신","총괄부","2020-01-01", 6000));
		mem.add( new MemberVO("장영실","총무부","2020-07-08", 3000));
		mem.add( new MemberVO("세종대왕","인사부","2020-02-01", 7000));
		mem.add( new MemberVO("유승룡","기획부","2020-03-05", 6000));
		mem.add( new MemberVO("김삿갓","영업부","2021-02-10", 5000));
		
		System.out.println("=====정렬전 ==============");
		// 제너릭객체 : 컬렉션객체
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("====급여를 오름차순으로 정렬 ======");
		//		객체가 전체있는 컬렉션, 정렬할 기준이 있는 compare객체
		Collections.sort(mem, new CompareAscSal());
		for(MemberVO vo:mem) {
			System.out.println(vo.toString());
		}
		System.out.println("====급여를 내림차순으로 정렬=====");
		Collections.sort(mem, new CompareDescSal());
		for(MemberVO vo: mem) {
			System.out.println(vo.toString());
		}
		System.out.println("====이름을 기준으로 오름차순 정렬====");
		Collections.sort(mem, new CompareAscName());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("=====이름을 기준으로 내림차순 정렬 ===");
		Collections.sort(mem, new CompareDescName());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("=====입사일을 기준으로 내림차순 정렬 ===");
		Collections.sort(mem, new CompareAscHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("=====입사일을 기준으로 내림차순 정렬 ===");
		Collections.sort(mem, new CompareDescHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		
		
		
	}
	//정렬하는 클래스 Comparator 인터페이스를 상속받아만든다.
	
	class CompareAscHire implements Comparator<MemberVO>{
		public int compare(MemberVO obj1, MemberVO obj2) {
			return obj1.getHire().compareTo(obj2.getHire());
			
		}
	}
	

	class CompareDescHire implements Comparator<MemberVO>{
		public int compare(MemberVO o1, MemberVO o2) {
			return o1.getHire().compareTo(o2.getHire());
			
		}
	}
	
	
	//숫자를 이용한 오름차순 정렬하는 클래스
	class CompareAscSal implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			//		조건식 
			//		왼쪽객체의값이 작으면 -, 크면 + 를 리턴 , 같으면 0을 리턴
			return (v1.getSal() < v2.getSal())? -1 : (v1.getSal() > v2.getSal())? 1 : 0 ;              
			
		}
	}
	//숫자를 이용한 내림차순 정렬하는 클래스
	class CompareDescSal implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			return (v1.getSal() < v2.getSal())? 1 : (v1.getSal() > v2.getSal())?   -1 :0;
		}
	}
	//이름을 오름차순으로 정렬하는 클래스
	class CompareAscName implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			//왼쪽이 작으면 음수, 왼쪽이 크면 양수, 같으면 0
		//	System.out.println( v1.getName()+", "+v2.getName()+"-->"+v1.getName().compareToIgnoreCase(v2.getName()));
			return v1.getName().compareToIgnoreCase(v2.getName()); 
		}
	}
	
	//이름을 내림차순으로 정렬하는 클래스
	class CompareDescName implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getName().compareTo(v1.getName()); 
		}
	}
	
	public static void main(String[] args) {
		new ObjectCompareTest();

	}
}
