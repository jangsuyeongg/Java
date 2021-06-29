import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Properties 컬렉션: key, value 모두 String인 컬렉션이다.
		
		Properties prop = new Properties();
		
		//객체추가
		prop.setProperty("네이버", "http://www.naver.com");
		prop.setProperty("네이트", "http://www.nate.com");
		prop.setProperty("다음", "http://www.daum.net");
		prop.setProperty("구글", "http://www.google.com");
		//getProperty(): 키를 이용하여 객체 얻어오기
		
		System.out.println(prop.getProperty("다음"));
		
		// 키 목록 전체 구하기
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {//객체가 남아있으면 true, 없으면 false
			//Object obj = e.nextElement();
			String str = (String)e.nextElement();
			System.out.println("key="+str+", value"+prop.getProperty(str));
		}
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
