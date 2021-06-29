package EmpInfor;

public class EmpVO {
	private String empNo;//사원번호
	private String empName;//사원명
	private String tel;//연락처
	private int sal;//급여
	private String hiredate;//입사일
	
	
	public EmpVO() {
		
	}
	//생성자
	public EmpVO(String empNo, String empName, String tel, int sal, String hiredate) {
		this.empNo = empNo;
		this.empName = empName;
		this.tel = tel;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	// 사원1명 출력 ======================
	public void empPrint() {
		System.out.printf("%10s %10s %20s %10d %15s\n", empNo, empName, tel, sal, hiredate);
	}
	// 타이틀 출력
	public static void titlePrint() {
		System.out.printf("%10s %10s %13s %12s %12s\n","사원번호","사원명","연락처","급여","입사일");
		System.out.println("----------------------------------------------------------------------");
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
