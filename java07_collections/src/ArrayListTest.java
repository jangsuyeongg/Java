import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		CollectionData data = new CollectionData();
		List<MemberVO> lst = data.getMember();
		
		// index 2에 추가. 나머지는 하나씩 뒤로 밀림
		
		MemberVO vo2 = new MemberVO("ZZZ","기획총괄부","2020-01-02",5000);
		lst.add(2, vo2);
		
		//lst.remove(1);// index 삭제
		//lst.remove(vo2);// 객체명으로 삭제
		
		for(int i =0;i<lst.size(); i++) {
			MemberVO vo = lst.get(i);
			vo.memberPrint();
		}
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
