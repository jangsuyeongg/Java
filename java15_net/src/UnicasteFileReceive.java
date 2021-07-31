import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteFileReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteFileReceive() {
		receiveStart();
	}
	public void receiveStart() {
		try {
			ds = new DatagramSocket(16000);
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			FileOutputStream fos = null;
			
			while(true) {
				//받기 대기
				System.out.println("받기대기중");
				ds.receive(dp);
				
				//전송한 내용이 파일명, 파일내용, 마지막 표시인지 확인
				byte[] receiveData = dp.getData();
				int len = dp.getLength();
				
				String part = new String(receiveData,0,4);
				if(part.equals("FN##")) {//파일명
					String filename = new String(receiveData,4,len-4);
					System.out.println("filename--->"+filename);
					fos = new FileOutputStream(new File("D:\\download",filename));
					System.out.println("io객체 생성됨.");
				}else if(part.equals("$%#$")) {
					//파일의 내용일떄
					if(fos!=null) {
						fos.write(receiveData,4,len-4);
					}
				}else if(part.equals("^%$&")) {
					fos.close();
					fos = null;
					System.out.println("파일받기 완료");
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UnicasteFileReceive();
	}

}
