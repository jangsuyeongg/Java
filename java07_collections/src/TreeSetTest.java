import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	String list[] = {"JAVA", "Spring", "스프링프레임", "JAVA", "자바", "ORACLE", "스프링", "ORACLE"};
	public TreeSetTest() {
		start();
	}
	public void start() 
	{
		// TreeSet : 입력순서 유지하지않는다.
		//			 중복데이터 허용하지 않는다.
		//			 정렬한다.
		TreeSet<String> ts = new TreeSet<String>();
		//TreeSet에 객체 추가
		for(String data : list) {
			ts.add(data);
		}
		//오름차순으로 정렬되어있다.
		System.out.println(ts.size());
		Iterator<String> ii = ts.iterator();
		
		while(ii.hasNext()) {
			String d = ii.next();
			System.out.println(d);
		}
		//내림차순으로 정렬하여 객체 가져오기
		Iterator<String> iii = ts.descendingIterator();
		while(iii.hasNext()) {
			String d = iii.next();
			System.out.println(d);
		}
	}
	public static void main(String[] args) {
		new TreeSetTest();

	}
}
