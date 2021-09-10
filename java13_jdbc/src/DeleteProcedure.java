import java.sql.CallableStatement;
import java.sql.Types;

public class DeleteProcedure extends DBConnection {

	public DeleteProcedure() {
		try {
			dbConn();
			
			sql = "{call mem_del(?,?)}";
			
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, "홍길동");
			cstmt.registerOutParameter(2, Types.INTEGER);
			
			cstmt.executeUpdate();
			
			if(cstmt.getInt(2)==1) {
				System.out.println("회원을 삭제하였습니다.");
			}else {
				System.out.println("삭제 실패...");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteProcedure();

	}

}
