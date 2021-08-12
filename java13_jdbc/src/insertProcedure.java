import java.sql.CallableStatement;
import java.sql.Types;

public class insertProcedure extends DBConnection{

	public insertProcedure() {
		try {
			//1. db����
			dbConn();
			
			sql="{call mem_insert(?,?,?) }";
			CallableStatement cstmt = con.prepareCall(sql);	
			
			cstmt.setString(1, "ȫ�浿");
			cstmt.setString(2, "010-8888-9999");
			cstmt.registerOutParameter(3, Types.INTEGER);
			
			cstmt.executeUpdate();
			
			if(cstmt.getInt(3)==1) {
				System.out.println("���ڵ尡 �߰��Ǿ����ϴ�");
			}else {
				System.out.println("�߰�����");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new insertProcedure();

	}

}
