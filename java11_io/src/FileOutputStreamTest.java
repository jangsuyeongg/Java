import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileOutputStreamTest {

	public FileOutputStreamTest() {
		try {
			File f = new File("d://testFile/OutputTest.txt");
			
			InputStream is= System.in;
			FileOutputStream fis = new FileOutputStream(f);
			System.out.print("ют╥б=");
			int cnt =0;
			while(true) {
				int data = is.read();
				if(data==-1)break;
				fis.write(data);
				System.out.println(++cnt + "-->"+(char)data);
			}
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new  FileOutputStreamTest();

	}

}
