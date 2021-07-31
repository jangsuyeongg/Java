import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		try {
			ds = new DatagramSocket(15000);
			
			//받기 대기 .................
			byte[]data = new byte[512];
			dp = new DatagramPacket(data,data.length);
			System.out.println("받기대기중..");
			ds.receive(dp);//데이터를 받을 때까지 대기모드...
			//DatagramPacket에서 전송받은 데이터를 얻어오기
			byte[] receiveData = dp.getData();
			int byteCount = dp.getLength();//전송박은 byte수
			String receiveStr = new String(receiveData,0,byteCount);
			System.out.println(receiveStr+"-----------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
