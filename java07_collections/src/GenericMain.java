import java.util.Calendar;

public class GenericMain {

	public GenericMain() {
		String data = "서울시 마포구 백범로";
		GenericTest gt = new GenericTest();
		gt.setUsername(data);
		
		GenericTest gt2 = new GenericTest(data);
		
		Calendar now = Calendar.getInstance();
			
		GenericTest<MemberVO> gt3 = new GenericTest<MemberVO>();
		gt3.setUsername(new MemberVO("홍","기획부","2021-01-21",8000));
		
		GenericTest<Calendar> gt4 = new GenericTest<Calendar>(now);
		
		MemberVO vo = gt3.getUsername();
		System.out.println(vo.toString());
		
		System.out.println(gt4.getUsername());
	}
	public static void main(String[] args) {
		new GenericMain();
	}
}


