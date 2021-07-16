
public class TransactionTest extends DBConnection {

	public TransactionTest() {
		try {
			dbConn();
			
			//자동 Commit해제하기
			con.setAutoCommit(false);//true: 자동커밋, false:자동커밋해제
			int abank= -5000, bbank=5000;
			
			//출금
			sql="insert into a_bank(num,money) values(a_number.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, abank);
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(Math.abs(abank) +"원이 출금되었습니다.");
			}else {
				System.out.println(Math.abs(abank)+"원 출금이 실패하였습니다.");
			}
			if(cnt>0) throw new Exception();
			
			//입금
			sql = "insert into b_bank(num, money) values(b_number.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbank);
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println(Math.abs(bbank)+"원이 입금되었습니다.");
			}else {
				System.out.println(Math.abs(bbank)+"원 입금이 실패하였습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			}catch(Exception ee) {}
		}finally {
			dbClose();
		}
		
	}
	public static void main(String[] args) {
		new TransactionTest();
	}
}
