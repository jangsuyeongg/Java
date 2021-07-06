import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			System.out.print("입력=");
			while(true) {
//				int code = isr.read();//한번에 1문자씩 입력받는다.
//				if(code ==1) break;
//				System.out.println(code+"-->"+ (char)code);
				
				//배열을 이용하여 입력받기
				char[] data = new char[5];
				int cnt = isr.read(data);
				if(cnt<=0)break;					// new String(data)
				System.out.println("cnt:"+cnt+"-->"+ String.valueOf(data)+"-->"+data);
				
				
			}
		}catch(IOException e) {
			
		}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
