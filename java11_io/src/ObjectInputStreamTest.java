import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			File f = new File("D://testFile/object.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Memo memo =(Memo)ois.readObject();
			memo.setVisible(true);
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}
