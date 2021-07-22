
import java.util.Scanner;

public class DeleteStudent extends DBConnection{

	public DeleteStudent() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("������ �л��̸�=");
			String student_name = scan.nextLine();
			
			//DB����
			dbConn();
	
			sql = "delete from student where student_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"���� ���ڵ尡 �����Ǿ����ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public static void main(String[] args) {
		new DeleteStudent(); 
	}
}
