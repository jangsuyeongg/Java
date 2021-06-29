package BookInfor;

import java.util.HashMap;


public class JoinDataSet {
	public static HashMap<String, JoinVO> joinList = new HashMap<String, JoinVO>();
	
	public JoinDataSet() {
	}

	public static void basicJoinSet() {
		joinList.put("º¸¶óµ¹", new JoinVO("º¸¶óµ¹","1234","±èº¸¶ó","010-2156-9756"));
		joinList.put("¶Ñºñºñ", new JoinVO("¶Ñºñºñ","5678","¹Ú¶Ñºñ","010-8745-9632"));
		joinList.put("³ª³ª³ª", new JoinVO("³ª³ª³ª","0000","ÀÌ³ª³ª","010-7456-3215"));
		joinList.put("»Ç»Ç»Ç", new JoinVO("»Ç»Ç»Ç","0123","ÃÖ»Ç»Ç","010-7426-6654"));
		joinList.put("ÇÞ´ÔÀÌ", new JoinVO("ÇÞ´ÔÀÌ","0101","°­ÇÞ´Ô","010-7567-5896"));
	}
}
	
	
	
	
	

