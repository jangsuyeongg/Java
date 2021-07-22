import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		try {
			// URL주소(Protocol://host/port/filename)를 이용해 객체를 생성하면 해당 서버의 리소스를 가져올 수 있다.
			// https는 http에 비해 보안이 더 강화된 프로토콜이라 https가 더 자주 쓰인다. 
			URL url = new URL("https://www.nate.com/"); // 얘는 메인 페이지라 file, path가 안나옴
//			URL url = new URL("https://sports.news.naver.com/news.nhn?oid=076&aid=0003756776"); // 이런 애들로 들어가보면 나옴
			// 각각 구해서 찍어보기
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile(); // 경로+파일명+데이터
			String path = url.getPath(); // 경로+파일명
			System.out.println("protocol-->" + protocol);
			System.out.println("host-->" + host);
			System.out.println("port-->" + port);
			System.out.println("file-->" + file);
			System.out.println("path-->" + path);
			
			
			// 이 친구들은 한글을 표시하기 위해 어떤 유니코드를 쓰는지(보통 UTF-8)를 알아오기 위한 코드이다...
			// URLConnection 객체로 해당 페이지의 헤더 정보 구하기
			URLConnection connection = url.openConnection();
			// connect()로 먼저 통신 채널을 확보해야 헤더 정보를 가져올 수 있다.
			connection.connect();
			// 헤더 정보는 getContentType() 얘로 가져온다.
			String type = connection.getContentType();
			System.out.println("Content-Type-->" + type);
			// 코드 가져오기
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8);
			System.out.println("encode-->" + encode);
			
			
			System.out.println("==============================================================================");
			
			
			// URL 객체에서 리소스 가져오기
			// 자바에 들어오는(Input/Reader) 파일은 콘솔/파일/네트워크(URL객체)이므로 URL 객체를 통해서도 당연히 inputStream 객체를 만들 수 있다.
			// InputStream(1byte) > InputStreamReader(1글자) > BufferedReader(1줄)로 만들어서 넉넉하게 한줄씩 읽어오자!
			// InputStream(1byte) > InputStreamReader(1글자) 이 과정을 하는 이유는 한글이 2byte라서 깨지기 때문이다.... 억울하면 영어권 인간이 되자...
			// 이 과정에서 한글이 깨지지 않도록 하는 InputStreamReader의 Constructor가 있단다. 두 번째 매개변수로 UTF-8을 전달하면 된다.
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			// 이제 한 줄씩 읽어올 수 있으므로 전부 읽어올 떄까지 반복하자
			while(true) {
				String readData = br.readLine();
				if(readData == null) break;
				System.out.println(readData);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLTest();
	}
}


// 어디 페이지에 접속하면 .jsp / .asp / .php / .html 등의 파일이 실행되고 우리는 그것을 보는 것이다.
// 근데 파일명이 왜 없냐? 걔네가 세팅해 놔서 그렇다.
// 페이지가 바뀌면 도메인이 갑자기 몹시 길어진다.
// 얘를 자세히 살펴보면
// https://domain/(port)/folder/file.html?변수 값 변수 값 ... 등으로 이루어져 있다.
// (프로토콜)(도메인) (포트)    (경로 및 파일명)     (변수와 값들)
// 웹 포트는 보통 80이나 8080(기본) 다른 포트를 쓸 수도 있다.
// 얘네로 URL 객체를 만들면 해당 페이지를 만들 때 쓴 소스코드를 가져올 수 있다.
// 왜냐하면 오픈소스이기 때문이다