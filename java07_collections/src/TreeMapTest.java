
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		TreeMap<String, MemberVO> tm = new TreeMap<String, MemberVO>();
		
		//TreeMap은 key, value 를 가진다.
		// key를 기준으로 정렬한다. key= 홍길동,이순신,장....
		tm.put("홍길동", new MemberVO("홍길동","기획부","2020-10-10", 5000));
		tm.put("이순신", new MemberVO("이순신","총괄부","2020-01-01", 6000));
		tm.put("장영실", new MemberVO("장영실","총무부","2020-07-08", 3000));
		tm.put("세종대왕", new MemberVO("세종대왕","인사부","2020-02-01", 7000));
		tm.put("유승룡", new MemberVO("유승룡","기획부","2020-03-05", 6000));
		tm.put("김삿갓", new MemberVO("김삿갓","영업부","2021-02-10", 5000));
		
		System.out.println("======key를 이용하여 객체얻어오기========");
		Set<String>keyList=tm.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			MemberVO vo = tm.get(ii.next());
			System.out.println(vo.toString());
		}
		System.out.println("===value를 이용한 객체 얻어오기====");
		Collection<MemberVO> value =tm.values();
		Iterator<MemberVO> iii = value.iterator();
		while(iii.hasNext()) {
			MemberVO vo = iii.next();
			System.out.println(vo.toString());
		}
	}

	public static void main(String[] args) {
		new TreeMapTest();
	}

}
