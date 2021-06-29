package test;

public class DefaultData {
	static String name="ȫ�浿";
	String tel = "010-1234-5678";
	public DefaultData() {
		
	}
	public DefaultData(String name, String tel) {
		this.name = name;
		this.tel = tel;
		
	}
	public static void sum() {
		int tot=0;
		for(int i=1; i<=100; i++) {
			tot += i;
		}
		System.out.println("tot="+ tot);
	}
	
	public static String getName() {
		return name;
	}

}
