import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEmpList extends JFrame{

	JTable table;
	DefaultTableModel model;
	String title[] = {"사원명","급여","보너스","입사일"}; 
	JScrollPane sp; 
	
	static {
		//멤버영역이지만 실행문을 표기할수있는 영역이 된다. 
		try {
			//1. JVM 에 jdbc드라이브 로딩 
			//그럼 객체로만들어서 자바가상머신이 객체를 활용한다. 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException cnfe) {
				System.out.println("jdbc 드라이브 로딩 실패 -->" + cnfe.getMessage());
			}
	}
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##scott";
	String password = "tiger";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public JTableEmpList() {
		model = new DefaultTableModel(title,0);
		table = new JTable(); // new JTable(model);
		table.setModel(model);
		
		sp = new JScrollPane(table);
		add(sp);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		 empAllSelect();
	}
		public void empAllSelect(){
			//1. 드라이브로딩
			try {
			//2. DB연결
			 conn = DriverManager.getConnection(url,username,password);
			 //3. Statement 생성(sql문)
			 String sql = "select ename, sal, comm, to_char(hiredate, 'YYYY-MM-DD')hiredate from emp order by hiredate";
			 pstmt = conn.prepareStatement(sql);
			 //4. 실행
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 Object[] emp = {rs.getString(1),rs.getInt(2), rs.getInt(3), rs.getString(4)};
				 model.addRow(emp);
			 }
			 //5. 닫기
		}catch(Exception e) {

				System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(SQLException s) {
				System.out.println("닫기 예외 발생");	
			}
		}
	}
	public static void main(String[] args) {
		new JTableEmpList();
		

	}

}
