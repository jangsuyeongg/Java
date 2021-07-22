import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		try {			
			// getLocalHost(): 현재 내 컴퓨터의 IP를 이용해서 InetAddress 객체 생성하기 
			InetAddress ia1 = InetAddress.getLocalHost();
			// 내 아이피 확인 한 번 해보기...
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			System.out.println("hostAddr1->" + hostAddr1); // 내 IP(cmd > ipconfig로 확인)
			System.out.println("hostName1->" + hostName1); // 내 컴퓨터 이름(내PC > 속성에 등록된 디바이스 이름), 만약 URL이 나왔다면 웹 서버를 이용하고 있는 것이다
			
			
			// getByName(): URL 주소로 InetAddress 객체를 생성하기, IP와 URL 주소 정보가 객체에 담긴다. 
			// https: 웹에 관련된 통신 규약(프로토콜)
			// www: world wide web
			// domain: (nate.com 등)
			// 대충 웹사이트의 www.domain을 가지고 객체를 만들면 해당 웹 서버의 주소를 알 수 있는 것이다...! 
			InetAddress nate = InetAddress.getByName("www.nate.com");
			System.out.println("nate->address-->: " + nate.getHostAddress());
			System.out.println("nate->name-->: " + nate.getHostName());
			// 검색창에 IP 주소를 그냥 쳐도 네이트에 접속이 되는 것을 확인할 수 있다! lol
			
			
			// 근데 반대로 IP로 객체를 만들면 IP만을 구해주고 도메인을 구해주지는 못한다. 왜냐하면 IP가 실제 주소고 도메인은 별명 비스무리한 것이기 때문이다... 
			InetAddress nateIp = InetAddress.getByName("120.50.131.112");
			System.out.println("nateIP->address-->" + nateIp.getHostAddress());
			System.out.println("nateIP->name-->" + nateIp.getHostName());
			
			
			// getAllByName(): 해당 서버가 사용하는 모든 IP 주소 구하기
			// 구글이나 네이버같은 위대한 사이트에서는 IP 주소를 여러개 쓰는 경우도 있기 때문에... 이게 종종 필요하다  
			InetAddress[] ip = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ia : ip) {
				System.out.println("============================================================================");
				System.out.println("address-->" + ia.getHostAddress());
				System.out.println("name-->" + ia.getHostName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InetAddressTest();
	}
}

// 컴퓨터 사이의 통신을 할 때 정보를 받는 컴퓨터의 ip(주소)가 필요하다
// ip는 하나를 쓰지만, 여러개의 port(2의 16제곱 개 있음)가 있어서 여러 대의 컴퓨터와 동시에 통신할 수 있다.
// (내 컴퓨터의 ip 확인> cmd > ipconfig)
// (유동IP는 부팅시마다 바뀌는 IP, 고정IP는 변하지 않는 고유의 IP)
// 상대방 컴퓨터의 IPv4 주소를 객체로 만들어 정보를 보낼 수 있다. (String)
// 이는 InetAddress 클래스를 통해 만들 수 있다. 해당 클래스는 Serializable(직렬화)를 상속하므로 