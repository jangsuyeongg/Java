import java.io.File;
import java.io.RandomAccessFile;

public class RamdomAccessFileTest {

	public RamdomAccessFileTest() {
		//원하는 위치의 데이터를 읽고 쓰기가 가능하다.
		File f = new File("D://testFile/access.txt");
		try {
			// 쓰기전용: w, 읽기전용 : r, 읽기쓰기 : rw
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String str = "Java input output test programing";
			raf.writeBytes(str);
			raf.writeInt(12345);
			
			//쓰기할 위치 이동
			raf.seek(10);
			raf.writeBytes("hong");
			
			// 커서를 마지막으로 옮기기 
			raf.seek(raf.length());
			byte[] data = {65,66,67,68};
			raf.write(data);
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RamdomAccessFileTest();

	}

}
