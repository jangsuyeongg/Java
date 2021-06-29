package EmpInfor;

import java.util.HashMap;

public class EmpDataSet {
	public static HashMap<String, EmpVO> empList = new  HashMap<String, EmpVO>();

	public EmpDataSet() {
		
	}
	//±âº»µ¥ÀÌÅÍ ¼ÂÆÃ
	public static void basicEmpSet() {
		empList.put("È«±æµ¿", new EmpVO("11111","È«±æµ¿","010-1234-5678",5000,"2020-05-05"));
		empList.put("º¸¶óµ¹", new EmpVO("22222","º¸¶óµ¹","010-8888-9999",6000,"2020-01-01"));
		empList.put("¶Ñºñºñ", new EmpVO("66666","¶Ñºñºñ","010-7777-8888",5500,"2020-10-10"));
		empList.put("³ª³ª³ª", new EmpVO("44444","³ª³ª³ª","010-5555-5555",7000,"2009-03-01"));
		empList.put("»Ç»Ç»Ç", new EmpVO("55555","»Ç»Ç»Ç","010-1212-3434",4500,"2012-08-09"));
	}
}
