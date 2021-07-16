import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableSelectEx extends JFrame{
	
	JTable table;
	JScrollPane sp; 
	DefaultTableModel model;
	
	String title[] = {"사원명","급여","보너스","입사일"}; 
	Object[][] data= {};
	
	public JTableSelectEx() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
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
			String sql = "select ename, sal, comm, to_char(hiredate,'YYYY-MM-DD')hiredate from emp";
					

			//4. 쿼리문을 이용하여 preparedStatement 객체생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//5.실행하기
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			
				String ename = rs.getString(1);
				int sal = rs.getInt(2);
				double comm = rs.getDouble(3); 
				String hiredate = rs.getString(4);
				

			Object [] row = {ename,sal,comm,hiredate};
			model.addRow(row);	
				
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(SQLException se) {
			System.out.println("DB연결 에러 발생--->"+ se.getMessage());
		}
	}

	public static void main(String[] args) {
		new  JTableSelectEx();
	}
}