import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		try {
			File f = new File("D://testFile/object.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Memo memo = new Memo();
			
			oos.writeObject(memo); //객체로 메모를 만들어서 넣어놓음?/ 
			oos.close();
			fos.close();
			System.out.println("객체 쓰기 완료");
			
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}
}
