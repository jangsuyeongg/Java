
public class SSStudentVO {
	
	private int Stu_Code;
	private int Major_Code;
	private String stu_pw;
	private String stu_name;
	private String stu_grade;
	private String stu_email;
	private String stu_tel;
	private String stu_add;
	private String stu_state;
	private String stu_date;
	private String stu_birth;
	
	
    
	
	public String allprint() {
		return "StudentVO [Stu_Code=" + Stu_Code + ", Major_Code=" + Major_Code + ", stu_pw=" + stu_pw + ", stu_name="
				+ stu_name + ", stu_grade=" + stu_grade + ", stu_email=" + stu_email + ", stu_tel=" + stu_tel
				+ ", stu_add=" + stu_add + ", stu_state=" + stu_state + ", stu_date=" + stu_date + ", stu_birth="
				+ stu_birth + "]";
	}

	

	public int getStu_Code() {
		return Stu_Code;
	}



	public void setStu_Code(int stu_Code) {
		Stu_Code = stu_Code;
	}



	public int getMajor_Code() {
		return Major_Code;
	}



	public void setMajor_Code(int major_Code) {
		Major_Code = major_Code;
	}



	public String getStu_pw() {
		return stu_pw;
	}



	public void setStu_pw(String stu_pw) {
		this.stu_pw = stu_pw;
	}



	public String getStu_name() {
		return stu_name;
	}



	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}



	public String getStu_grade() {
		return stu_grade;
	}



	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}



	public String getStu_email() {
		return stu_email;
	}



	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}



	public String getStu_tel() {
		return stu_tel;
	}



	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}



	public String getStu_add() {
		return stu_add;
	}



	public void setStu_add(String stu_add) {
		this.stu_add = stu_add;
	}



	public String getStu_state() {
		return stu_state;
	}



	public void setStu_state(String stu_state) {
		this.stu_state = stu_state;
	}



	public String getStu_date() {
		return stu_date;
	}


	public void setStu_date(String stu_date) {
		this.stu_date = stu_date;
	}



	public String getStu_birth() {
		return stu_birth;
	}



	public void setStu_birth(String stu_birth) {
		this.stu_birth = stu_birth;
	}



	public SSStudentVO() {
		
	}



}
