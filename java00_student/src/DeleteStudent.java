
import java.util.Scanner;

public class DeleteStudent extends DBConnection{

	public DeleteStudent() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 학생이름=");
			String student_name = scan.nextLine();
			
			//DB연결
			dbConn();
	
			sql = "delete from student where student_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"개의 레코드가 삭제되었습니다.");
			
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
