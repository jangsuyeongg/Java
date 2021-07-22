import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class InsertStudent extends DBConnection {

	public InsertStudent() {
		
	}
	
	public InsertStudent(String[] data, JPanel centerPane) {

		try {
			int student_number = Integer.parseInt(data[0]);
			String student_name = data[1];
			String student_grade = data[2];
			String student_state= data[3];
			String student_email = data[4];
			String student_phone = data[5];
			String student_address= data[6];
			int student_birthDay= Integer.parseInt(data[7]);
			String student_pw = data[8];
			//DB연결
			dbConn();
			
			//DB에 저장
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
			String sql = "insert into student(student_number,student_name,student_grade,student_date,"
					+ "student_state,major_number,student_email,student_phone, "
					+ "student_address,student_birthDay, student_pw)"
					+ " values(?,?,?,sysdate,?,10,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			//? 값세팅
			pstmt.setInt(1, student_number);
			pstmt.setString(2, student_name);
			pstmt.setString(3, student_grade);
			pstmt.setString(4, student_state);
			pstmt.setString(5, student_email);
			pstmt.setString(6, student_phone);
			pstmt.setString(7, student_address);
			pstmt.setInt(8, student_birthDay);
			pstmt.setString(9, student_pw);

			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				JOptionPane op = new JOptionPane();
				op.showMessageDialog(centerPane, "레코드가 추가 되었습니다!!!", "성공!", JOptionPane.PLAIN_MESSAGE);
			}else {
				System.out.println("레코드 추가 실패");
			}

		}catch(SQLException s) {
			System.out.println("데이터베이스 연결 에러발생 --->"+ s.getMessage());
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new InsertStudent();
	}
}
