
public class SubTest extends SuperTest {

		public SubTest(int a) {
			super(a);
			}
		public SubTest() {
			SubTest st = new SubTest(10);
		
		}
		public static void main(String[] args) {
			SubTest st = new SubTest(10);
			System.out.println(st.a);
		}
					
	}
	


