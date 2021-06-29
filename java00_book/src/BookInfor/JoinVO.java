package BookInfor;

public class JoinVO {
	private String id;
	private String password;
	private String name;
	private String tel;
	
	public JoinVO() {
	}
	
	public JoinVO(String id, String password, String name, String tel) {
		this.id= id;
		this.password = password;
		this.name=name;
		this.tel=tel;
		}
	
	public void joinprint() {
		System.out.printf("%s %10s %10s %20s\n",id,password,name,tel);
	}
	public static void jointitle() {
		System.out.println("==================================================================================");
		System.out.println("  회원목록");
		System.out.println("==================================================================================");
		System.out.println("아이디\t  비밀번호\t\t이름\t	전화번호\t");
		System.out.println("----------------------------------------------------------------------------------");
	
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}


