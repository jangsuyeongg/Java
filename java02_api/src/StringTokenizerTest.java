import java.util.StringTokenizer;

public class StringTokenizerTest {

	public StringTokenizerTest() {
		String txt = "서울시, 마포구,,,,,,,, 신수동. 거구빌딩, 3층, 비트캠프, 교육센터";
		
		StringTokenizer st = new StringTokenizer(txt,".,");
		int tokenCount = st.countTokens();
		System.out.println("토큰수->"+ tokenCount);
		
		while(st.hasMoreElements()) {// true :남은 토큰이 있을떄  false:남은토큰이 없을때
			String token = st.nextToken();
			System.out.println(token);
			
		}
	}

	public static void main(String[] args) {
		new StringTokenizerTest();

	}

}
