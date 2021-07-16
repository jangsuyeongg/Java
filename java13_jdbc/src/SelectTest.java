import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		try {
		//1. JVM 에 jdbc드라이브 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc 드라이브 로딩 실패 -->" + cnfe.getMessage());
		}
			
		try {
			//2. DB연결						서버ip,localhost port 전역데이터베이스변수
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
														//dbserver, 계정, 비번
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			//3. 쿼리문을 만든다. "문자열"
			String sql = "select empno, ename, job, to_char(hiredate,'YYYY-MM-DD')hiredate, sal, comm, deptno"
						+ " from emp where sal>=? or job=? order by ename";
			
			//4. 쿼리문을 이용하여 preparedStatement 객체생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//?를 셋팅
			pstmt.setInt(1, 3000);
			pstmt.setString(2, "세일즈");
			
			
			//5.실행하기
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//한쪽의 레코드를 처리한다.
				int empno = rs.getInt(1);//rs.getInt("empno");
				String ename = rs.getString(2);//rs.getString("ename");
				String job = rs.getString("job");//3
				String hiredate = rs.getString(4);
				int sal = rs.getInt(5);
				double comm = rs.getDouble(6); 
				int deptno=rs.getInt(7);
				
				System.out.println(empno +", "+ename+", "+job+", "+hiredate+", "+sal+", "+comm+", "+deptno);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(SQLException se) {
			System.out.println("DB연결 에러 발생--->"+ se.getMessage());
		}
	}
	public static void main(String[] args) {
		new SelectTest();
	}
}
